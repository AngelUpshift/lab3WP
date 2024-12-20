package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public String address;

    public String capacity;

    @Column(length = 4000)
    public String description;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
    private List<Event> events;

    public Location(String address, String name, String capacity, String description) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;

        this.events = new ArrayList<>();
    }

    public Location() {

    }
}
