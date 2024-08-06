package DataAccessComponent.DTO;

public class RegistroProductoDTO {

    private Integer idRegistroProducto;
    private Integer idProducto;
    private String FechaCreacion;

    public RegistroProductoDTO() {
    }

    public RegistroProductoDTO(Integer idRegistroProducto, Integer idProducto, String fechaCreacion) {
        this.idRegistroProducto = idRegistroProducto;
        this.idProducto = idProducto;
        FechaCreacion = fechaCreacion;
    }

    public Integer getIdRegistroProducto() {
        return idRegistroProducto;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getName()
                + "\n  idRegistroProducto      " + getIdRegistroProducto()
                + "\n  idProducto     " + getIdProducto()
                + "\n  FechaCreacion      " + getFechaCreacion();
    }

    public void setIdRegistroProducto(Integer idRegistroProducto) {
        this.idRegistroProducto = idRegistroProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

}
