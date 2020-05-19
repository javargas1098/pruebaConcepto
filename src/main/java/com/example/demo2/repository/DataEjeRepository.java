package com.example.demo2.repository;

import com.example.demo2.documents.DataEjeY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * DataEjeRepository
 */
@Repository
public interface DataEjeRepository extends JpaRepository<DataEjeY, String>{

	@Query(value = "select ey.* FROM cr_data_ejey ey join cr_ejes_grafica e on ey.ejeyid= e.id JOIN cr_grafica g on e.grafica_id=g.id WHERE g.CARID=:id and g.id=:graficaId ORDER BY g.ID", nativeQuery = true)
    Iterable<DataEjeY> findByCarId(@Param("id") String id, @Param("graficaId") String graficaId);
    
}