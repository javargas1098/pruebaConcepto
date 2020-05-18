package com.example.demo2.repository;

import com.example.demo2.documents.CamposY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposYRepository extends JpaRepository<CamposY, String>{
    
}