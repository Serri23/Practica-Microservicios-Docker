package com.practica.factura.controllers;

import com.netflix.appinfo.InstanceInfo;
import com.practica.entidadesDto.domains.FacturaDto;
import com.practica.entidadesMongo.domains.Factura;
import com.practica.factura.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    /*@LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
*/
    //GET
    @GetMapping(value="/api/factura/{id}")
    public Mono<Factura> getFacturaById(@PathVariable("id") String facturaId){
        return facturaService.getFacturaById(facturaId);
    }


    //POST
    @PostMapping(value="/api/factura/")
    public Mono<FacturaDto> anadirFactura(@RequestBody FacturaDto factura){
        return facturaService.anadirFactura(factura);

    }

    //PUT
    @PutMapping(value="/api/factura/{id}")
    public Mono<Factura> actualizarFactura(@PathVariable("id") String facturaId,@RequestBody Factura facturaU){

            Mono<Factura> facturaEnBd = facturaService.getFacturaById(facturaId);

            if (facturaEnBd != null) {
                if(facturaEnBd.block().getEstado().equals("pendiente de pago")) {
                    facturaU.setId(facturaId);
                    return facturaService.actualizarFactura(facturaId,facturaU);
                }else{
                    System.out.println("Error: La factura no se encuentra en estado: pendiente de pago");
                }
            } else {

                System.out.println("Error: No existe la factura");

            }
            return null;

    }


    //DELETE
    @DeleteMapping(value="/api/factura/{id}")
    public Mono<Void> borrarFactura(@PathVariable("id") String facturaId){
        return facturaService.borrarFactura(facturaId);

    }

    //LISTAR
    @GetMapping(value="/api/facturas/")
    public Flux<Factura> listarFacturas(){
        return facturaService.listarFacturas();
    }

    //FACTURA COMPLETA
    @GetMapping(value="/api/factura/completa/{id}")
    public FacturaDto getFacturaCompleta(@PathVariable("id") String facturaId){
        return facturaService.getFacturaCompleta(facturaId);
    }
    //BUSQUEDA POR CLIENTE
    @GetMapping(value="/api/factura/busqueda/{idCliente}")
    public Flux<FacturaDto> buscarFacturaPorCliente(@PathVariable("idCliente") String idCliente){
        return facturaService.buscarFacturaPorCliente(idCliente);
    }
    //BUSQUEDA POR ESTADO
    @GetMapping(value="/api/factura/busqueda/{estado}")
    public Flux<FacturaDto> listarPorEstado(@PathVariable("estado") String estadoFactura){
        return facturaService.listarPorEstado(estadoFactura);
    }
    //BUSQUEDA POR IMPORTE
    @GetMapping(value="/api/factura/busqueda/{importe}")
    public Flux<FacturaDto> listarPorEstado(@PathVariable("importe") Double importe){
        return facturaService.listarPorImporte(importe);
    }
}
