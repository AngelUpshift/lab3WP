package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "events")
public class Event {
    @Getter
    @Setter
    public String name;

    @Column(length = 4000)
    @Getter
    @Setter
    public String description;

    @Getter
    @Setter
    public double popularityScore;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    public long id;

    @ManyToOne
    @Getter
    @Setter
    private Location location;

//    @ManyToOne
//    @Getter
//    @Setter
//    private Review review;

    public Event(String name, String description, double popularityScore, Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
//        this.review = review;
    }

    public Event() {

    }
}
