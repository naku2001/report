package com.example.report.service;

import com.example.report.model.ReportRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Component
public interface FaultService {
    ResponseEntity reportFault(ReportRequest request) throws IOException;


    ResponseEntity deleteFault(Long id);

    ResponseEntity getAll();

    ResponseEntity updateFault(Long id,ReportRequest request);


    ResponseEntity getById(Long id);
}
