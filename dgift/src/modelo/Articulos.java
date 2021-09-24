/**
 * @author Carlos Thieme
 * fecha   13/09/2021
 * 
 */
package modelo;

import java.util.Date;


public class Articulos {
    int     idArticulo;
    String  nombreArticulo;
    int     stockArticulo;
    Date    fechaVence;
    int     idCategoria;
    float   precioArticulo;

    public Articulos() {
    }

    public Articulos(int idArticulo, String nombreArticulo, int stockArticulo, Date fechaVence, int idCategoria, float precioArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.stockArticulo = stockArticulo;
        this.fechaVence = fechaVence;
        this.idCategoria = idCategoria;
        this.precioArticulo = precioArticulo;
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

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public float getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(float precioArticulo) {
        this.precioArticulo = precioArticulo;
    }
    
    
}
