import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField txtNum1, txtNum2;
    private JButton btnSumar, btnRestar, btnMultiplicar, btnDividir;

    public CalculadoraGUI() {
        setTitle("Calculadora Básica UD05");
        setSize(300, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel(" Número 1:"));
        txtNum1 = new JTextField();
        add(txtNum1);

        add(new JLabel(" Número 2:"));
        txtNum2 = new JTextField();
        add(txtNum2);

        btnSumar = new JButton("+");
        btnRestar = new JButton("-");
        btnMultiplicar = new JButton("x");
        btnDividir = new JButton("/");

        add(btnSumar);
        add(btnRestar);
        add(btnMultiplicar);
        add(btnDividir);

        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());
            double resultado = 0;
            String operacion = "";

            if (e.getSource() == btnSumar) {
                resultado = n1 + n2;
                operacion = "Suma";
            } else if (e.getSource() == btnRestar) {
                resultado = n1 - n2;
                operacion = "Resta";
            } else if (e.getSource() == btnMultiplicar) {
                resultado = n1 * n2;
                operacion = "Multiplicación";
            } else if (e.getSource() == btnDividir) {
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(this, "¡Error! No se puede dividir por cero", "Error Matemático", JOptionPane.ERROR_MESSAGE);
                    return; // Salimos del método para no mostrar el resultado
                }
                resultado = n1 / n2;
                operacion = "División";
            }
            JOptionPane.showMessageDialog(this, "El resultado de la " + operacion + " es: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos", "Error de entrada", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculadoraGUI().setVisible(true);
    }
}