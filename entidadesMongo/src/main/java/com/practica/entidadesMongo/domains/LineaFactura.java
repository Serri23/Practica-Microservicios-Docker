package com.practica.entidadesMongo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("lineas_factura")
public class LineaFactura {

    private @Id
    String idLinea;
    //Sacar las visitas llamando con un microservicio usando el id visita
    String idVisita;

    public String getId() {
        return idLinea;
    }

    public void setId(String id) {
        this.idLinea = id;
    }

    public String getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(String idVisita) {
        this.idVisita = idVisita;
    }
}
