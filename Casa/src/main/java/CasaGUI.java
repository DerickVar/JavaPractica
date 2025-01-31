import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasaGUI extends JFrame {
    private JTextField tfAncho, tfLargo, tfAlto, tfPisos;
    private JTextArea taResultado;
    private Casa[] casas;
    private int indice;

    public CasaGUI() {
        casas = new Casa[10]; // Arreglo de 10 casas
        indice = 0;

        setTitle("Verificación de Casas Homónimas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para ingresar datos de la casa
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        panelFormulario.add(new JLabel("Ancho:"));
        tfAncho = new JTextField();
        panelFormulario.add(tfAncho);

        panelFormulario.add(new JLabel("Largo:"));
        tfLargo = new JTextField();
        panelFormulario.add(tfLargo);

        panelFormulario.add(new JLabel("Alto:"));
        tfAlto = new JTextField();
        panelFormulario.add(tfAlto);

        panelFormulario.add(new JLabel("Número de pisos:"));
        tfPisos = new JTextField();
        panelFormulario.add(tfPisos);

        JButton btnAgregarCasa = new JButton("Agregar Casa");
        panelFormulario.add(btnAgregarCasa);

        // Área de texto para mostrar el resultado
        taResultado = new JTextArea();
        taResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taResultado);

        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnAgregarCasa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double ancho = Double.parseDouble(tfAncho.getText());
                    double largo = Double.parseDouble(tfLargo.getText());
                    double alto = Double.parseDouble(tfAlto.getText());
                    int pisos = Integer.parseInt(tfPisos.getText());

                    if (indice < 10) {
                        Casa nuevaCasa = new Casa(ancho, largo, alto, pisos);
                        casas[indice++] = nuevaCasa;

                        // Verificar si hay casas homónimas
                        String resultado = "Casas Homónimas:\n";
                        boolean hayHomónimas = false;
                        for (int i = 0; i < indice; i++) {
                            for (int j = i + 1; j < indice; j++) {
                                if (casas[i].esHomónima(casas[j])) {
                                    resultado += casas[i].toString() + " y " + casas[j].toString() + "\n";
                                    hayHomónimas = true;
                                }
                            }
                        }

                        if (!hayHomónimas) {
                            resultado = "No se encontraron casas homónimas.";
                        }
                        taResultado.setText(resultado);
                    } else {
                        taResultado.setText("Ya se han ingresado 10 casas.");
                    }
                } catch (NumberFormatException ex) {
                    taResultado.setText("Por favor ingrese datos válidos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        CasaGUI ventana = new CasaGUI();
        ventana.setVisible(true);
    }
}
