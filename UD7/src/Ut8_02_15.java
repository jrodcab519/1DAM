import javax.swing.*;

public class Ut8_02_15 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("UT11_B02_15");

        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        JList<String> lstMeses = new JList<>(meses);
        JScrollPane scrMeses = new JScrollPane(lstMeses);
        ventana.add(scrMeses);

        //lstMeses.setCellRenderer(new IconoCellRenderer());
        ventana.setSize(640, 480);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}