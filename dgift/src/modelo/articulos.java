/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author user
 */

public class articulos {
    private int idArticulo;
    private String nombreArticulo;
    private int stockArticulo;
    private int precioArticulo;
    private Date fechaVencimiento;

    public articulos(int idArticulo, String nombreArticulo, int stockArticulo, int precioArticulo, Date fechaVencimiento) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.stockArticulo = stockArticulo;
        this.precioArticulo = precioArticulo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getStockArticulo() {
        return stockArticulo;
    }

    public void setStockArticulo(int stockArticulo) {
        this.stockArticulo = stockArticulo;
    }

    public int getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(int precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
