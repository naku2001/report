package com.example.report.repo;

import com.example.report.model.Fault;
import com.example.report.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Long> {
}
