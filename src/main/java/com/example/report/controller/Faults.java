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
@DeleteMapping("/delete/{id}")
public  ResponseEntity deleteFault(@PathVariable Long id){
    return faultService.deleteFault(id);
}
@GetMapping("getAll")
public ResponseEntity getAll(){
    return  faultService.getAll();
}
@PutMapping("/update/{id}")
public ResponseEntity updateFault(@PathVariable Long id, @RequestBody ReportRequest request){
    return faultService.updateFault(id,request);
}
@GetMapping("/getById/{id}")
public ResponseEntity getById(@PathVariable Long id){
        return  faultService.getById(id);
    }






}
