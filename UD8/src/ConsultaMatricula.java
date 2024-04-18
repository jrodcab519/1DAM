import java.sql.*;
import java.util.Scanner;

public class ConsultaMatricula {
    public static void main(String[] args) {

        String url1 = "jdbc:mysql://localhost/concesionario";
        String user = "concesionario";
        String password = "Concesionario";

        Scanner s = new Scanner(System.in);

        int descuento;
        String matricula;
        System.out.println("Descuento: ");
        descuento = s.nextInt();
        System.out.println("Matricula: ");
        matricula = s.next();


        try {
            Connection cnx = DriverManager.getConnection(url1, user, password );
            Statement statement = cnx.createStatement();
            String sql= "update coche set precio = precio * (1 - ?) where matricula = ? ";
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, descuento);
            ps.setString(2, matricula);


            int filas = statement.executeUpdate(sql);

            System.out.printf("Se ha actualizado %d coches. ", filas);

            statement.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
