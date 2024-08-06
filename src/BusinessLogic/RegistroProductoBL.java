package BusinessLogic;
import java.util.List;

import DataAccessComponent.RegistroProductoDAO;
import DataAccessComponent.DTO.RegistroProductoDTO;

public class RegistroProductoBL {
    private RegistroProductoDTO registroProducto;
    private RegistroProductoDAO registroProductoDAO = new RegistroProductoDAO();

    public List<RegistroProductoDTO> getAll() throws Exception {
        List<RegistroProductoDTO> lst = registroProductoDAO.readAll();
        return lst;
    }

    public RegistroProductoDTO getByIdRegistroProducto(int idRegistroProducto) throws Exception {
        registroProducto = registroProductoDAO.readBy(idRegistroProducto);
        return registroProducto;
    }

    public boolean create(RegistroProductoDTO registroProductoDTO) throws Exception {
        return registroProductoDAO.create(registroProductoDTO);
    }

    public boolean update(RegistroProductoDTO registroProductoDTO) throws Exception {
        return registroProductoDAO.update(registroProductoDTO);
    }

    public boolean delete(int idRegistroProducto) throws Exception {
        return registroProductoDAO.delete(idRegistroProducto);
    }

    public Integer countRow() throws Exception {
        return registroProductoDAO.countRow();
    }
}
