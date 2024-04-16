package com.example.report.repo;

import com.example.report.model.Fault;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultRepo extends JpaRepository<Fault,Long> {
}
