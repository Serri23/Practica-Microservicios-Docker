package com.practica.entidadesMongo.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("facturas")
public class Factura {

    private @Id
    String id;
    private ArrayList<LineaFactura> lineas;
    private int formaPago; //1,2 o 3 pagos
    private float importeTotal; //Importe total de las visitas
    private String estado; //Pendiente de pago, Pagada parcialmente,pagada,impagada
    private String idCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<LineaFactura> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaFactura> lineas) {
        this.lineas = lineas;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importe) {
        this.importeTotal = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estadoFactura) {
        this.estado = estadoFactura;
    }


}
