package BusinessLogic;

import java.util.List;

import DataAccessComponent.UsuarioDAO;
import DataAccessComponent.DTO.UsuarioDTO;

public class UsuarioBL {
    private UsuarioDTO usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public List<UsuarioDTO> getAll() throws Exception {
        List<UsuarioDTO> lst = usuarioDAO.readAll();
        for (UsuarioDTO usuarioDTO : lst) {
            usuarioDTO.setNombre(usuarioDTO.getNombre().toUpperCase());
            usuarioDTO.setApellido(usuarioDTO.getApellido().toUpperCase());
        }
        return lst;
    }

    public UsuarioDTO getByIdUsuario(int idUsuario) throws Exception {
        usuario = usuarioDAO.readBy(idUsuario);
        return usuario;
    }

    public boolean create(UsuarioDTO usuarioDTO) throws Exception {
        return usuarioDAO.create(usuarioDTO);
    }

    public boolean update(UsuarioDTO usuarioDTO) throws Exception {
        return usuarioDAO.update(usuarioDTO);
    }

    public boolean delete(int idUsuario) throws Exception {
        return usuarioDAO.delete(idUsuario);
    }

    public Integer countRow() throws Exception {
        return usuarioDAO.countRow();
    }
}