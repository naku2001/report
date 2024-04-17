package com.example.report.service;

import com.example.report.model.ReportRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface FaultService {
    ResponseEntity reportFault(ReportRequest request);


    ResponseEntity deleteFault(Long id);

    ResponseEntity getAll();

    ResponseEntity updateFault(Long id,ReportRequest request);


    ResponseEntity getById(Long id);
}
