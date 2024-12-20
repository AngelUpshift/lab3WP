package mk.finki.ukim.mk.lab.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    private final EventBookingImpl eventBookingimpl;

    public EventBookingController(EventBookingImpl eventBookingimpl) {
        this.eventBookingimpl = eventBookingimpl;
    }

    @GetMapping
    public String getEventBooking () {
        return "bookingConfirmation";
    }

    @PostMapping
    public String addEventBooking(HttpServletRequest request) {
        String eventName = request.getParameter("eventName");
        long numTickets = Long.parseLong(request.getParameter("numTickets"));

        System.out.println("Num Tickets: " + numTickets);
        System.out.println("Event name: " + eventName);


        EventBooking eventBooking1 = eventBookingimpl.placeBooking(eventName, "Petko", "", numTickets);

        request.setAttribute("eventName", eventBooking1.eventName);
        request.setAttribute("numTickets", eventBooking1.numberOfTickets);

            return "bookingConfirmation";
    }
}
