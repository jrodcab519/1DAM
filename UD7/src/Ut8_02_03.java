import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ut8_02_03 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ut8_02_03");
        ventana.setSize(640, 480);
        ventana.setVisible(true);
        ventana.setName("Coordenadas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnl1 = new JPanel();
        JLabel ejex = new JLabel("X = ?");
        JLabel ejey = new JLabel("Y = ?");
        pnl1.add(ejex);
        pnl1.add(ejey);

        ventana.add(pnl1, BorderLayout.PAGE_START);

        ventana.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                ejex.setText("X = " + e.getX());
                ejey.setText("Y = " + e.getY());
            }
        });
    }
}
