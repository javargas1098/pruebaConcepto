package com.example.demo2.repository;



import com.example.demo2.documents.Ejes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjesRepository extends JpaRepository<Ejes, String> {

}