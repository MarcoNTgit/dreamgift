package modelo;

import java.util.Date;

public class articulos {
            private int idArticulo;
        private String nombreArticulo;
        private int stockArticulo;
        private Date venceArticulo;
        private float precioArticulo;
        private int categoriaArticulo;

    public articulos() {
    }

    public articulos(int idArticulo, String nombreArticulo, int stockArticulo, Date venceArticulo, float precioArticulo, int categoriaArticulo) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.stockArticulo = stockArticulo;
        this.venceArticulo = venceArticulo;
        this.precioArticulo = precioArticulo;
        this.categoriaArticulo = categoriaArticulo;
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

    public Date getVenceArticulo() {
        return venceArticulo;
    }

    public void setVenceArticulo(Date venceArticulo) {
        this.venceArticulo = venceArticulo;
    }

    public float getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(float precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    public int getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(int categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }
    
}
