package com.muxengressos.engresso.controllers;


import com.muxengressos.engresso.models.dtos.RequestEgressoDto;
import com.muxengressos.engresso.services.EgressoService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/egresso")
public class EgressoController {

    @Autowired
    private EgressoService egressoService;


    @GetMapping
    public ResponseEntity<Page<RequestEgressoDto>> getAllEgresso(){


        return null;
    }

}
