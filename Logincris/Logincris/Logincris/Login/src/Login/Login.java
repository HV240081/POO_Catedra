package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Login {
    // Componentes de la interfaz
    private JTextField txtNombre;
    private JPasswordField txtContrasena;
    private JTextField txtDireccion;
    private JTextField txtDUI;
    private JTextField txtCorreo;
    private JTextField txtCelular;
    private JButton btnIngresar;
    private JButton btnRegistro; // Botón de registro
    private JButton btnInicio; // Botón de inicio
    private JPanel PLogin;
    private JFrame frame; // Variable para almacenar el JFrame

    // Instancia estática para permitir el acceso desde PrimeCinema
    private static Login instance;

    public Login() {
        // Inicialización de componentes
        txtNombre = new JTextField(20);
        txtContrasena = new JPasswordField(20);
        txtDireccion = new JTextField(20);
        txtDUI = new JTextField(9); // DUI con tamaño fijo
        txtCorreo = new JTextField(20);
        txtCelular = new JTextField(8); // Celular con tamaño fijo
        btnIngresar = new JButton("Ingresar");
        btnRegistro = new JButton("Registro"); // Inicializar el botón de registro
        btnInicio = new JButton("Inicio"); // Inicializar el botón btnInicio

        // Configuración del panel PLogin
        PLogin = new JPanel();
        PLogin.setLayout(new GridLayout(9, 2, 10, 10)); // Diseño en grid con 9 filas y 2 columnas
        PLogin.add(new JLabel("Nombre:"));
        PLogin.add(txtNombre);
        PLogin.add(new JLabel("Contraseña:"));
        PLogin.add(txtContrasena);
        PLogin.add(new JLabel("Dirección:"));
        PLogin.add(txtDireccion);
        PLogin.add(new JLabel("DUI:"));
        PLogin.add(txtDUI);
        PLogin.add(new JLabel("Correo Electrónico:"));
        PLogin.add(txtCorreo);
        PLogin.add(new JLabel("Celular:"));
        PLogin.add(txtCelular);
        PLogin.add(new JLabel()); // Espacio vacío
        PLogin.add(btnIngresar);
        PLogin.add(new JLabel()); // Espacio vacío adicional
        PLogin.add(btnRegistro); // Añadir el botón de registro
        PLogin.add(new JLabel()); // Espacio vacío adicional
        PLogin.add(btnInicio); // Añadir el botón btnInicio

        // Configuración del JFrame
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(PLogin);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true);

        // Instanciar la clase Login para acceso global
        instance = this;

        // Acción del botón Ingresar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String contrasena = new String(txtContrasena.getPassword());
                String direccion = txtDireccion.getText();
                String dui = txtDUI.getText();
                String correo = txtCorreo.getText();
                String celular = txtCelular.getText();

                // Validación del DUI
                if (!dui.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(frame, "El DUI debe tener exactamente 9 dígitos.");
                    return;
                }

                // Validación del correo electrónico
                if (!isValidEmail(correo)) {
                    JOptionPane.showMessageDialog(frame, "Correo electrónico inválido.");
                    return;
                }

                // Validación del celular
                if (!celular.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(frame, "El número de celular debe tener exactamente 8 dígitos.");
                    return;
                }

                // Validación simple de usuario y contraseña
                if (nombre.equals("admin") && contrasena.equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Ingreso exitoso");
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre o contraseña incorrectos");
                }
            }
        });

        // Acción del botón Registro
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro registro = new Registro(frame);
                registro.setVisible(true);
                frame.setVisible(false); // Ocultar el JFrame actual
            }
        });

        // Acción del botón Inicio
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeCinema primeCinema = new PrimeCinema();
                primeCinema.setVisible(true);
                frame.setVisible(false); // Ocultar el JFrame actual
            }
        });
    }

    // Método para validar el formato del correo electrónico
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static Login getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        // Crear la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
