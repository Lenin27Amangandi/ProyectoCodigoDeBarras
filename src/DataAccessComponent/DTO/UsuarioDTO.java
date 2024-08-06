package DataAccessComponent.DTO;

public class UsuarioDTO {

    private Integer idUsuario;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String FechaCreacion;
    private String FechaModifica;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
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

    public UsuarioDTO(Integer idUsuario, String nombre, String apellido, String cedula, String fechaCreacion,
            String fechaModifica) {
        this.idUsuario = idUsuario;
        Nombre = nombre;
        Apellido = apellido;
        Cedula = cedula;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public UsuarioDTO() {
    }

    @Override
    public String toString() {
        return "\n"+getClass().getName()
                + "\n  idUsuario         " + getIdUsuario()
                + "\n  Nombre            " + getNombre()
                + "\n  Apellido          " + getApellido()
                + "\n  Cedula            " + getCedula()
                + "\n  FechaCreacion     " + getFechaCreacion()
                + "\n  FechaModifica     " + getFechaModifica();
    }

}
