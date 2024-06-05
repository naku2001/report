package com.example.report.repo;

import com.example.report.model.Fault;
import com.example.report.model.Recipient;
import com.example.report.model.ZesaCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultRepo extends JpaRepository<Fault,Long> {

  List<Fault> findAllByRecipient(Recipient recipient);
}
