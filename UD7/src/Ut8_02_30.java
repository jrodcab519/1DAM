import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ut8_02_30 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ut8_02_30");

        Action salirAction = new SalirAction();
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
        JMenuItem menuItemAbrir = new JMenuItem("Abrir...");
        JMenu menuRecientes = new JMenu("Recientes");
        menuRecientes.add(new JMenuItem("prueba.txt"));
        menuRecientes.add(new JMenuItem("ejemplo2.dat"));
        JMenuItem menuItemCerrar = new JMenuItem("Cerrar");
        JMenuItem menuItemImprimir = new JMenuItem("Imprimir");
        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuRecientes);
        menuArchivo.add(menuItemCerrar);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemImprimir);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemSalir);
        menuBar.add(menuArchivo);
        ventana.setJMenuBar(menuBar);
        JButton salir = new JButton(salirAction);
        JPanel pnlSuperior= new JPanel(new FlowLayout());
        pnlSuperior.add(salir);
        ventana.add(pnlSuperior);
        ventana.setSize(640, 480);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}