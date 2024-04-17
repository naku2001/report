package com.example.report.repo;

import com.example.report.model.Fault;
import com.example.report.model.FaultCategories;
import com.example.report.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FaultRepo extends JpaRepository<Fault,Long> {


    List< Fault> findFaultsByStatus(Status status);

    List<Fault> findFaultsByFaultCategories(FaultCategories faultCategories);

    @Query("SELECT e FROM Fault e WHERE YEAR(e.dateTime) = :year")
    List<Fault> findByYear(String year);}
