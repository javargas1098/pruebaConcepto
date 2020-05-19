package com.example.demo2.repository;

import com.example.demo2.documents.GraficaPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GraficaPlanRepository extends JpaRepository<GraficaPlan, String> {
    
    @Query(value = "select g.* FROM cr_grafica g WHERE g.CARID=:id  ORDER BY g.ID", nativeQuery = true)
    Iterable<GraficaPlan> findByCarId(@Param("id") String id);

}