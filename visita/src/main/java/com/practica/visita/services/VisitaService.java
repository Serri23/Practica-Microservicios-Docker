package com.practica.visita.services;

import com.practica.entidadesMySQL.domains.Visita;
import com.practica.visita.repositories.VisitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public Optional<Visita> getVisitaById(String visitaId) {
        return visitaRepository.findById(visitaId);
    }

    public Visita anadirVisita(Visita visita) {
        return (Visita) visitaRepository.save(visita);
    }

    public void borrarVisita(String visitaId) {
        visitaRepository.deleteById(visitaId);
    }

    public void actualizarVisita(Visita visitaU) {
        visitaRepository.save(visitaU);
    }

    public List<Visita> listarvisitas() {
        return visitaRepository.findAll();
    }
}
