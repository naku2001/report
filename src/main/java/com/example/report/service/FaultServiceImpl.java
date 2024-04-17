package com.example.report.service;

import com.example.report.model.Fault;
import com.example.report.model.FaultCategories;
import com.example.report.model.ReportRequest;
import com.example.report.model.Status;
import com.example.report.repo.FaultRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FaultServiceImpl implements FaultService {

    private final FaultRepo faultRepo;

    public FaultServiceImpl(FaultRepo faultRepo) {
        this.faultRepo = faultRepo;
    }

    @Override
    public ResponseEntity reportFault(ReportRequest request) {
        Fault fault = new Fault();
        fault.setStatus(Status.RECEIVED);
        fault.setFaultCategories(request.getFaultCategories());
        fault.setDetails(request.getDetails());
        fault.setImage(request.getImage());
        fault.setDateTime(LocalDateTime.now());
        Fault postedFault = faultRepo.save(fault);
        return ResponseEntity.ok().body(postedFault);
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
    public ResponseEntity getAllByStatus(Status status) {
        List<Fault> faultList = faultRepo.findFaultsByStatus(status);
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
        faultUpdate.setImage(request.getImage());
        Fault faultUpdated = faultRepo.save(faultUpdate);
        return ResponseEntity.ok().body(faultUpdated);


    }

    @Override
    public ResponseEntity updateFaultStakeholder(Long id, StakeholderReportRequest request) {
        Optional<Fault> fault = faultRepo.findById(id);
        if(!fault.isPresent())
            return ResponseEntity.ok().body("Fault not found");
        Fault faultUpdate = fault.get();
        faultUpdate.setCrew(request.getCrew());
        faultUpdate.setStatus(request.getStatus());
        faultUpdate.setPriority(request.getPriority());
        faultRepo.save(faultUpdate);
        return ResponseEntity.ok().body(faultUpdate);
    }

    @Override
    public ResponseEntity getById(Long id) {
        Optional<Fault> fault = faultRepo.findById(id);
        if(!fault.isPresent())
            return ResponseEntity.ok().body("Fault not found");
        return ResponseEntity.ok().body(fault);
    }

    @Override
    public ResponseEntity getAllByCategory(FaultCategories faultCategories) {
        List<Fault> faultList = faultRepo.findFaultsByFaultCategories(faultCategories);
        return ResponseEntity.ok().body(faultList);
    }


    @Override
    public ResponseEntity getAllByYear(String year) {

        List<Fault> faultList = faultRepo.findByYear(year);
        return ResponseEntity.ok().body(faultList);
    }

//    public ResponseEntity assignById(Long id, ReportRequest request) {
//        Optional<Fault> fault = faultRepo.findById(id);
//        if(!fault.isPresent())
//            return ResponseEntity.ok().body("Fault not found");
//        Fault faultAssigned = fault.get();
//        faultAssigned.setCrew(request.getFaultCrew);
//        return ResponseEntity.ok().body(faultAssigned);
//
//    }
}
