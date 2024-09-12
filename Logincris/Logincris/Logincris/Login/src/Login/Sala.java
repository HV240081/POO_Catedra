package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sala {
    private JButton btningresardato;
    private JButton btnPrimeCinema;
    private JPanel panel1;
    private JFrame frame;

    public Sala() {
        // Inicializar la ventana para Sala
        frame = new JFrame("Sala");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana

        // Acción del botón btnRegistroSala (Ejemplo)
        btningresardato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Botón Registro Sala presionado");
            }
        });

        // Acción del botón btnPrimeCinema
        btnPrimeCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Sala sala = new Sala();
                sala.setVisible(true);
            }
        });
    }
}
