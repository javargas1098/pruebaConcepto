package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.documents.Campos;
import com.example.demo2.repository.CamposRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampoServices {
    @Autowired
    private CamposRepository dataEjeRepository;

    public List<Campos> findAll() {
        return dataEjeRepository.findAll();
    }

    public void save(Campos data) {
        dataEjeRepository.save(data);
    }

    public Optional<Campos> findById(String id) {
        return dataEjeRepository.findById(id);
    }

    public Iterable<Campos> findByCrId(String ejeId) {
        return dataEjeRepository.findByCarId(ejeId);
    }

}