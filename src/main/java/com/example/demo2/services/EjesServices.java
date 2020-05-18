package com.example.demo2.services;

import java.util.List;
import java.util.Optional;

import com.example.demo2.documents.Ejes;
import com.example.demo2.repository.EjesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjesServices {
    @Autowired
    EjesRepository ejesRepository;

    public List<Ejes> findAll() {
        return ejesRepository.findAll();
    }

    public void agregarAccion(Ejes ejes) {
        ejesRepository.save(ejes);
    }

    public Optional<Ejes> findById(String id) {
        return ejesRepository.findById(id);
    }

}