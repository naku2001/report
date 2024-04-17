package com.example.report.service;

import com.example.report.model.Crew;
import com.example.report.model.Priority;
import com.example.report.model.Status;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StakeholderReportRequest {

    private Status status;
    private Crew crew;
    private Priority priority;


}
