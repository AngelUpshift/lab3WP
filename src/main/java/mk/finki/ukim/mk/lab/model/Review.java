package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Review {
    @Column(length = 4000)
    @Getter
    @Setter
    public String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    public long id;
    @Getter
    @Setter
    public double grade;

    public Review(String description, double grade) {
        this.description = description;
        this.grade = grade;
    }

    public Review() {

    }
}
