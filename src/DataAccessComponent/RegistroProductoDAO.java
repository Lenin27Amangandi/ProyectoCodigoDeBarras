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

import DataAccessComponent.DTO.RegistroProductoDTO;
import FrameWork.BarCodeExceptions;

public class RegistroProductoDAO extends BarCodeDataHelper implements iDAO<RegistroProductoDTO> {

    @Override
    public boolean create(RegistroProductoDTO entity) throws Exception {
        String query = "INSERT INTO RegistroProducto (idProducto, fechaCreacion) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, entity.getIdProducto());
            pstmnt.setString(2, entity.getFechaCreacion());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
           throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "create()");

        }
    }

    @Override
    public List<RegistroProductoDTO> readAll() throws Exception {
        List<RegistroProductoDTO> lst = new ArrayList<>();
        String query = "SELECT idRegistroProducto, idProducto, fechaCreacion FROM RegistroProducto";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                RegistroProductoDTO registro = new RegistroProductoDTO(
                        rs.getInt(1), // idRegistroProducto
                        rs.getInt(2), // idProducto
                        rs.getString(3) // fechaCreacion
                );
                lst.add(registro);
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(RegistroProductoDTO entity) throws Exception {
        String query = "UPDATE RegistroProducto SET idProducto = ?, fechaCreacion = ? WHERE idRegistroProducto = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setInt(1, entity.getIdProducto());
            pstmnt.setString(2, entity.getFechaCreacion());
            pstmnt.setInt(3, entity.getIdRegistroProducto());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM RegistroProducto WHERE idRegistroProducto = ?";
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
    public RegistroProductoDTO readBy(Integer id) throws Exception {
        RegistroProductoDTO oR = new RegistroProductoDTO();
        String query = "SELECT idRegistroProducto, idProducto, fechaCreacion FROM RegistroProducto WHERE idRegistroProducto = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                oR = new RegistroProductoDTO(
                        rs.getInt(1), // idRegistroProducto
                        rs.getInt(2), // idProducto
                        rs.getString(3) // fechaCreacion
                );
            }
        } catch (SQLException e) {
            throw  new BarCodeExceptions(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oR;
    }

    public Integer countRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM RegistroProducto";
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