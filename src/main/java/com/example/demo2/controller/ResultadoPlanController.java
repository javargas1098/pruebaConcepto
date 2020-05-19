package com.example.demo2.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import com.example.demo2.services.CampoServices;
import com.example.demo2.services.CampoYServices;
import com.example.demo2.services.DataEjeServices;
import com.example.demo2.services.EjesServices;
import com.example.demo2.services.GraficaPlanServices;
import com.example.demo2.documents.Campos;
import com.example.demo2.documents.CamposY;
import com.example.demo2.documents.DataEjeY;
import com.example.demo2.documents.Ejes;
import com.example.demo2.documents.GraficaPlan;
import com.example.demo2.documents.ResultadoPlanDto;
import com.example.demo2.documents.Variables;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plan")
public class ResultadoPlanController {
    @Autowired
    private DataEjeServices dataEjeServices;

    @Autowired
    private EjesServices ejesServices;

    @Autowired
    private CampoServices campoServices;

    @Autowired
    private CampoYServices campoYServices;

    @Autowired
    private GraficaPlanServices graficaPlanServices;

    private static final Logger logger = Logger.getLogger(ResultadoPlanController.class.getName());

    @CrossOrigin
    @GetMapping(value = "/all/{id}")
    public ResponseEntity<ResultadoPlanDto> all(@PathVariable("id") String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResultadoPlanDto diagrama = new ResultadoPlanDto();

            Iterable<GraficaPlan> graficasPlan = graficaPlanServices.findByCrId(id);

            graficasPlan.forEach(grafica -> {

                Iterable<Ejes> ejesGrafica = ejesServices.findByCrId(id, grafica.getId());
                Iterable<DataEjeY> ejesYGrafica = dataEjeServices.findByCrId(id, grafica.getId());

                ejesGrafica.forEach(eje -> {
                    Iterable<Campos> campos = campoServices.findByCrId(eje.getId());
                    List<String> data = new LinkedList<>();
                    campos.forEach(campo -> {
                        data.add(campo.getCampo());
                    });
                    eje.setCampos(data);
                });

                ejesYGrafica.forEach(ejeY -> {
                    Iterable<CamposY> campos = campoYServices.findByCrId(ejeY.getId());
                    List<Float> puntosY = new LinkedList<>();
                    campos.forEach(campo -> {
                        puntosY.add(campo.getCampo());
                    });
                    ejeY.setPuntosY(puntosY);
                });

                String ejes;
                String ejesY;
                try {
                    ejes = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ejesGrafica);
                    ejesY = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ejesYGrafica);
                    grafica.setEjes(ejes);
                    grafica.setDataEjeY(ejesY);
                } catch (JsonProcessingException e) {
                    if (logger.isLoggable(Level.SEVERE)) {
                        logger.log(Level.SEVERE, "Error de mapeo", e);
                    }
                }

            });
            String graficas = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(graficasPlan);
            diagrama.setGraficas(graficas);
            return new ResponseEntity<>(diagrama, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

    }

    @CrossOrigin
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> saveDiagrama(@RequestBody ResultadoPlanDto diagramas) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<GraficaPlan> diagrama = objectMapper.readValue(diagramas.getGraficas(),
                    new TypeReference<List<GraficaPlan>>() {
                    });
            diagrama.stream().forEach(dg -> {
                try {
                    List<Ejes> ejes = objectMapper.readValue(dg.getEjes(), new TypeReference<List<Ejes>>() {
                    });
                    List<DataEjeY> ejesY = objectMapper.readValue(dg.getDataEjeY(),
                            new TypeReference<List<DataEjeY>>() {
                            });
                    Campos data = new Campos();
                    CamposY dataY = new CamposY();
                    graficaPlanServices.agregarAccion(dg);
                    Variables constans = Variables.GRAFICAPLANIDGLOBAL;
                    ejes.stream().forEach(eje -> {
                        eje.setId("1");
                        eje.setGraficaId(constans.getLabel());
                        ejesServices.agregarAccion(eje);
                        Variables constansEjes = Variables.EJESGRAFICAIDGLOBAL;
                        if (eje.getEje().equals("x")) {
                            eje.getCampos().stream().forEach(campo -> {
                                data.setId("1");
                                data.setCampo(campo);
                                data.setEjesId(constansEjes.getLabel());
                                campoServices.save(data);
                            });
                        }
                    });
                    Variables constansEjes = Variables.EJESGRAFICAIDGLOBAL;
                    ejesY.stream().forEach(dataEje -> {
                        dataEje.setId("1");
                        dataEje.setEjeyId(constansEjes.getLabel());
                        dataEjeServices.agregarAccion(dataEje);
                        Variables constansDataY = Variables.DATAEJEYIDGLOBAL;
                        dataEje.getPuntosY().stream().forEach(campoY -> {
                            dataY.setId("1");
                            dataY.setCampo(campoY);
                            dataY.setEjeyId(constansDataY.getLabel());
                            campoYServices.save(dataY);
                        });
                    });
                } catch (IOException e) {
                    if (logger.isLoggable(Level.SEVERE)) {
                        logger.log(Level.SEVERE, "Error", e);
                    }
                }
            });

        } catch (IOException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, "Error", e);
            }
        }

        return new ResponseEntity<>("El diagrama fue actualizado exitosamente", HttpStatus.OK);

    }

}
