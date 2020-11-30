package com.practica.cliente.services;

import com.practica.cliente.repositories.ClienteRepository;
import com.practica.entidadesMySQL.domains.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> getClienteById(String clienteId) {
        return clienteRepository.findById(clienteId);
    }

    public Cliente anadirCliente(Cliente cliente) {
        return (Cliente) clienteRepository.save(cliente);
    }

    public void borrarCliente(String clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public void actualizarCliente(Cliente clienteU) {
        clienteRepository.save(clienteU);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


}
