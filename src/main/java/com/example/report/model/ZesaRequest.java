package com.example.report.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ZesaRequest {

    private String details;
    private ZesaCategories faultCategories;
    private Status status;
    private MultipartFile image;
    private LocalDateTime dateTime;
    private String lattitude;
    private String longitude;
    private Recipient recipient;
}
