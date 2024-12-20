package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepo {
    public List<Review> reviews;

    public ReviewRepo() {
        reviews = new ArrayList<>();

        reviews.add(new Review("dsakdpoaso", 0));
        reviews.add(new Review("dsadoaskodpsak", 0));
        reviews.add(new Review("dasdkpasoddksadsaokp", 0));
    }
}
