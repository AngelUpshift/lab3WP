package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

@Repository
public class EventBookingRepository {

    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        return new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
    }
}
