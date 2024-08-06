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

import DataAccessComponent.DTO.UsuarioDTO;
import FrameWork.BarCodeExceptions;

public class UsuarioDAO extends BarCodeDataHelper implements iDAO<UsuarioDTO> {

    @Override
    public boolean create(UsuarioDTO entity) throws Exception {
        String query = "INSERT INTO Usuario (Nombre, Apellido, Cedula, FechaCreacion, FechaModifica) VALUES (?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setString(1, entity.getNombre());
            pstmnt.setString(2, entity.getApellido());
            pstmnt.setString(3, entity.getCedula());
            pstmnt.setString(4, entity.getFechaCreacion());
            pstmnt.setString(5, entity.getFechaModifica());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<UsuarioDTO> readAll() throws Exception {
        List<UsuarioDTO> lst = new ArrayList<>();
        String query = "SELECT idUsuario, Nombre, Apellido, Cedula, FechaCreacion, FechaModifica FROM Usuario";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO(
                        rs.getInt(1), // idUsuario
                        rs.getString(2), // Nombre
                        rs.getString(3), // Apellido
                        rs.getString(4), // Cedula
                        rs.getString(5), // FechaCreacion
                        rs.getString(6) // FechaModifica
                );
                lst.add(usuario);
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(UsuarioDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Usuario SET Nombre = ?, Apellido = ?, Cedula = ?, FechaModifica = ? WHERE idUsuario = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setString(1, entity.getNombre());
            pstmnt.setString(2, entity.getApellido());
            pstmnt.setString(3, entity.getCedula());
            pstmnt.setString(4, dtf.format(now));
            pstmnt.setInt(5, entity.getIdUsuario());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM Usuario WHERE idUsuario = ?";
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
    public UsuarioDTO readBy(Integer id) throws Exception {
        UsuarioDTO oU = new UsuarioDTO();
        String query = "SELECT idUsuario, Nombre, Apellido, Cedula, FechaCreacion, FechaModifica FROM Usuario WHERE idUsuario = " + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                oU = new UsuarioDTO(
                        rs.getInt(1), // idUsuario
                        rs.getString(2), // Nombre
                        rs.getString(3), // Apellido
                        rs.getString(4), // Cedula
                        rs.getString(5), // FechaCreacion
                        rs.getString(6) // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oU;
    }
    public Integer countRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM Usuario";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw  new BarCodeExceptions(e.getMessage(), getClass().getName(), "countRow()");
        }
        return 0;
    }
}