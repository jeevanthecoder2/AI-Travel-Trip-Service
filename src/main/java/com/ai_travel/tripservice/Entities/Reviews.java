package com.ai_travel.tripservice.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Table
@Entity(name = "REVIEWS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue
    private long Rid;

//    private String userName;

    private int rating;

    private String comment;

    private Date date;
    private Time time;

    @ManyToOne
    @JsonBackReference(value = "Review")
    private Users users;


    @ManyToOne
    @JsonBackReference(value = "Destination")
    private Destination destination;

}
