package ej1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmergente extends JFrame {
    protected JFrame estaVentana = this;
    private JLabel saludoLabel = new JLabel();
    private JButton okButton = new JButton("OK");
    private Container contentPane = getContentPane();
    private GridBagLayout gridBagLayout = new GridBagLayout();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public VentanaEmergente(String nombreParaSaludar){

        super("Saludo");
        setSize(200,400);
        setMaximumSize(new Dimension(400,200));
        setMinimumSize(new Dimension(400,200));
        contentPane.setLayout(gridBagLayout);

        gridBagConstraints.fill = GridBagConstraints.VERTICAL; // 3

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        contentPane.add(saludoLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        contentPane.add(okButton, gridBagConstraints);

        saludoLabel.setText("¡Hola "+nombreParaSaludar+"!");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estaVentana.setVisible(false);
                estaVentana.dispose();
            }
        });
    }


}
