package com.ai_travel.tripservice.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Table
@Entity(name = "DESTINATION")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    @Id
    @GeneratedValue
    private long Did;

    private String name;

    private String country;

    private String city;
    private String description;
    private int popularityScore;
    private long averageCost;
    private String Category;

    @ManyToOne()
    @JsonBackReference(value = "Trip")
    private Trip trip;


    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Destination")
    private Set<Reviews> reviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference(value = "Destination")
    private Set<Activity> activities;

}
