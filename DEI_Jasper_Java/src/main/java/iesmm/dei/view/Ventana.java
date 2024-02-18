package iesmm.dei.view;

import iesmm.dei.conexion.Conexion;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import org.jfree.ui.JTextObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class Ventana extends JFrame {


    private JPanel panel;
    private JFrame frame;
    private JButton iniciar;
    private JLabel label;
    private JTextField textoBusqueda;

    public Ventana(){
        super("Lanzador Informe");
        frame = this;
        setSize(240,240);
        setLocation(400,200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new MigLayout("","10[]10[]10[]10","20[]20"));

        // Label del campo de texto
        label = new JLabel("Búsqueda de empleado:");
        panel.add(label, "wrap");

        // Campo de texto
        textoBusqueda = new JTextField();
        textoBusqueda.setPreferredSize(new Dimension(120, 20));
        panel.add(textoBusqueda);

        // Botón que inicializa la aplicación de conexión
        iniciar = new JButton("Lanzar Informe");
        panel.add(iniciar);

        // Listeners
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Conexion conexion = new Conexion("bbdd" + File.separator + "Northwind.db", "Custom.jasper");
                    conexion.setParametroReport(textoBusqueda.getText());
                    conexion.iniciar();
                    if (conexion.isConectado()){
                        conexion.desconectar();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error al cargar la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (JRException | SQLException ex){
                    System.err.println(ex.getMessage());
                    JOptionPane.showMessageDialog(frame, "Error al cargar el reporte.", "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        add(panel);
        pack();
    }
}
