package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.documents.CamposY;
import com.example.demo2.repository.CamposYRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampoYServices {
    @Autowired
    private CamposYRepository dataEjeRepository;

    public List<CamposY> findAll() {
        return dataEjeRepository.findAll();
    }

    public void save(CamposY data) {
        dataEjeRepository.save(data);
    }

    public Optional<CamposY> findById(String id) {
        return dataEjeRepository.findById(id);
    }

    public Iterable<CamposY> findByCrId(String ejeyId) {
        return dataEjeRepository.findByCarId(ejeyId);
    }
}