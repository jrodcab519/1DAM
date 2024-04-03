import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ut8_01_13 extends JFrame implements ActionListener {
        private JTextField textField;
        private JLabel[] resultados;

        public ut8_01_13() {

            setTitle("Tabla de multiplicar");
            setSize(640, 480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLayout(new GridLayout(1, 3));

            JPanel panelIzquierdo = new JPanel(new BorderLayout());
            textField = new JTextField();
            panelIzquierdo.add(textField, BorderLayout.CENTER);
            add(panelIzquierdo);

            JPanel panelCentral = new JPanel(new GridBagLayout());
            JButton botonCalcular = new JButton("Calcular");
            botonCalcular.addActionListener(this);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            panelCentral.add(botonCalcular, gbc);
            add(panelCentral);

            JPanel panelDerecho = new JPanel(new GridLayout(10, 1));
            resultados = new JLabel[10];
            for (int i = 0; i < resultados.length; i++) {
                resultados[i] = new JLabel();
                panelDerecho.add(resultados[i]);
            }
            add(panelDerecho);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                int numero = Integer.parseInt(textField.getText());
                for (int i = 0; i < resultados.length; i++) {
                    int resultado = numero * (i + 1);
                    resultados[i].setText(numero + " x " + (i + 1) + " = " + resultado);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Introduce un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new ut8_01_13());
        }

}

