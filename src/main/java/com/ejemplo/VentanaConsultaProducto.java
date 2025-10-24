
package com.ejemplo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaConsultaProducto extends JFrame {

    public VentanaConsultaProducto() {
        setTitle("Consulta de Repuestos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ? Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(2, 3, 10, 10));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar Repuesto"));

        panelBusqueda.add(new JLabel("Código de Artículo*"));
        panelBusqueda.add(new JTextField("115"));
        panelBusqueda.add(new JLabel("Código de Barra"));
        panelBusqueda.add(new JTextField());
        panelBusqueda.add(new JLabel("Cod. Sustituto Final"));
        panelBusqueda.add(new JTextField());

        // ? Pestañas
        JTabbedPane pestañas = new JTabbedPane();

        // ? Tabla de repuestos
        String[] columnas = {
            "Depo", "Artículo", "Proveedor", "SK", "Dir", "Mon", "Precio",
            "Ubicación", "Subconj", "Ejec", "RCM", "RCN", "RCS"
        };

        Object[][] datos = {
            {"01", "115", "SUZUKI MOTOR", "SK1", "D1", "USD", "120.00", "A1", "SC1", "E1", "10", "5", "2"},
            {"02", "116", "TOYOTA JAPAN", "SK2", "D2", "USD", "95.00", "B2", "SC2", "E2", "8", "3", "1"},
            // Puedes agregar más filas aquí
        };

        JTable tabla = new JTable(new DefaultTableModel(datos, columnas));
        JScrollPane scrollTabla = new JScrollPane(tabla);

        pestañas.addTab("General", scrollTabla);
        pestañas.addTab("Pedidos", new JPanel());
        pestañas.addTab("Reservas", new JPanel());
        pestañas.addTab("Remitos", new JPanel());
        pestañas.addTab("Última Venta", new JPanel());
        pestañas.addTab("Auditoría", new JPanel());

        // ? Layout principal
        setLayout(new BorderLayout());
        add(panelBusqueda, BorderLayout.NORTH);
        add(pestañas, BorderLayout.CENTER);

        setVisible(true);
    }
}