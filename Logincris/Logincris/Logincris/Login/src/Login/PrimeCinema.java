package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeCinema {
    private JPanel JInicio;
    private JTabbedPane tbRegistros;
    private JButton btnLogin;
    private JButton btnRegistro;
    private JFrame frame;

    public PrimeCinema() {
        // Inicializar los componentes
        JInicio = new JPanel(new BorderLayout()); // Usamos BorderLayout para la demostración
        tbRegistros = new JTabbedPane();
        btnLogin = new JButton("Login");
        btnRegistro = new JButton("Registro");

        // Agregar componentes al panel
        JInicio.add(tbRegistros, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(); // Panel para los botones
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnRegistro);
        JInicio.add(buttonPanel, BorderLayout.SOUTH);

        // Inicializar la ventana principal
        frame = new JFrame("PrimeCinema");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(JInicio);
        frame.setSize(800, 600); // Ajusta el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana

        // Acción del botón Login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la pantalla de Login y ocultar la pantalla de PrimeCinema
                Login login = Login.getInstance(); // Asegúrate de que esta línea funcione correctamente
                if (login != null) {
                    login.setVisible(true);
                    frame.setVisible(false); // Ocultar el JFrame actual
                } else {
                    JOptionPane.showMessageDialog(frame, "No se pudo obtener la instancia de Login.");
                }
            }
        });

        // Acción del botón Registros
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la pantalla de IngresarDatos y ocultar la pantalla de PrimeCinema
                IngresarDato ingresarDatos = new IngresarDato();
                ingresarDatos.setVisible(true);
                frame.setVisible(false); // Ocultar el JFrame actual
            }
        });
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana principal
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrimeCinema primeCinema = new PrimeCinema();
                primeCinema.setVisible(true);
            }
        });
    }
}