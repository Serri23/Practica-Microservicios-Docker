package com.practica.pago.services;

import com.practica.entidadesMongo.domains.Pago;
import com.practica.pago.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Mono<Pago> getPagoId(String pagoId) {
        return pagoRepository.findById(pagoId);
    }

    public Mono<Pago> anadirPago(Pago pago) {
        return pagoRepository.insert(pago);
    }

    public Mono<Pago> actualizarPago(String pagoId,Pago pagoU) {
        pagoRepository.deleteById(pagoId);
        return pagoRepository.save(pagoU);
    }

    public Mono<Void> borrarPago(String pagoId) {
        return pagoRepository.deleteById(pagoId);
    }

    public Flux<Pago> listarPagos() {
        return pagoRepository.findAll();
    }
}
