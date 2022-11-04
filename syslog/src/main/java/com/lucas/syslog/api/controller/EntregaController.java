/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.syslog.api.controller;

import com.lucas.syslog.domain.model.Entrega;
import com.lucas.syslog.domain.repository.EntregaRepository;
import com.lucas.syslog.domain.service.CriacaoEntregaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucas
 */
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    
    @Autowired
    private CriacaoEntregaService criacaoEntregaService;
    
    @Autowired
    private EntregaRepository entregaRepository;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega criar(@Valid @RequestBody Entrega entrega){
        return criacaoEntregaService.criar(entrega);
    }
    
    @GetMapping
    public List<Entrega> listarTodos(){
        return entregaRepository.findAll();
    }

}
