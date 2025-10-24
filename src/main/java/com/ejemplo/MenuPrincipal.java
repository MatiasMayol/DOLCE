package com.ejemplo;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con layout vertical
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new GridLayout(5, 1, 10, 10));

        // Botones
        JButton btnConsultaProducto = new JButton("Consulta de Producto");
        JButton btnEtiquetaEnvio = new JButton("Etiqueta de Envío");
        JButton btnClientes = new JButton("Clientes");
        JButton btnFactura = new JButton("Factura");
        JButton btnAltasBajas = new JButton("Altas/Bajas");

        // Agregar botones al panel
        panelMenu.add(btnConsultaProducto);
        panelMenu.add(btnEtiquetaEnvio);
        panelMenu.add(btnClientes);
        panelMenu.add(btnFactura);
        panelMenu.add(btnAltasBajas);

        // Acciones de los botones
        btnConsultaProducto.addActionListener(e -> new VentanaConsultaProducto());
        btnEtiquetaEnvio.addActionListener(e -> abrirPanel("EtiquetaEnvio"));
        btnClientes.addActionListener(e -> abrirPanel("Clientes"));
        btnFactura.addActionListener(e -> abrirPanel("Factura"));
        btnAltasBajas.addActionListener(e -> abrirPanel("AltasBajas"));

        add(panelMenu);
        setVisible(true);
    }

    // Método para abrir paneles (por ahora solo muestra mensaje)
    private void abrirPanel(String nombrePanel) {
        JOptionPane.showMessageDialog(this, "Abrir panel: " + nombrePanel);
        // Aquí luego puedes hacer: setContentPane(new PanelConsultaProducto()); etc.
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::new);
    }
}