package com.example.report.controller;


import com.example.report.model.Image;
import com.example.report.model.ReportRequest;
import com.example.report.model.Request;
import com.example.report.model.SystemConstants;
import com.example.report.repo.ImageRepo;
import com.example.report.service.FaultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Objects;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/faults")
public class Faults {

private final FaultService faultService;

private final ImageRepo fileRepository;
    @GetMapping("getAllMuniPending")
    public ResponseEntity getAllMP(){
        return  faultService.pendingMuni();
    }
    @GetMapping("getAllMuniRecieved")
    public ResponseEntity getAllMR(){
        return  faultService.recievedMuni();
    }
    @GetMapping("getAllMuniResolved")
    public ResponseEntity getAllMResolved(){
        return  faultService.resolvedMuni();
    }
    @GetMapping("getAllZesaPending")
    public ResponseEntity getAllZP(){
        return  faultService.pendingZesa();
    }
    @GetMapping("getAllZesaRecieved")
    public ResponseEntity getAllZR(){
        return  faultService.recievedZesa();
    }
    @GetMapping("getAllZesaResolved")
    public ResponseEntity getAllZResolved(){
        return  faultService.resolvedZesa();
    }
    @GetMapping("getAllFaults")
    public ResponseEntity getAllFaults(){
        return  faultService.getAllFaults();
    }
@PostMapping("report")
public ResponseEntity reportFault(@RequestBody ReportRequest request) throws IOException {
    return faultService.reportFault(request);
    }

@DeleteMapping("/delete/{id}")
public  ResponseEntity deleteFault(@PathVariable Long id){
    return faultService.deleteFault(id);
}
@GetMapping("getAllMuni")
public ResponseEntity getAll(){
    return  faultService.getAll();
}
@GetMapping("getAllZesa")
public ResponseEntity getAllZesa(){
        return  faultService.getAllZesa();
    }
@GetMapping("hello")
public String hello(){
        return  "HelloWorld";
    }
@PutMapping("/update/{id}")
public ResponseEntity updateFault(@PathVariable Long id, @RequestBody Request request){
    return faultService.updateFault(id,request);
}
@GetMapping("/getById/{id}")
public ResponseEntity getById(@PathVariable Long id){
        return  faultService.getById(id);
    }

    public String generateRandomString(int length) {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();

    }




}
