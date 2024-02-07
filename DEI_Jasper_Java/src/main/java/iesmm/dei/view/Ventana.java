package iesmm.dei.view;

import iesmm.dei.conexion.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JButton iniciar;
    private JPanel panel;

    public Ventana(){
        super("Lanzador Informe");
        setSize(140,100);
        setLocation(400,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciar = new JButton("Lanzar Informe");
        iniciar.setMargin(new Insets(12,12,12,12));
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexion conexion = new Conexion();
                conexion.iniciar();
            }
        });

        panel = new JPanel();
        panel.add(iniciar);

        add(panel);
    }
}
