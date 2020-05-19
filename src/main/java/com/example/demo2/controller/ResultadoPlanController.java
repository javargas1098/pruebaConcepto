package com.example.demo2.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    private ModelMapper modelMapper;

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
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<String> saveDiagrama(@RequestBody ResultadoPlanDto diagramas) {
        System.out.println("entre");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("llege acaaaa");
        try {
            List<GraficaPlan> diagrama = objectMapper.readValue(diagramas.getGraficas(), new TypeReference<List<Ejes>>() {
            });
            diagrama.stream().forEach(dg -> {
                /* List<Ejes> ejes = objectMapper.readValue(dg.getEjes(), new TypeReference<List<Ejes>>() {
                });
                List<DataEjeY> ejesY = objectMapper.readValue(diagrama.getDataEjeY(),
                        new TypeReference<List<DataEjeY>>() {
                        }); */
                Campos data = new Campos();
                CamposY dataY = new CamposY();
                graficaPlanServices.agregarAccion(dg);
                Variables constans = Variables.GRAFICAPLANIDGLOBAL;
                dg.getEjes().stream().forEach(eje -> {
                    eje.setId("1");
                    eje.setGraficaId(constans.getLabel());
                    ejesServices.agregarAccion(eje);
                    Variables constansEjes = Variables.EJESGRAFICAIDGLOBAL;
                    eje.getCampos().stream().forEach(campo -> {
                        data.setId("1");
                        data.setCampo(campo);
                        data.setEjesId(constansEjes.getLabel());
                        campoServices.save(data);

                    });
                });
                Variables constansEjes = Variables.EJESGRAFICAIDGLOBAL;
                System.out.println(constansEjes);
                dg.getDataEjeY()
                .stream().forEach(dataEje -> {
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
            });
            
        } catch (IOException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, "Error", e);
            }
        }

        return new ResponseEntity<>("El diagrama fue actualizado exitosamente", HttpStatus.OK);

    }

    /*
     * private GraficaPlan convertToEntity(ResultadoPlanDto resultadoPlanDto) throws
     * ParseException { if (resultadoPlanDto == null) { throw new
     * ParseException("resultadoPlanDto is null", 0); } GraficaPlan data =
     * modelMapper.map(resultadoPlanDto, GraficaPlan.class);
     * data.setId(resultadoPlanDto.getId());
     * data.setCarId(resultadoPlanDto.getCarId());
     * data.setNombreEjeX(resultadoPlanDto.getNombreEjeX());
     * data.setNombreEjey(resultadoPlanDto.getNombreEjey());
     * data.setTitulo(resultadoPlanDto.getTitulo());
     * data.setTipoDatos(resultadoPlanDto.getTipoDatos());
     * data.setTipoGrafica(resultadoPlanDto.getTipoGrafica()); return data; }
     * 
     * private ResultadoPlanDto convertToDto(GraficaPlan data) { ResultadoPlanDto
     * planDeAccionDto = modelMapper.map(data, ResultadoPlanDto.class);
     * planDeAccionDto.setId(data.getId());
     * planDeAccionDto.setCarId(data.getCarId());
     * planDeAccionDto.setNombreEjeX(data.getNombreEjeX());
     * planDeAccionDto.setNombreEjey(data.getNombreEjey());
     * planDeAccionDto.setTitulo(data.getTitulo());
     * planDeAccionDto.setTipoDatos(data.getTipoDatos());
     * planDeAccionDto.setTipoGrafica(data.getTipoGrafica()); return
     * planDeAccionDto; }
     */

}
