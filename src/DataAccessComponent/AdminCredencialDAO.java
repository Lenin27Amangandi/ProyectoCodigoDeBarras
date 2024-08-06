package DataAccessComponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccessComponent.DTO.AdminCredencialDTO;
import FrameWork.BarCodeExceptions;

public class AdminCredencialDAO extends BarCodeDataHelper implements iDAO<AdminCredencialDTO> {
    @Override
    public boolean create(AdminCredencialDTO entity) throws Exception {
        String query = "INSERT INTO AdminCredencial (idUsuario, Usuario, Contrasena, FechaCreacion, FechaModifica) VALUES (?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, entity.getIdUsuario());
            pstmnt.setString(2, entity.getUsuario());
            pstmnt.setString(3, entity.getContrasena());
            pstmnt.setString(4, entity.getFechaCreacion());
            pstmnt.setString(5, entity.getFechaModifica());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<AdminCredencialDTO> readAll() throws Exception {
        List<AdminCredencialDTO> lst = new ArrayList<>();
        String query = "SELECT idAdminCredencial, idUsuario, Usuario, Contrasena, FechaCreacion, FechaModifica FROM AdminCredencial";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                AdminCredencialDTO credenciales = new AdminCredencialDTO(
                        rs.getInt(1), // idAdminCredencial
                        rs.getInt(2), // idUsuario
                        rs.getString(3), // Usuario
                        rs.getString(4), // Contrasena
                        rs.getString(5), // FechaCreacion
                        rs.getString(6) // FechaModifica
                );
                lst.add(credenciales);
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(AdminCredencialDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE AdminCredencial SET idUsuario =?, Usuario =?, Contrasena =?, FechaModifica =? WHERE idAdminCredencial =?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, entity.getIdUsuario());
            pstmnt.setString(2, entity.getUsuario());
            pstmnt.setString(3, entity.getContrasena());
            pstmnt.setString(4, dtf.format(now));
            pstmnt.setInt(5, entity.getIdAdminCredencial());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM AdminCredencial WHERE idAdminCredencial =?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, id);
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public AdminCredencialDTO readBy(Integer id) throws Exception {
        AdminCredencialDTO oC = new AdminCredencialDTO();
        String query = "SELECT idAdminCredencial, idUsuario, Usuario, Contrasena, FechaCreacion, FechaModifica FROM AdminCredencial WHERE idAdminCredencial = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                oC = new AdminCredencialDTO(
                        rs.getInt(1), // idAdminCredencial
                        rs.getInt(2), // idUsuario
                        rs.getString(3), // Usuario
                        rs.getString(4), // Contrasena
                        rs.getString(5), // FechaCreacion
                        rs.getString(6) // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oC;
    }
    public Integer countRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM AdminCredencial";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "countRow()");
        }
        return 0;
    }
}

