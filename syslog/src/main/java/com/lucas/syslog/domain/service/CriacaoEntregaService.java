/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.syslog.domain.service;

import com.lucas.syslog.domain.exception.NegocioException;
import com.lucas.syslog.domain.model.Cliente;
import com.lucas.syslog.domain.model.Entrega;
import com.lucas.syslog.domain.model.StatusEntrega;
import com.lucas.syslog.domain.repository.ClienteRepository;
import com.lucas.syslog.domain.repository.EntregaRepository;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas
 */
@Service
public class CriacaoEntregaService {
    @Autowired
    private EntregaRepository entregaRepository;
    
    @Autowired
    private CadastroClienteService cadastroClienteService;
    
    @Transactional
    public Entrega criar(Entrega entrega){
        Cliente cliente = cadastroClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
    
//    @Transactional
//    public void finalizar(Long entregaId){
//        OrdemServico ordemServico = osRepository.findById(ordemServicoId)
//                .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrado!"));
//        
//        ordemServico.finalizar();
//        
//        osRepository.save(ordemServico);
//    }
    
    
}
