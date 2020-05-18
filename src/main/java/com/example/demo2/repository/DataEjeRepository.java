package com.example.demo2.repository;

import com.example.demo2.documents.DataEjeY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DataEjeRepository
 */
@Repository
public interface DataEjeRepository extends JpaRepository<DataEjeY, String>{
    
}