package com.example.report.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "fault")
public class Fault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String details;
    private FaultCategories faultCategories;
    private String image;
    private LocalDateTime dateTime;
    private Status status;
    private Crew crew;
    private  Priority priority;
    private String location;

}
