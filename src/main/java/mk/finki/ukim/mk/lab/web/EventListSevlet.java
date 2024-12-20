//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.service.EventServiceImplement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "EventListSevlet", urlPatterns = "/events")
//public class EventListSevlet extends HttpServlet {
//    private final EventServiceImplement eventServiceImplement;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    @Autowired
//    public EventListSevlet(EventServiceImplement eventServiceImplement, SpringTemplateEngine springTemplateEngine) {
//        this.eventServiceImplement = eventServiceImplement;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            List<Event> events = eventServiceImplement.listAll();
//            req.setAttribute("events", events);
//
//            IWebExchange webExchange = JakartaServletWebApplication
//                    .buildApplication(getServletContext())
//                    .buildExchange(req, resp);
//            WebContext webContext = new WebContext(webExchange);
//
//            springTemplateEngine.process("listEvents.html", webContext, resp.getWriter());
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String filterName = req.getParameter("filterByNameOrDesc");
//        String rating = req.getParameter("filterByRating");
//
//        if(!filterName.isEmpty()) {
//            List<Event> filteredEvents = eventServiceImplement.searchEvents(filterName);
//            req.setAttribute("events", filteredEvents);
//        }
//        if(!rating.isEmpty()) {
//            int filterRating = Integer.parseInt(req.getParameter("filterByRating"));
//            List<Event> filteredEvents = eventServiceImplement.searchEventsByRating(filterRating);
//            req.setAttribute("events", filteredEvents);
//        }
//
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//
//        springTemplateEngine.process("listEvents.html", webContext, resp.getWriter());
//    }
//}
