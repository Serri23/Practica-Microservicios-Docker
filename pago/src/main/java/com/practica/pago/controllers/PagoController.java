package com.practica.pago.controllers;

import com.practica.entidadesMongo.domains.Pago;
import com.practica.pago.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PagoController {

    @Autowired
    PagoService pagoService;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
    //GET
    @GetMapping(value="/api/pago/{id}")
    public Mono<Pago> getPago(@PathVariable("id") String pagoId){
        return pagoService.getPagoId(pagoId);
    }

    //POST
    @PostMapping(value="/api/pago/")
    public Mono<Pago> anadirPago(@RequestBody Pago pago){
        return pagoService.anadirPago(pago);
    }

    //PUT
    @PutMapping(value="/api/pago/{id}")
    public Mono<Pago> actualizarPago(@PathVariable("id") String pagoId, @RequestBody Pago pagoU){
        Mono<Pago> pagoEnBd = pagoService.getPagoId(pagoId);
        if( pagoEnBd != null){
            pagoU.setId(pagoEnBd.block().getId());
            return pagoService.actualizarPago(pagoId,pagoU);
        }else{

            System.out.println("Error: No existe el pago");

        }
        return null;
    }

    //DELETE
    @DeleteMapping(value="/api/pago/{id}")
    public Mono<Void> borrarPago(@PathVariable("id") String pagoId){
        return pagoService.borrarPago(pagoId);
    }

    //LISTAR
    @GetMapping(value="/api/pagos/")
    public Flux<Pago> listarPagos(){
        return pagoService.listarPagos();
    }
}
