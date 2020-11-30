package com.practica.pago.repositories;

import com.practica.entidadesMongo.domains.Pago;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PagoRepository extends ReactiveMongoRepository <Pago,String>{
}
