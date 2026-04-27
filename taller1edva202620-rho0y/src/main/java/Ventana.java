import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private HistorialAcciones historial;

    private JTextField txtAccion;
    private JTextArea txtConsola;
    private JButton btnRegistrar;
    private JButton btnUltimaAccion;
    private JButton btnDeshacer;
    private JButton btnMostrarHistorial;
    private JButton btnEstado;

    public Ventana() {
        historial = new HistorialAcciones();

        setTitle("Editor de Texto - Historial de Acciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntrada = new JPanel(new BorderLayout(5, 5));
        panelEntrada.add(new JLabel("Nueva acción:"), BorderLayout.WEST);
        txtAccion = new JTextField();
        panelEntrada.add(txtAccion, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnRegistrar = new JButton("Registrar");
        btnUltimaAccion = new JButton("Última Acción");
        btnDeshacer = new JButton("Deshacer");
        btnMostrarHistorial = new JButton("Mostrar Historial");
        btnEstado = new JButton("Ver Estado / Cantidad");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnUltimaAccion);
        panelBotones.add(btnDeshacer);
        panelBotones.add(btnMostrarHistorial);
        panelBotones.add(btnEstado);

        txtConsola = new JTextArea();
        txtConsola.setEditable(false);
        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        scrollConsola.setBorder(BorderFactory.createTitledBorder("Salida / Resultados"));

        add(panelEntrada, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollConsola, BorderLayout.SOUTH);

        scrollConsola.setPreferredSize(new Dimension(500, 200));

        configurarEventos();
    }

    private void configurarEventos() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accion = txtAccion.getText();

                if (accion != null && !accion.trim().isEmpty()) {
                    historial.registrarAccion(accion);
                    txtConsola.append("Registrado: " + accion + "\n");
                    txtAccion.setText("");
                } else if (accion == null || accion.trim().isEmpty()) {
                    txtConsola.append("Error: No se pueden registrar acciones vacías.\n");
                }
            }
        });

        btnUltimaAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ultima = historial.obtenerUltimaAccion();

                if (ultima.equals("Sin acciones")) {
                    txtConsola.append(ultima + "\n");
                } else if (!ultima.equals("Sin acciones")) {
                    txtConsola.append("Última acción: " + ultima + "\n");
                }
            }
        });

        btnDeshacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deshecho = historial.deshacerAccion();

                if (deshecho.equals("Nada que deshacer")) {
                    txtConsola.append(deshecho + "\n");
                } else if (!deshecho.equals("Nada que deshacer")) {
                    txtConsola.append("Se deshizo: " + deshecho + "\n");
                }
            }
        });

        btnMostrarHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hist = historial.mostrarHistorial();

                if (hist.equals("Historial vacío")) {
                    txtConsola.append(hist + "\n");
                } else if (!hist.equals("Historial vacío")) {
                    txtConsola.append("Historial actual: " + hist + "\n");
                }
            }
        });

        btnEstado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = historial.obtenerCantidadAcciones();
                boolean vacio = historial.estaVacio();
                String estadoVacio = "";

                if (vacio == true) {
                    estadoVacio = "Sí";
                } else if (vacio == false) {
                    estadoVacio = "No";
                }

                txtConsola.append(String.format("Estado: %d acciones guardadas. ¿Está vacío? %s\n", cantidad, estadoVacio));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
}