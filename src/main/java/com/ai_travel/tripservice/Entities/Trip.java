package com.ai_travel.tripservice.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Table
@Entity(name = "TRIP")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @GeneratedValue
    private long tripId;

    @Column(unique = true)
    private String tripName;

    private Date startDate;
    private Time startTime;

    private Date endDate;
    private Time endTime;

    private long budget;

    private String tripPreferences;

    private String tripStatus;

    @ManyToOne
    @JsonBackReference(value = "Trip")
    private Users user;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Booking> bookings;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Trip")
    private Set<Destination> destinations;

}
