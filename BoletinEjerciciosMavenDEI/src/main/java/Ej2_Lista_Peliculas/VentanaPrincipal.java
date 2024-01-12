package Ej2_Lista_Peliculas;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JLabel infoLabel1 = new JLabel();
    private JLabel infoLabel2 = new JLabel();
    private JTextField nombrePeliculaCampo = new JTextField();
    private JComboBox<String> listaPeliculasComboBox = new JComboBox<String>();
    private JButton agregarBoton = new JButton("Añadir");

    private JPanel panel = new JPanel(new net.miginfocom.swing.MigLayout());
    public VentanaPrincipal(){

        super("Lista Películas");
        setSize(600,300);
        setMinimumSize(new Dimension(600,300));
        setMaximumSize(new Dimension(600,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);



    }

}
