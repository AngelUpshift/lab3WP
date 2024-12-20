//package mk.finki.ukim.mk.lab.controller;
//
//import jakarta.servlet.http.HttpServletRequest;
//import mk.finki.ukim.mk.lab.model.Location;
//import mk.finki.ukim.mk.lab.service.LocationSeviceImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/location")
//public class LocationController {
//    private final LocationSeviceImpl locationSeviceimpl;
//
//    public LocationController(LocationSeviceImpl locationSeviceimpl) {
//        this.locationSeviceimpl = locationSeviceimpl;
//    }
//
//    @GetMapping
//    public String getLocations (HttpServletRequest req) {
//        List<Location> locationList = locationSeviceimpl.findAll();
//        req.setAttribute("locations", locationList);
//        System.out.println("locationslist" + locationList);
//
//        return "add-event";
//    }
//}
