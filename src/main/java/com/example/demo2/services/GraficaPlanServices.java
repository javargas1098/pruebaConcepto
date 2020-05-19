package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.documents.GraficaPlan;
import com.example.demo2.repository.GraficaPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * GraficasPlanServices
 */


@Service
public class GraficaPlanServices {
    @Autowired
    GraficaPlanRepository graficaPlanRepository;
    
    public List<GraficaPlan> findAll() {
        return graficaPlanRepository.findAll();
    }

    public void agregarAccion(GraficaPlan grafica) {
        graficaPlanRepository.save(grafica);
    }

    public Optional<GraficaPlan> findById(String id) {
        return graficaPlanRepository.findById(id);
    }

	public Iterable<GraficaPlan> findByCrId(String id) {
		return graficaPlanRepository.findByCarId(id);
	}
}