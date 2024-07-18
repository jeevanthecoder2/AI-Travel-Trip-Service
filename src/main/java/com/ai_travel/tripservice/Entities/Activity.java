package com.ai_travel.tripservice.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

@Table
@Entity(name = "ACTIVITY")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue
    private long Aid;

    private String name;

    private String type;

    private long cost;

    private String description;

    @ManyToOne
    @JsonBackReference(value = "Destination")
    private Destination destination;
}
