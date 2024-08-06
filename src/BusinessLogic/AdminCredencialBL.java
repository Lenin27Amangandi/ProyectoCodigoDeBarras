package BusinessLogic;

import java.util.List;

import DataAccessComponent.AdminCredencialDAO;
import DataAccessComponent.DTO.AdminCredencialDTO;


public class AdminCredencialBL {
    private AdminCredencialDTO adminCredencial;
    private AdminCredencialDAO adminCredencialDAO = new AdminCredencialDAO();

    public List<AdminCredencialDTO> getAll() throws Exception {
        List<AdminCredencialDTO> lst = adminCredencialDAO.readAll();
        return lst;
    }
    
    public AdminCredencialDTO getByIdAdminCredencial(int idAdminCredencial) throws Exception {
        adminCredencial = adminCredencialDAO.readBy(idAdminCredencial);
        return adminCredencial;
    }

    public boolean create(AdminCredencialDTO adminCredencialDTO) throws Exception {
        return adminCredencialDAO.create(adminCredencialDTO);
    }

    public boolean update(AdminCredencialDTO adminCredencialDTO) throws Exception {
        return adminCredencialDAO.update(adminCredencialDTO);
    }

    public boolean delete(int idAdminCredencial) throws Exception {
        return adminCredencialDAO.delete(idAdminCredencial);
    }

    public Integer countRow() throws Exception {
        return adminCredencialDAO.countRow();
    }
}