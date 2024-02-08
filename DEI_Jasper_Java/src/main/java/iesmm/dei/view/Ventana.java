package iesmm.dei.view;

import iesmm.dei.conexion.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private JButton iniciar;
    private JPanel panel;
    private JFrame frame;

    public Ventana(){
        super("Lanzador Informe");
        frame = this;
        setSize(140,100);
        setLocation(400,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciar = new JButton("Lanzar Informe");
        iniciar.setMargin(new Insets(12,12,12,12));
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conexion conexion = new Conexion("bbdd\\Northwind.db", "MiReport.jasper");
                    conexion.iniciar();
                    if (conexion.isConectado()){
                        conexion.desconectar();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error al cargar la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex){
                    System.err.println(ex.getMessage());
                    JOptionPane.showMessageDialog(frame, "Error al cargar el reporte.", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        panel = new JPanel();
        panel.add(iniciar);

        add(panel);
    }
}
