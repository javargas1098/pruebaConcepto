package com.example.demo2.repository;

import com.example.demo2.documents.CamposY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CamposYRepository extends JpaRepository<CamposY, String>{


    
    @Query(value = "select py.* FROM cr_puntosy py join cr_data_ejey ey on ey.id=py.ejeyid  WHERE  ey.id=:ejeyId ORDER BY ey.ID", nativeQuery = true)
    Iterable<CamposY> findByCarId(@Param("ejeyId") String ejeyId);
    
}