package com.example.report.model;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReportRequest {

    private String details;
    private FaultCategories faultCategories;
    private Status status;
    private String image;
    private LocalDateTime dateTime;
}
