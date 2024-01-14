package Ej5_Imitador_Espejo;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout());

    public VentanaPrincipal() {

        super("Imitador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

    }
}
