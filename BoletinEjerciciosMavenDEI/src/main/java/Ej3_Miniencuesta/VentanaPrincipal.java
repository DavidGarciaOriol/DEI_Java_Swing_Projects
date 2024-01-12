package Ej3_Miniencuesta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JPanel panel = new JPanel(new net.miginfocom.swing.MigLayout());
    public VentanaPrincipal(){

        super("Mini Encuesta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

    }

}
