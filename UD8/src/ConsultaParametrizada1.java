import java.sql.*;
import java.util.Scanner;

public class ConsultaParametrizada1 {
    public static void main(String[] args) {
        String url1 = "jdbc:mysql://localhost/concesionario";
        String user = "concesionario";
        String password = "Concesionario";

        Scanner s = new Scanner(System.in);
        String marca;
        int anio;
        System.out.println("Marca: ");
        marca = s.next();
        System.out.println("Año: ");
        anio = s.nextInt();

        try {
            Connection cnx = DriverManager.getConnection(url1, user, password );
            String sql = "select * from coche where marca = ? and anio = ? and not vendido";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, marca);
            ps.setInt(2, anio);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("La matrícula del coche es: " + rs.getString("matricula"));
                System.out.println("La marca del coche es: " + rs.getString("marca"));
                System.out.println("El modelo del coche es: " + rs.getString("modelo"));
                System.out.println("El año del coche es: " + rs.getDate("anio"));
                System.out.println("El precio del coche es: " + rs.getDouble("precio"));
                System.out.println("Vendido: " + rs.getBoolean("vendido"));
                System.out.println("******************************************");
            }

            ps.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}