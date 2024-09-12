package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Registro extends JFrame {
    private JTextField txtNombre;
    private JPasswordField txtContrasena;
    private JTextField txtDireccion;
    private JTextField txtDUI;
    private JTextField txtCorreo;
    private JTextField txtCelular;
    private JButton btnRegistrar;
    private JButton btnLogin;
    private JPanel panel;
    private JFrame loginFrame; // Variable para almacenar el JFrame de login

    public Registro(JFrame loginFrame) {
        // Guardar la referencia del JFrame de login
        this.loginFrame = loginFrame;

        // Configuración básica del JFrame
        setTitle("Registro");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        // Inicialización de componentes
        txtNombre = new JTextField(20);
        txtContrasena = new JPasswordField(20);
        txtDireccion = new JTextField(20);
        txtDUI = new JTextField(9); // DUI con tamaño fijo
        txtCorreo = new JTextField(20);
        txtCelular = new JTextField(8); // Celular con tamaño fijo
        btnRegistrar = new JButton("Registrar");
        btnLogin = new JButton("Volver a Login");

        // Configuración del panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtContrasena);
        panel.add(new JLabel("Dirección:"));
        panel.add(txtDireccion);
        panel.add(new JLabel("DUI:"));
        panel.add(txtDUI);
        panel.add(new JLabel("Correo Electrónico:"));
        panel.add(txtCorreo);
        panel.add(new JLabel("Celular:"));
        panel.add(txtCelular);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnRegistrar);
        panel.add(new JLabel()); // Espacio vacío adicional
        panel.add(btnLogin); // Añadir el botón de volver a login

        add(panel);

        // Acción del botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos
                String nombre = txtNombre.getText();
                String contrasena = new String(txtContrasena.getPassword());
                String direccion = txtDireccion.getText();
                String dui = txtDUI.getText();
                String correo = txtCorreo.getText();
                String celular = txtCelular.getText();

                // Validación de campos vacíos
                if (nombre.isEmpty() || contrasena.isEmpty() || direccion.isEmpty() ||
                        dui.isEmpty() || correo.isEmpty() || celular.isEmpty()) {
                    JOptionPane.showMessageDialog(Registro.this, "Todos los campos deben ser llenados.");
                    return;
                }

                // Validación del DUI
                if (!dui.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(Registro.this, "El DUI debe tener exactamente 9 dígitos.");
                    return;
                }

                // Validación del correo electrónico
                if (!isValidEmail(correo)) {
                    JOptionPane.showMessageDialog(Registro.this, "Correo electrónico inválido.");
                    return;
                }

                // Validación del celular
                if (!celular.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(Registro.this, "El número de celular debe tener exactamente 8 dígitos.");
                    return;
                }

                // Registro exitoso
                JOptionPane.showMessageDialog(Registro.this, "Registro exitoso.");
                // Opcional: Limpiar campos después del registro
                txtNombre.setText("");
                txtContrasena.setText("");
                txtDireccion.setText("");
                txtDUI.setText("");
                txtCorreo.setText("");
                txtCelular.setText("");
            }
        });

        // Acción del botón Volver a Login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver al JFrame de login
                loginFrame.setVisible(true);
                Registro.this.dispose(); // Cerrar el JFrame de registro
            }
        });
    }

    public Registro() {

    }

    // Método para validar el formato del correo electrónico
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
