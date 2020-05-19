package com.example.demo2.repository;

import com.example.demo2.documents.Campos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposRepository extends JpaRepository<Campos, String> {


	
	@Query(value = "select cp.* FROM cr_campos cp join cr_ejes_grafica ej on ej.id=cp.ejesid  WHERE ej.eje='x' and ej.id=:ejeId ORDER BY ej.ID", nativeQuery = true)
	Iterable<Campos> findByCarId( @Param("ejeId") String ejeId);
    
}