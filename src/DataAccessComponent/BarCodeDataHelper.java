package DataAccessComponent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BarCodeDataHelper{
  private static String url = "jdbc:sqlite:database/Database.sqlite";
   
    private static Connection conn = null ;
    protected BarCodeDataHelper (){}
    
    protected static synchronized Connection openConnection() throws Exception {
        try{
            if ( conn == null){
                conn = DriverManager.getConnection(url);
            }
        }   catch ( SQLException e){
            throw e;
        }
        return conn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (conn != null){
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    protected static void main(String[] args) {
        try {
            Connection conn = openConnection();
            System.out.println("Conexión establecida");

            // Crear un Statement para ejecutar consultas
            Statement stmt = conn.createStatement();

            // Ejecutar una consulta para probar la conexión
            String query = "SELECT * FROM Producto";
            stmt.execute(query);

            System.out.println("Consulta ejecutada con éxito");

            closeConnection();
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}