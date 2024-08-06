package DataAccessComponent.DTO;

import java.util.Scanner;

public class ProductoDTO {
    Scanner scanner = new Scanner(System.in);
    private Integer idProducto;
    private String NombreProducto;
    private double Precio;
    private String Descripcion;
    private String CodigoDeBarras;
    private int Stock;
    private String FechaCreacion;
    private String FechaModifica;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {

        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCodigoDeBarras() {
        return CodigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        CodigoDeBarras = codigoDeBarras;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    public ProductoDTO() {
    }

    public ProductoDTO(Integer idProducto, String nombreProducto, double precio, String descripcion,
            String codigoDeBarras, int stock, String fechaCreacion, String fechaModifica) {
        this.idProducto = idProducto;
        NombreProducto = nombreProducto;
        Precio = precio;
        Descripcion = descripcion;
        CodigoDeBarras = codigoDeBarras;
        Stock = stock;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "\n"+getClass().getName()
                + "\n  idProducto         " + getIdProducto()
                + "\n  NombreProducto     " + getNombreProducto()
                + "\n  Precio             " + getPrecio()
                + "\n  Descripcion        " + getDescripcion()
                + "\n  CodigoDeBarras     " + getCodigoDeBarras()
                + "\n  Stock              " + getStock()
                + "\n  FechaCreacion      " + getFechaCreacion()
                + "\n  FechaModifica      " + getFechaModifica();
    }
}
