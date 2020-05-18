package com.example.demo2.repository;


import com.example.demo2.documents.GraficaPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraficaPlanRepository extends JpaRepository<GraficaPlan, String> {
    
}