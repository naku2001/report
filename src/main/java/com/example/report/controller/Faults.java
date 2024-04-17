package com.example.report.controller;


import com.example.report.model.FaultCategories;
import com.example.report.model.ReportRequest;
import com.example.report.model.Status;
import com.example.report.service.FaultService;
import com.example.report.service.StakeholderReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
@DeleteMapping("/delete/{id}")
public  ResponseEntity deleteFault(@PathVariable Long id){
    return faultService.deleteFault(id);
}
@GetMapping("getAll")
public ResponseEntity getAll(){
    return  faultService.getAll();
}

    @GetMapping("getAllByStatus")
    public ResponseEntity getAllByStatus(Status status){
        return  faultService.getAllByStatus(status);
    }

    @GetMapping("getAllByCategory")
    public ResponseEntity getAllByCategory(FaultCategories faultCategories){
        return  faultService.getAllByCategory(faultCategories);
    }


        @GetMapping("getAllByYear")
    public ResponseEntity getAllByYear(String year){
        return  faultService.getAllByYear(year);
    }
@PutMapping("/update/{id}")
public ResponseEntity updateFault(@PathVariable Long id, @RequestBody ReportRequest request){
    return faultService.updateFault(id,request);
}
@GetMapping("/getById/{id}")
public ResponseEntity getById(@PathVariable Long id){
        return  faultService.getById(id);
    }


@PutMapping("/updateStakeholderFault/{id}")
public  ResponseEntity updateStakeholderFault(@PathVariable Long id, StakeholderReportRequest request){
    return faultService.updateFaultStakeholder(id,request);
}


}







