package BusinessLogic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


import DataAccessComponent.ProductoDAO;
import DataAccessComponent.DTO.ProductoDTO;

public class ProductoBL {
    private ProductoDTO producto;
    private ProductoDAO productoDAO = new ProductoDAO();

    public List<ProductoDTO> getAll() throws Exception {
        List<ProductoDTO> lst = productoDAO.readAll();
        for (ProductoDTO productoDTO : lst) {
    
             productoDTO.setNombreProducto(productoDTO.getNombreProducto().toUpperCase());
            productoDTO.setPrecio(BigDecimal.valueOf(productoDTO.getPrecio() * 1.15).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }
        return lst;
    }

    public ProductoDTO getByIdProducto(int idProducto) throws Exception {
        producto = productoDAO.readBy(idProducto);
        return producto;
    }

    public boolean create(ProductoDTO productoDTO) throws Exception {
        return productoDAO.create(productoDTO);
    }

    public boolean update(ProductoDTO productoDTO) throws Exception {
        return productoDAO.update(productoDTO);
    }

    public boolean delete(int idProducto) throws Exception {
        return productoDAO.delete(idProducto);
    }

    public Integer countRow() throws Exception {
        return productoDAO.countRow();
    }
}