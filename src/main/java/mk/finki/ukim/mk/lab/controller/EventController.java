package mk.finki.ukim.mk.lab.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.Review;
import mk.finki.ukim.mk.lab.service.EventServiceImplement;
import mk.finki.ukim.mk.lab.service.LocationSeviceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {
        private final EventServiceImplement eventServiceImplement;
        private final LocationSeviceImpl locationSeviceimpl;


        public EventController(EventServiceImplement eventServiceImplement, LocationSeviceImpl locationSeviceimpl) {
                this.eventServiceImplement = eventServiceImplement;
                this.locationSeviceimpl = locationSeviceimpl;
        }

        @GetMapping
        public String getEventsPage(HttpServletRequest request) {
                List<Location> locationList = locationSeviceimpl.findAll();
                List<Event>events = eventServiceImplement.findAll();

                request.setAttribute("locations", locationList);
                request.setAttribute("events", events);

                Authentication auth = SecurityContextHolder.getContext().getAuthentication();

                request.setAttribute("authenticated", auth.getName());

                return "listEvents";
        }

        @GetMapping("/add")
        public String getEventsAddPage(HttpServletRequest request) {
                List<Location> locationList = locationSeviceimpl.findAll();
                request.setAttribute("locations", locationList);

                String actionUrl = "/events/add";
                request.setAttribute("actionUrl", actionUrl);

                return "add-event";
        }

        @PostMapping("/add")
        public String saveEvent(HttpServletRequest request) {
                String eventDesc = request.getParameter("eventDesc");
                String eventName = request.getParameter("eventName");
                double eventScore = Double.parseDouble(request.getParameter("eventScore"));
                long locationId = Long.parseLong(request.getParameter("location"));

//                Review review = new Review("not reviewed", 0);
                Location location = locationSeviceimpl.findById(locationId);

                Optional<Event> events = eventServiceImplement.save(eventName, eventDesc, eventScore, location);

                if(events.isPresent()) {
                   List<Event> allEvents = eventServiceImplement.findAll();
                   request.setAttribute("events", allEvents);
                   return "listEvents";
                }
                return null;
        }

        @GetMapping("/edit/{id}")
        public String getEventsEditPage(@PathVariable("id") long id, HttpServletRequest request) {
                Event eventWithId = eventServiceImplement.findById(id);
                List<Location> locationList = locationSeviceimpl.findAll();
                request.setAttribute("locations", locationList);
                request.setAttribute("eventName", eventWithId.name);
                request.setAttribute("eventDesc", eventWithId.description);
                request.setAttribute("eventScore", eventWithId.popularityScore);
                request.setAttribute("location", eventWithId.getLocation().name);

                String actionUrl = "/events/edit/" + eventWithId.id;
                request.setAttribute("actionUrl", actionUrl);

                return "add-event";
        }

        @PostMapping("/edit/{id}")
        public String editEvent(@PathVariable("id") long id, HttpServletRequest request) {
                String eventDesc = request.getParameter("eventDesc");
                String eventName = request.getParameter("eventName");
                double eventScore = Double.parseDouble(request.getParameter("eventScore"));
                long locationId = Long.parseLong(request.getParameter("location"));

                Location location = locationSeviceimpl.findById(locationId);
                Optional<Event> events = eventServiceImplement.editEvent(id, eventName, eventDesc, eventScore, location);
                if(events.isPresent()) {
                    List<Event> newList = eventServiceImplement.findAll();
                    request.setAttribute("events", newList);

                    return "listEvents";
                }
                return null;
        }



//        @PostMapping("/delete/{id}")
//        public String deleteEvent(@PathVariable("id") long id,  HttpServletRequest request) {
//                List<Event> events = eventServiceImplement.deleteEvent(id);
//
//                if(events.isEmpty()) {
//                        request.setAttribute("message", "No events available.");
//                }
//
//                request.setAttribute("events", events);
//
//                return "listEvents";
//        }

        @PostMapping
        public String filterByRatingOrName(HttpServletRequest request) {
                String filterName = request.getParameter("filterByNameOrDesc");
                String rating = request.getParameter("filterByRating");
                String location = request.getParameter("location");

                if(!filterName.isEmpty()) {
                    List<Event> filteredEvents = eventServiceImplement.findAllByName(filterName);
                        request.setAttribute("events", filteredEvents);
                }
                if(!rating.isEmpty()) {
                    double filterRating = Double.parseDouble(request.getParameter("filterByRating"));
                    List<Event> filteredEvents = eventServiceImplement.findEventsByPopularityScore(filterRating);
                        request.setAttribute("events", filteredEvents);
                }
                if(location != null) {
                    long locationId = Long.parseLong(location);

                    List<Event> filteredEvents = eventServiceImplement.findAllByLocation_Id(locationId);
                    request.setAttribute("events", filteredEvents);
                }

                return "listEvents";
        }

        @GetMapping("/review/{id}")
        public String reviewEvent(@PathVariable("id") long id, HttpServletRequest request) {
                Event eventWithId = eventServiceImplement.findById(id);

                String actionUrl = "/events/review/" + eventWithId.id;
                request.setAttribute("actionUrlReview", actionUrl);

                return "reviewpage";
        }

        @PostMapping("/review/{id}")
        public String addReviewEvent(@PathVariable("id") long id, HttpServletRequest request) {
                String reviewName = request.getParameter("reviewDesc");
                double reviewScore = Double.parseDouble(request.getParameter("reviewScore"));

                Event event = eventServiceImplement.findById(id);

//                Optional<Event> eventslist = eventServiceImplement.reviewEvent(id, event.name, event.description, event.popularityScore, event.getLocation(), new Review(reviewName, reviewScore));
//                request.setAttribute("events", eventslist);

                return "listEvents";
        }
}
