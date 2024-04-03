import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ut8_01_12 extends JFrame implements ActionListener {
    private JTextField textField;

    public ut8_01_12() {
        setTitle("Días de la Semana");
        setSize(640, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel(new GridLayout(1, 7));
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String dia : diasSemana) {
            JButton botonDia = new JButton(dia);
            botonDia.addActionListener(this);
            panelBotones.add(botonDia);
        }
        add(panelBotones, BorderLayout.NORTH);

        JPanel panelInferior = new JPanel();
        textField = new JTextField("Pulsa un botón");
        textField.setEditable(false);
        panelInferior.add(textField);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        JButton boton = (JButton) e.getSource();
        String nombreDia = boton.getText();
        textField.setText(nombreDia);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ut8_01_12());
    }
}
