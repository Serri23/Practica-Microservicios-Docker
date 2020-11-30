package com.practica.factura.repositories;

import com.practica.entidadesDto.domains.FacturaDto;
import com.practica.entidadesMongo.domains.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FacturaRepository extends ReactiveMongoRepository<Factura,String> {
    //Añadir
    Mono<FacturaDto> insert(FacturaDto factura);
    //Listar Por Estado
    Flux<FacturaDto> findAllByEstado(String estado);
    //Listar por cliente
    Flux<FacturaDto> findAllByIdCliente(String idCliente);
    //Listar por importe
    Flux<FacturaDto> findAllByImporteTotal(Double importe);


}
