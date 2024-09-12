package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarDato {
    private JButton btnRegistroSucursal;
    private JButton btnRegistroPelicula;
    private JButton btnRegistroSala;
    private JPanel mainPanel;
    private JFrame frame;

    public IngresarDato() {
        // Inicializar los componentes
        mainPanel = new JPanel(new GridLayout(3, 1)); // GridLayout con 3 filas y 1 columna
        btnRegistroSucursal = new JButton("Registrar Sucursal");
        btnRegistroPelicula = new JButton("Registrar Película");
        btnRegistroSala = new JButton("Registrar Sala");

        // Agregar botones al panel
        mainPanel.add(btnRegistroSucursal);
        mainPanel.add(btnRegistroPelicula);
        mainPanel.add(btnRegistroSala);

        // Inicializar la ventana para ingresar datos
        frame = new JFrame("Ingresar Datos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE para cerrar solo la ventana actual
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana

        // Acción del botón btnRegistroSucursal
        btnRegistroSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sucursal sucursal = new Sucursal();
                sucursal.setVisible(true);
                frame.setVisible(false); // Ocultar la ventana actual
            }
        });

        // Acción del botón btnRegistroSala
        btnRegistroSala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sala sala = new Sala();
                sala.setVisible(true);
                frame.setVisible(false); // Ocultar la ventana actual
            }
        });

        // Acción del botón btnRegistroPelicula
        btnRegistroPelicula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pelicula pelicula = new Pelicula();
                pelicula.setVisible(true);
                frame.setVisible(false); // Ocultar la ventana actual
            }
        });
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
