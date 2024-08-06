
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

import DataAccessComponent.DTO.ProductoDTO;
import FrameWork.BarCodeExceptions;

public class ProductoDAO extends BarCodeDataHelper implements iDAO<ProductoDTO> {

    @Override
    public boolean create(ProductoDTO entity) throws Exception {
        String query = "INSERT INTO Producto (NombreProducto, Precio, Descripcion, CodigoDeBarras, Stock, FechaCreacion, FechaModifica) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setString(1, entity.getNombreProducto());
            pstmnt.setDouble(2, entity.getPrecio());
            pstmnt.setString(3, entity.getDescripcion());
            pstmnt.setString(4, entity.getCodigoDeBarras());
            pstmnt.setInt(5, entity.getStock());
            pstmnt.setString(6, entity.getFechaCreacion());
            pstmnt.setString(7, entity.getFechaModifica());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
           throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "create()");

        }
    }

    @Override
    public List<ProductoDTO> readAll() throws Exception {
        List<ProductoDTO> lst = new ArrayList<>();
        String query = "SELECT idProducto, NombreProducto, Precio, Descripcion, CodigoDeBarras, Stock, FechaCreacion, FechaModifica FROM Producto";
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                ProductoDTO producto = new ProductoDTO(
                        rs.getInt(1), // idProducto
                        rs.getString(2), // NombreProducto
                        rs.getDouble(3), // Precio
                        rs.getString(4), // Descripcion
                        rs.getString(5), // CodigoDeBarras
                        rs.getInt(6), // Stock
                        rs.getString(7), // FechaCreacion
                        rs.getString(8) // FechaModifica
                );
                lst.add(producto);
            }
        } catch (SQLException e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean update(ProductoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Producto SET NombreProducto = ?, Precio = ?, Descripcion = ?, CodigoDeBarras = ?, Stock = ?, FechaModifica = ? WHERE idProducto = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmnt = conn.prepareStatement(query);
            pstmnt.setString(1, entity.getNombreProducto());
            pstmnt.setDouble(2, entity.getPrecio());
            pstmnt.setString(3, entity.getDescripcion());
            pstmnt.setString(4, entity.getCodigoDeBarras());
            pstmnt.setInt(5, entity.getStock());
            pstmnt.setString(6, dtf.format(now));
            pstmnt.setInt(7, entity.getIdProducto());
            pstmnt.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new BarCodeExceptions(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "DELETE FROM Producto WHERE idProducto = ?";
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
    public ProductoDTO readBy(Integer id) throws Exception {
        ProductoDTO oP = new ProductoDTO();
        String query = "SELECT idProducto, NombreProducto, Precio, Descripcion, CodigoDeBarras, Stock, FechaCreacion, FechaModifica FROM Producto WHERE idProducto = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmnt = conn.createStatement();
            ResultSet rs = stmnt.executeQuery(query);
            while (rs.next()) {
                oP = new ProductoDTO(
                        rs.getInt(1), // idProducto
                        rs.getString(2), // NombreProducto
                        rs.getDouble(3), // Precio
                        rs.getString(4), // Descripcion
                        rs.getString(5), // CodigoDeBarras
                        rs.getInt(6), // Stock
                        rs.getString(7), // FechaCreacion
                        rs.getString(8) // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw  new BarCodeExceptions(e.getMessage(), getClass().getName(), "readBy()");
        }
        return oP;
    }

    public Integer countRow() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM Producto";
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
