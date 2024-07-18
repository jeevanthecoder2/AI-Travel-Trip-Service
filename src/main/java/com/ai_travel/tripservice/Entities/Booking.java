package com.ai_travel.tripservice.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity(name = "BOOKING")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private long bookingId;
    @Column(unique = true)
    private String bookingName;

    private String bookingState;

    private String cost;

    private String bookingStatus;

    @ManyToOne
    @JsonBackReference(value = "Booking")
    private Users user;

    @ManyToOne
    @JsonBackReference
    private Trip trip;
}
