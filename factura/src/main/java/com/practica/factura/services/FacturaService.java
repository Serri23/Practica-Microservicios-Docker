package com.practica.factura.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.practica.entidadesDto.domains.FacturaDto;
import com.practica.entidadesMongo.domains.Factura;
import com.practica.entidadesMongo.domains.LineaFactura;
import com.practica.factura.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private FacturaRepository facturaRepository;

    public Mono<Factura> getFacturaById(String facturaId){
        return facturaRepository.findById(facturaId);
    }

    public Mono<FacturaDto> anadirFactura(FacturaDto factura) {
        return facturaRepository.insert(factura);
    }

    public Mono<Factura> actualizarFactura(String facturaId, Factura factura) {

        return facturaRepository.save(factura);

    }

    public Mono<Void> borrarFactura(String facturaId) {
        return facturaRepository.deleteById(facturaId);
    }


    public Flux<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    /*--------------------------------*/

    public FacturaDto getFacturaCompleta(String facturaId) {
        Mono<Factura> factura = facturaRepository.findById(facturaId);
        ArrayList<LineaFactura> lineas = factura.block().getLineas();
        ArrayList<String> lineasString = new ArrayList<>();
        String linea = new String();
        for(int i = 0;i<lineas.size();i++){
            linea = lineas.get(i).getIdVisita();
            lineasString.add(linea);
        }


        FacturaDto dto = new FacturaDto();
        dto.setIdFactura(facturaId);
        dto.setLineas(lineasString);
        dto.setFormaPago(factura.block().getFormaPago());
        dto.setEstadoFactura(factura.block().getEstado());
        dto.setImporteTotal(factura.block().getImporteTotal());
        dto.setIdCliente(factura.block().getIdCliente());


        return dto;
    }


    public Flux<FacturaDto> listarPorEstado(String estadoFactura) {
        return facturaRepository.findAllByEstado(estadoFactura);
    }

    public Flux<FacturaDto> buscarFacturaPorCliente(String idCliente) {
        return facturaRepository.findAllByIdCliente(idCliente);
    }

    public Flux<FacturaDto> listarPorImporte(Double importe) {
        return facturaRepository.findAllByImporteTotal(importe);
    }
}
