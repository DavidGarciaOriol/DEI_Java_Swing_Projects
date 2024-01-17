package Ej1_Saludador;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JLabel jLabelInformativo = new JLabel("Escribe un nombre para saludar");
    private JTextField campoNombre = new JTextField();
    private JButton saludarButton = new JButton("¡Saludar!");
    private JPanel panel = new JPanel(new MigLayout("", "40[]40", "30[]30[]30[]30"));
    public VentanaPrincipal(){

        super("Saludador");
        JFrame frame = this;
        setSize(290,240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);


        panel.add(jLabelInformativo, "wrap");
        panel.add(campoNombre,"wrap,  gapleft 30");
        panel.add(saludarButton, "gapleft 50");

        campoNombre.setPreferredSize(new Dimension(120,20));
        saludarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNombre != null
                        && !campoNombre.getText().equals("")
                        && !campoNombre.getText().isEmpty()
                ){
                    JOptionPane.showMessageDialog(frame, "¡Hola " + campoNombre.getText() + "!");
                } else {
                    JOptionPane.showMessageDialog(frame,"¡Hola anónimo!");

                }
            }
        });
    }

}
