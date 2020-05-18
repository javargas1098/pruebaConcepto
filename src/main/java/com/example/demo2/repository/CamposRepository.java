package com.example.demo2.repository;

import com.example.demo2.documents.Campos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposRepository extends JpaRepository<Campos, String> {
    
}