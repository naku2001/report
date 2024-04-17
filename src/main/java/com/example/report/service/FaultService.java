package com.example.report.service;

import com.example.report.model.FaultCategories;
import com.example.report.model.ReportRequest;
import com.example.report.model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Component
public interface FaultService {
    ResponseEntity reportFault(ReportRequest request);


    ResponseEntity deleteFault(Long id);

    ResponseEntity getAll();

    ResponseEntity getAllByStatus(Status status);

    ResponseEntity updateFault(Long id, ReportRequest request);

    ResponseEntity updateFaultStakeholder(Long id,StakeholderReportRequest request);


    ResponseEntity getById(Long id);

    ResponseEntity getAllByCategory(FaultCategories faultCategories);
//    ResponseEntity assignById(Long id,ReportRequest request);


    ResponseEntity getAllByYear(String year);
}
