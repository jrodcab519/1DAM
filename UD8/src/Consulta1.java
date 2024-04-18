import java.sql.*;
import java.util.Scanner;

public class Consulta1 {
    public static void main(String[] args) {
        String url1 = "jdbc:mysql://localhost/concesionario";
        String user = "concesionario";
        String password = "Concesionario";


        try {
            Connection cnx = DriverManager.getConnection(url1, user, password );
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("select * from coche");

            while(rs.next()){
                System.out.println("La matrícula del coche es: " + rs.getString("matricula"));
                System.out.println("La marca del coche es: " + rs.getString("marca"));
                System.out.println("El modelo del coche es: " + rs.getString("modelo"));
                System.out.println("El año del coche es: " + rs.getDate("anio"));
                System.out.println("El precio del coche es: " + rs.getDouble("precio"));
                System.out.println("Vendido: " + rs.getBoolean("vendido"));
                System.out.println("******************************************");
            }

            statement.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
