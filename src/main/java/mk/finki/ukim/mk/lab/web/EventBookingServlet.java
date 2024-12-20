//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.model.InvalidBookingCredentialsException;
//import mk.finki.ukim.mk.lab.service.EventBookingImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "EventBookingServlet", urlPatterns = "/eventBooking")
//public class EventBookingServlet extends HttpServlet {
//    private final EventBookingImpl eventBooking;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventBookingServlet(EventBookingImpl eventBooking, SpringTemplateEngine springTemplateEngine) {
//        this.eventBooking = eventBooking;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange iWebExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext webContext = new WebContext(iWebExchange);
//
//        springTemplateEngine.process("bookingConfirmation.html", webContext, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String eventName = req.getParameter("eventName");
//        long numTickets = Long.parseLong(req.getParameter("numTickets"));
//        System.out.println("Num Tickets: " + numTickets);  // Log the value
//        System.out.println("Event name: " + eventName);
//
//        try {
//            EventBooking eventBooking1 = eventBooking.placeBooking(eventName, "Petko", "", numTickets);
//
//            // Set the numTickets in the request attribute
//            req.setAttribute("eventName", eventBooking1.eventName);
//            req.setAttribute("numTickets", eventBooking1.numberOfTickets);
//
//            // Build the web context
//            IWebExchange iWebExchange = JakartaServletWebApplication
//                    .buildApplication(getServletContext())
//                    .buildExchange(req, resp);
//
//            WebContext webContext = new WebContext(iWebExchange);
//
//            // Make sure the numTickets is set in the context
//            webContext.setVariable("eventName", eventName);
//            webContext.setVariable("numTickets", numTickets);
//
//            // Process the template
//            springTemplateEngine.process("bookingConfirmation.html", webContext, resp.getWriter());
//
//        } catch (InvalidBookingCredentialsException ex) {
//            IWebExchange iWebExchange = JakartaServletWebApplication
//                    .buildApplication(getServletContext())
//                    .buildExchange(req, resp);
//
//            WebContext webContext = new WebContext(iWebExchange);
//
//            webContext.setVariable("hasError", true);
//            webContext.setVariable("error", ex.getMessage());
//
//            springTemplateEngine.process("bookingConfirmation.html", webContext, resp.getWriter());
//        }
//    }
//}
