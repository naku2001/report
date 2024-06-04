package com.example.report.model;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile image;
    private LocalDateTime dateTime;
    private String location;
    private Recipient recipient;
}
