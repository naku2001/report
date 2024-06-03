package com.example.report.service;

import com.example.report.model.*;
import com.example.report.repo.FaultRepo;
import com.example.report.repo.ImageRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FaultServiceImpl implements FaultService {

    private final FaultRepo faultRepo;

    private final ImageRepo imageRepo;

    public FaultServiceImpl(FaultRepo faultRepo, ImageRepo imageRepo) {
        this.faultRepo = faultRepo;
        this.imageRepo = imageRepo;
    }

    @Override
    public ResponseEntity reportFault(ReportRequest request)  {

//        Fault fault = new Fault();
//        fault.setStatus(Status.RECEIVED);
//        fault.setFaultCategories(request.getFaultCategories());
//        fault.setDetails(request.getDetails());
//        fault.setDateTime(LocalDateTime.now());
//        fault.
////        fault.setImage(request.getImage().getContentType());
//////        fault.setLocation(request.getLocation());
////        fault.setRecipient(request.getRecipient());
//        Fault postedFault = faultRepo.save(fault);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public ResponseEntity deleteFault(Long id) {
        Optional<Fault> fault = faultRepo.findById(id);
        if(!fault.isPresent())
            return ResponseEntity.ok().body("Fault not found");
        faultRepo.deleteById(fault.get().getId());
        return ResponseEntity.ok().body(fault);
    }

    @Override
    public ResponseEntity getAll() {
        List<Fault> faultList = faultRepo.findAll();
        return ResponseEntity.ok().body(faultList);
    }

    @Override
    public ResponseEntity updateFault(Long id, ReportRequest request) {
        Optional<Fault> fault = faultRepo.findById(id);
        if(!fault.isPresent())
            return ResponseEntity.ok().body("Fault not found");
        Fault faultUpdate = fault.get();
        faultUpdate.setStatus(Status.RECEIVED);
        faultUpdate.setFaultCategories(request.getFaultCategories());
        faultUpdate.setDetails(request.getDetails());
        Fault faultUpdated = faultRepo.save(faultUpdate);
        return ResponseEntity.ok().body(faultUpdated);


    }

    @Override
    public ResponseEntity getById(Long id) {
        Optional<Fault> fault = faultRepo.findById(id);
        if(!fault.isPresent())
            return ResponseEntity.ok().body("Fault not found");
        return ResponseEntity.ok().body(fault);
    }


}
