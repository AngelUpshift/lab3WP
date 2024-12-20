package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.InvalidBookingCredentialsException;
import mk.finki.ukim.mk.lab.repository.EventBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class EventBookingImpl implements EventBookingService {
    private final EventBookingRepository eventBookingRepository;

    public EventBookingImpl (EventBookingRepository eventBooking) {
        this.eventBookingRepository = eventBooking;
    }
    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, long numberOfTickets) {
        if(eventName == null || eventName.isEmpty() || attendeeName == null || attendeeName.isEmpty()) {
            throw new InvalidBookingCredentialsException();
        }
        else {
            return eventBookingRepository.placeBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
        }
    }
}
