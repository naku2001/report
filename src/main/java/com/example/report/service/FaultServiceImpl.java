package com.example.report.service;

import com.example.report.model.ReportRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FaultServiceImpl implements FaultService {
    @Override
    public ResponseEntity reportFault(ReportRequest request) {
        return null;
    }
}
