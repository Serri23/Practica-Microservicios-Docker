package com.practica.entidadesMySQL.domains;

import javax.persistence.*;

@Entity
@Table(name="direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name="nombre_direccion")
    private String nombreDireccion;
    //@Column(name="id_cliente")
    //private String idCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreDireccion() {
        return nombreDireccion;
    }

    public void setNombreDireccion(String nombreDireccion) {
        this.nombreDireccion = nombreDireccion;
    }


}
