import BusinessLogic.AdminCredencialBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RegistroProductoBL;
import BusinessLogic.UsuarioBL;
import DataAccessComponent.ProductoDAO;
import DataAccessComponent.DTO.AdminCredencialDTO;
import DataAccessComponent.DTO.ProductoDTO;
import DataAccessComponent.DTO.RegistroProductoDTO;
import DataAccessComponent.DTO.UsuarioDTO;
import UserInterface.Form.SplashScreenForm;

public class App {

    public static void main(String[] args) {

        //SplashScreenForm.show();

        try {
            // try {

            // } catch (Exception e) {
            // // TODO: handle exception
            // }

            ProductoBL pBL = new ProductoBL();
            // pBL.add(new ProductoDTO(0, "nuevo producto", "descripcion", 0.0, null, null,
            // null));

            for (ProductoDTO p : pBL.getAll()) {
                System.out.println(p.toString());
                System.out.println("--".repeat(20));
            }

            UsuarioBL uBL = new UsuarioBL();
            for (UsuarioDTO u : uBL.getAll()) {
                System.out.println(u.toString());
                System.out.println("--".repeat(20));
            }

            RegistroProductoBL rpBL = new RegistroProductoBL();
            for (RegistroProductoDTO rp : rpBL.getAll()) {
                System.out.println(rp.toString());
                System.out.println("--".repeat(20));
            }
            AdminCredencialBL acBL = new AdminCredencialBL();
            for (AdminCredencialDTO ac : acBL.getAll()) {
                System.out.println(ac.toString());
                System.out.println("--".repeat(20));
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}