package com.practica.entidadesMySQL.domains;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "visitas")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name="importe")
    private long importe;
    /*@Column(name="id_cliente")
    private String idCliente;

    //Agendada,pendiente de facturar,facturada
     */
    @Column(name="estado")
    private String estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getImporte() {
        return importe;
    }

    public void setImporte(long importe) {
        this.importe = importe;
    }
      public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
