package com.practica.visita.controllers;

import com.practica.entidadesMySQL.domains.Visita;
import com.practica.visita.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class VisitaController {
    @Autowired
    private VisitaService visitaService;

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/api/visita/{id}")
    public Optional<Visita> getVisitaById(@PathVariable ("id") String visitaId){
        return visitaService.getVisitaById(visitaId);
    }
    //POST
    @PostMapping(value="/api/visita/")
    public Visita anadirvisita(@RequestBody Visita visita){
        return visitaService.anadirVisita(visita);
    }

    //PUT
    @PutMapping(value="/api/visita/")
    public void actualizarvisita(@RequestBody Visita visitaU){
        Optional<Visita> visitaEnBd = visitaService.getVisitaById(visitaU.getId());
        if(visitaEnBd != null){
            //visitaU.setId(visitaEnBd.get().getId());
            visitaService.actualizarVisita(visitaU);
        }else{
            try{

            }catch(Exception e) {
                System.out.println("Error: No existe el visita");
            }
        }
    }

    //DELETE
    @DeleteMapping(value="/api/visita/{id}")
    public void borrarvisita(@PathVariable("id") String visitaId){
        visitaService.borrarVisita(visitaId);
    }
    //LISTAR
    @GetMapping(value = "/api/visitas")
    public List<Visita> listarvisitas(){
        return visitaService.listarvisitas();
    }
}
