package com.practica.entidadesDto.domains;

import java.io.Serializable;
import java.util.ArrayList;

public class FacturaDto implements Serializable {

    private String idFactura;
    //Con la propia factura ya tendria acceso a las lineasFactura
    private ArrayList<String> lineas;
    private int formaPago;
    private float importeTotal;
    private String estadoFactura;
    private String idCliente;

    public ArrayList<String> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<String> lineas) {
        this.lineas = lineas;
    }



    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
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

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estado) {
        this.estadoFactura = estado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }






}
