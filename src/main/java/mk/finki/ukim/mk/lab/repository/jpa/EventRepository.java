package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e")
    List<Event> findAll();
    List<Event> findAllByName(String name);
    List<Event> findEventsByPopularityScore(double rating);
    void deleteById(long id);
    Event findById(long id);
    @Query("SELECT e FROM Event e WHERE e.location.id = :locationId")
    List<Event> findAllByLocationId(Long locationId);
}
