package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.documents.DataEjeY;
import com.example.demo2.repository.DataEjeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataEjeServices {
    @Autowired
    private DataEjeRepository dataEjeRepository;

    public List<DataEjeY> findAll() {
        return dataEjeRepository.findAll();
    }

    public void agregarAccion(DataEjeY data) {
        dataEjeRepository.save(data);
    }

    public Optional<DataEjeY> findById(String id) {
        return dataEjeRepository.findById(id);
    }

    public Iterable<DataEjeY> findByCrId(String id, String graficaId) {
        return dataEjeRepository.findByCarId(id, graficaId);
    }

}