package com.ai_travel.tripservice.Controllers;

import com.ai_travel.tripservice.Dao.*;
import com.ai_travel.tripservice.Entities.*;
import com.ai_travel.tripservice.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/trips")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DestRepository destRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{userName}/{tripName}/add-booking")
    public ResponseEntity<Booking> addBooking(@PathVariable("userName") String userName,@PathVariable("tripName")String tripName, @RequestBody Booking booking) {
        Users user = this.userRepository.findUserByUserName(userName);
        Trip trip = this.tripRepository.findTripByTripName(tripName);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if(trip==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            booking.setTrip(trip);
            if (user.getBookings().isEmpty()) {
                Set<Booking> bookingSet = new HashSet<>();
                bookingSet.add(booking);
                user.setBookings(bookingSet);
            } else {
                user.getBookings().add(booking);
            }
            booking.setUser(user);
            bookingRepository.save(booking);
            bookingService.saveBookingToTrip(booking);
        }
        return ResponseEntity.ok(booking);

    }

    @GetMapping("/{tripName}/get-total-bookings")
    public ResponseEntity<Integer> getBookingsInTrip(@PathVariable("tripName") String tripName) {
        Trip trip = tripRepository.findTripByTripName(tripName);
        if (trip != null) {
            return ResponseEntity.ok(trip.getBookings().size());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping("/create-Trip")
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        Set<Destination> destination = trip.getDestinations();
//        try {
//            for (Destination d : destination) {
//
//                this.destRepository.save(d);
//                Set<Activity> activities = d.getActivities();
//                for (Activity a : activities) {
//                    a.setDestination(d);
//                    this.activityRepository.save(a);
//
//                }
//                this.tripRepository.save(trip);
//                d.setTrip(trip);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return ResponseEntity.ok(this.tripRepository.save(trip));
    }

    @PostMapping("/{userName}/{destName}/give-review")
    public ResponseEntity<Reviews> giveReview(@RequestBody Reviews reviews, @PathVariable("userName") String userName, @PathVariable("destName") String name) {
        Users user = this.userRepository.findUserByUserName(userName);

        Set<Reviews> reviews1 = new HashSet<>();
        reviews1.add(reviews);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            Destination destination = this.destRepository.findDestinationByName(name);
            if (destination != null) {
                reviews.setDestination(destination);
                reviews.setUsers(user);
            }
            if (destination.getReviews().isEmpty()) {
                destination.setReviews(reviews1);
            } else {
                destination.getReviews().add(reviews);
            }

            if (user.getReviews().isEmpty()) {
                user.setReviews(reviews1);
            } else {
                user.getReviews().add(reviews);
            }
            return ResponseEntity.ok(this.reviewRepository.save(reviews));
        }
    }
}

