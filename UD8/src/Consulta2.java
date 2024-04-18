import java.sql.*;

public class Consulta2 {
    public static void main(String[] args) {
        String url1 = "jdbc:mysql://localhost/concesionario";
        String user = "concesionario";
        String password = "Concesionario";
        try {
            Connection cnx = DriverManager.getConnection(url1, user, password );
            Statement statement = cnx.createStatement();
            ResultSet rs = statement.executeQuery("select * from coche where marca = 'Ford' and vendido = 0");

            while(rs.next()){
                System.out.println("La matrícula del coche es: " + rs.getString("matricula"));
                System.out.println("La marca del coche es: " + rs.getString("marca"));
                System.out.println("El modelo del coche es: " + rs.getString("modelo"));
                System.out.println("El año del coche es: " + rs.getDate("anio"));
                System.out.println("El precio del coche es: " + rs.getDouble("precio"));
                System.out.println("Vendido: " + rs.getBoolean("vendido"));
                System.out.println("******************************************");
            }

            rs = statement.executeQuery("select  count(*) as total from coche where precio between 20000 and 100000");

            rs.next();
            int total = rs.getInt(1);
            System.out.printf("Son %d la cantidad de coches que disponemos con un precio comprendido entre 20000 y 100000 wuros. ", total);

            statement.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}