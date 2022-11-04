/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lucas.syslog.domain.service;

import com.lucas.syslog.domain.exception.NegocioException;
import com.lucas.syslog.domain.model.Cliente;
import com.lucas.syslog.domain.repository.ClienteRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class CadastroClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
    }
    
    @Transactional
    public Cliente salvar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        if (clienteExistente != null && !clienteExistente.equals(cliente)){
            throw new NegocioException("Já existe um cliente cadastrado com esse email.");
        }
        
        return clienteRepository.save(cliente);
    }
    
    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
    
}
