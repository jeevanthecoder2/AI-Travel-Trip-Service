package com.ai_travel.tripservice.Service;

import com.ai_travel.tripservice.Dao.BookingRepository;
import com.ai_travel.tripservice.Dao.TripRepository;
import com.ai_travel.tripservice.Entities.Booking;
import com.ai_travel.tripservice.Entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookingService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBookingToTrip(Booking booking){
        Trip trip = tripRepository.findTripByTripName(booking.getTrip().getTripName());
        if(trip!=null){
            if(!trip.getBookings().isEmpty()){
                trip.getBookings().add(booking);
            }else{
                Set<Booking> bookingSet = new HashSet<>();
                bookingSet.add(booking);
                trip.setBookings(bookingSet);
            }
            this.tripRepository.save(trip);
        }

    }
}
