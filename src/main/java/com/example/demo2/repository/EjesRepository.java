package com.example.demo2.repository;

import com.example.demo2.documents.Ejes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EjesRepository extends JpaRepository<Ejes, String> {

    @Query(value = "select e.* FROM cr_ejes_grafica e JOIN cr_grafica g on e.grafica_id=g.id WHERE g.CARID=:id and g.id=:graficaId ORDER BY g.ID", nativeQuery = true)
    Iterable<Ejes> findByCarId(@Param("id") String id, @Param("graficaId") String graficaId);

}