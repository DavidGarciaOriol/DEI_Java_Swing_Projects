package Ej2_Lista_Peliculas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JLabel infoLabel1 = new JLabel("Escribe el título de una película");
    private JLabel infoLabel2 = new JLabel("Películas");
    private JTextField nombrePeliculaCampo = new JTextField();
    private JComboBox<String> listaPeliculasComboBox = new JComboBox<String>();
    private JButton agregarBoton = new JButton("Añadir");

    private JPanel panel = new JPanel(new net.miginfocom.swing.MigLayout(
            "",
            "[]40[]",
            "[]20[]20[]"
    ));

    public VentanaPrincipal(){

        super("Lista Películas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        panel.add(infoLabel1);
        panel.add(infoLabel2, "wrap");

        nombrePeliculaCampo.setSize(200,20);
        nombrePeliculaCampo.setPreferredSize(nombrePeliculaCampo.getSize());
        panel.add(nombrePeliculaCampo);

        listaPeliculasComboBox.setSize(200,20);
        listaPeliculasComboBox.setPreferredSize(listaPeliculasComboBox.getSize());
        panel.add(listaPeliculasComboBox, "wrap");

        panel.add(agregarBoton);
        pack();

        agregarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaPeliculasComboBox.addItem(nombrePeliculaCampo.getText());
                listaPeliculasComboBox.setSelectedIndex(listaPeliculasComboBox.getItemCount()-1);
                nombrePeliculaCampo.setText("");
                nombrePeliculaCampo.requestFocus();
            }
        });
    }

}
