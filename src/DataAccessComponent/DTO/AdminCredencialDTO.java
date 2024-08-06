package DataAccessComponent.DTO;

public class AdminCredencialDTO {
    private Integer idAdminCredencial;
    private Integer idUsuario;
    private String Usuario;
    private String Contrasena;
    private String FechaCreacion;
    private String FechaModifica;

    public Integer getIdAdminCredencial() {
        return idAdminCredencial;
    }

    public void setIdAdminCredencial(Integer idAdminCredencial) {
        this.idAdminCredencial = idAdminCredencial;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
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

    public AdminCredencialDTO(Integer idAdminCredencial, Integer idUsuario, String usuario, String contrasena,
            String fechaCreacion, String fechaModifica) {
        this.idAdminCredencial = idAdminCredencial;
        this.idUsuario = idUsuario;
        Usuario = usuario;
        Contrasena = contrasena;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public AdminCredencialDTO() {
    }

    @Override
    public String toString() {
        return "\n"+getClass().getName()
                + "\n  idAdminCredencial       " + getIdAdminCredencial()
                + "\n  Usuario            " + getUsuario()
                + "\n  Contrasena           " + getContrasena()
                + "\n  FechaCreacion      " + getFechaCreacion()
                + "\n  FechaModifica      " + getFechaModifica();
    }

}
