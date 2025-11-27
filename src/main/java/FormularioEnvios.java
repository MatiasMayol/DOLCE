import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class FormularioEnvios extends JFrame {

    private JTextField txtNombre, txtDireccion, txtTelefono, txtLocalidad, txtDepartamento;
    private JButton btnGenerar;

    // Etiqueta accesible desde toda la clase
    private String etiqueta = "";

    public FormularioEnvios() {

        setTitle("Formulario de Envíos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        add(new JLabel("Localidad:"));
        txtLocalidad = new JTextField();
        add(txtLocalidad);

        add(new JLabel("Departamento:"));
        txtDepartamento = new JTextField();
        add(txtDepartamento);

        btnGenerar = new JButton("Generar Etiqueta");
        add(btnGenerar);

        // Acción del botón
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                generarEtiqueta();

                JOptionPane.showMessageDialog(FormularioEnvios.this, etiqueta,
                        "Etiqueta Generada", JOptionPane.INFORMATION_MESSAGE);

                PrinterJob job = PrinterJob.getPrinterJob();

                job.setPrintable(new Printable() {
                    @Override
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                        if (pageIndex > 0) return NO_SUCH_PAGE;

                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                        // Colores estilo Mercado Libre
                        Color amarilloML = new Color(255, 230, 0);

                        // Fondo amarillo superior
                        g2d.setColor(amarilloML);
                        g2d.fillRect(10, 10, 350, 60);

                        // Título
                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Arial", Font.BOLD, 20));
                        g2d.drawString("ENVÍO", 25, 50);

                        // Caja principal
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(10, 10, 350, 500);

                        // Sección DESTINATARIO
                        int y = 100;
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("DESTINATARIO", 20, y);
                        g2d.drawLine(20, y + 5, 200, y + 5);

                        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                        y += 25;
                        g2d.drawString("Nombre: " + txtNombre.getText(), 20, y); y += 18;
                        g2d.drawString("Dirección: " + txtDireccion.getText(), 20, y); y += 18;
                        g2d.drawString("Teléfono: " + txtTelefono.getText(), 20, y); y += 25;

                        // Sección UBICACIÓN
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("UBICACIÓN", 20, y);
                        g2d.drawLine(20, y + 5, 200, y + 5);

                        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
                        y += 25;
                        g2d.drawString("Localidad: " + txtLocalidad.getText(), 20, y); y += 18;
                        g2d.drawString("Departamento: " + txtDepartamento.getText(), 20, y); y += 30;

                        // Caja inferior estilo ML
                        g2d.setColor(amarilloML);
                        g2d.fillRect(10, y, 350, 60);

                        g2d.setColor(Color.BLACK);
                        g2d.setFont(new Font("Arial", Font.BOLD, 14));
                        g2d.drawString("MANEJAR CON CUIDADO", 25, y + 35);

                        return PAGE_EXISTS;
                    }
                });

                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        setVisible(true);
    }

    private void generarEtiqueta() {
        etiqueta = "ENVÍO\n\n" +
                "Nombre: " + txtNombre.getText() + "\n" +
                "Dirección: " + txtDireccion.getText() + "\n" +
                "Teléfono: " + txtTelefono.getText() + "\n" +
                "Localidad: " + txtLocalidad.getText() + "\n" +
                "Departamento: " + txtDepartamento.getText();
    }

    public static void main(String[] args) {
        new FormularioEnvios();
    }
}