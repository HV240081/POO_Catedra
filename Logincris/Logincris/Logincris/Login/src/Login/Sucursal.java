package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sucursal {
    private JButton btningresardato;
    private JButton btnPrimeCinema;
    private JPanel panel1;
    private JFrame frame;

    public Sucursal() {
        // Inicializar la ventana para la sucursal
        frame = new JFrame("Sucursal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana

        // Acción del botón btnRegistroSucursal (Ejemplo)
        btningresardato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes añadir la lógica que necesites para el botón btnRegistroSucursal
                JOptionPane.showMessageDialog(frame, "Botón Registro Sucursal presionado");
            }
        });

        // Acción del botón btnPrimeCinema
        btnPrimeCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana PrimeCinema y ocultar la ventana actual de Sucursal
                PrimeCinema primeCinema = new PrimeCinema();
                primeCinema.setVisible(true);
                frame.setVisible(false); // Ocultar la ventana actual
            }
        });
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de Sucursal
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Sucursal sucursal = new Sucursal();
                sucursal.setVisible(true);
            }
        });
    }
}
