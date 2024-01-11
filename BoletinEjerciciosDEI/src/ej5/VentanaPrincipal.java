package ej5;

import ej1.VentanaEmergente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JLabel jLabelInformativo = new JLabel("Escribe un nombre para saludar");
    private JTextField campoNombre = new JTextField();
    private JButton saludarButton = new JButton("¡Saludar!");
    private VentanaEmergente ventanaEmergente;
    private Container contentPane = getContentPane();
    private GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    public VentanaPrincipal(){

        super("Saludador");
        setSize(600,300);
        setMinimumSize(new Dimension(600,300));
        setMaximumSize(new Dimension(600,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL; // 2

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        contentPane.add(jLabelInformativo, gridBagConstraints);

        campoNombre.setPreferredSize(new Dimension(120,20));

        gridBagConstraints.weightx = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        contentPane.add(campoNombre, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        contentPane.add(saludarButton, gridBagConstraints);

        saludarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNombre != null
                        && !campoNombre.getText().equals("")
                        && !campoNombre.getText().isEmpty()
                ){
                    ventanaEmergente = new VentanaEmergente(campoNombre.getText());
                    ventanaEmergente.setVisible(true);
                } else {
                    ventanaEmergente = new VentanaEmergente("anónimo");
                    ventanaEmergente.setVisible(true);
                }
            }
        });

    }

}
