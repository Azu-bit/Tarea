import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    private JTextField campoNumero;
    private JLabel etiquetaNumeros;
    private int[] vector = new int[10];
    private int contador = 0;

    public Ventana() {
        setTitle("Tarea");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);

        JLabel etiqueta = new JLabel("Ingresa un número:");
        panel.add(etiqueta);

        campoNumero = new JTextField(10);
        panel.add(campoNumero);

        JButton botonIngresar = new JButton("Ingresar número");
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarNumero();
            }
        });
        panel.add(botonIngresar);

        JButton botonOrdenar = new JButton("Ordenar números");
        botonOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNumeros();
            }
        });
        panel.add(botonOrdenar);

        etiquetaNumeros = new JLabel();
        panel.add(etiquetaNumeros);
    }

    private void ingresarNumero() {
        if (contador < vector.length) {
            try {
                int numero = Integer.parseInt(campoNumero.getText());
                vector[contador] = numero;
                contador++;
                campoNumero.setText("");
                mostrarNumeros();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingresa un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ya no puedes ingresar más números", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarNumeros() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            sb.append(vector[i]).append(" ");
        }
        etiquetaNumeros.setText(sb.toString());
    }

    private void ordenarNumeros() {
        bubbleSort(vector);
        mostrarNumeros();
    }

    public static void bubbleSort(int[] vector) {
        int n = vector.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (vector[j - 1] > vector[j]) {
                    temp = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}