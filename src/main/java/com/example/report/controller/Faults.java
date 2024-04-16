package com.example.report.controller;


import com.example.report.model.ReportRequest;
import com.example.report.service.FaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/faults")
public class Faults {

private final FaultService faultService;

@PostMapping("report")
public ResponseEntity reportFault(@RequestBody ReportRequest request){
        return faultService.reportFault(request);
    }


}
