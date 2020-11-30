package com.practica.cliente.controllers;

import com.practica.cliente.services.ClienteService;
import com.practica.entidadesMySQL.domains.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //GET
    @GetMapping(value = "/api/cliente/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") String clienteId){
         return clienteService.getClienteById(clienteId);

    }

    //POST
    @PostMapping(value="/api/cliente/")
    public Cliente anadirCliente(@RequestBody Cliente cliente){
        return clienteService.anadirCliente(cliente);
    }

    //PUT
    @PutMapping(value="/api/cliente/")
    public void actualizarCliente(@RequestBody Cliente clienteU){
        Optional<Cliente> clienteEnBd = clienteService.getClienteById(clienteU.getId());
        if(clienteEnBd != null){
            //clienteU.setId(clienteEnBd.get().getId());
            clienteService.actualizarCliente(clienteU);
        }else{
            try{

            }catch(Exception e) {
                System.out.println("Error: No existe el cliente");
            }
        }
    }

    //DELETE
    @DeleteMapping(value="/api/cliente/{id}")
    public void borrarCliente(@PathVariable("id") String clienteId){
        clienteService.borrarCliente(clienteId);
    }
    //LISTAR
    @GetMapping(value = "/api/clientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }



}
