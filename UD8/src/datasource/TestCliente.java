package datasource;
import model.dao.ClienteDao;
import model.dao.DAOFactory;
import model.entities.Cliente;
import java.util.List;

public class TestCliente {
    public static void main(String[] args) {
        ClienteDao dao = DAOFactory.createClienteDao();

        List<Cliente> all = dao.findAll();
        for (Cliente c: all) {
            System.out.println(c);
        }

        System.out.println("*******************************Criteria******************************");
        List<Cliente> byCriteria = dao.findByCriteria("Luis", "García", "García");
        for (Cliente c: byCriteria) {
            System.out.println(c);
        }

        System.out.println("*******************************findById******************************");
        System.out.println(dao.findById("26000000H"));


        System.out.println("*******************************Insert******************************");
        Cliente cliente = new Cliente();
        cliente.setNif("12345678A");
        cliente.setNombre("Juan Diego");
        cliente.setApellido1("Rodríguez");
        cliente.setApellido2("Cabrero");
        cliente.setDireccion("Calle Nueva");
        cliente.setCiudad("Linares");
        cliente.setC_postal("23700");
        cliente.setTelefono("123456789");
        //dao.save(cliente);
        System.out.println(cliente);

        System.out.println("*******************************Update******************************");
        Cliente cliente2 = new Cliente();
        cliente2.setNif("12345678A");
        cliente2.setNombre("José");
        cliente2.setApellido1("Pérez");
        cliente2.setApellido2("García");
        cliente2.setDireccion("Calle Vieja");
        cliente2.setCiudad("Úbeda");
        cliente2.setC_postal("22500");
        cliente2.setTelefono("987654321");
        dao.update(cliente2);
        System.out.println(cliente2);

        System.out.println("*******************************Delete******************************");
        dao.delete(cliente2);
    }
}
