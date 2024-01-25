import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    private JMenuBar menuBar;
    private JMenu casa, extras;
    private JMenu habitaciones;
    private JMenuItem habitacion1, habitacion2, garaje, trastero;
    private JCheckBox salon;
    private ButtonGroup bg;
    private JRadioButton cocina, banio;
    private JPanel panel = new JPanel(new MigLayout("", "20[]20", "20[]20"));
    private JTextPane historial;
    public VentanaPrincipal(){

        super("Casa");
        JFrame frame = this;
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);

        // MENU BAR
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        // CASA & EXTRAS
        casa=new JMenu("Casa");
        menuBar.add(casa);

        extras=new JMenu("Extras");
        menuBar.add(extras);

        // CASA: HABITACIONES, SALÓN, COCINA & BAÑO
        habitaciones=new JMenu("Habitaciones");
        casa.add(habitaciones);

        salon=new JCheckBox("Salón");
        salon.setMnemonic(KeyEvent.VK_S);
        casa.add(salon);
        salon.addActionListener(this);

        casa.add(new JSeparator());

        cocina=new JRadioButton("Cocina");
        cocina.setMnemonic(KeyEvent.VK_C);
        casa.add(cocina);
        cocina.addActionListener(this);

        banio=new JRadioButton("Baño");
        banio.setMnemonic(KeyEvent.VK_B);
        casa.add(banio);

        banio.addActionListener(this);

        // RADIO BUTTONS GROUP
        bg = new ButtonGroup();
        bg.add(cocina);
        bg.add(banio);

        // HABITACIONES: HABITACIÓN_1 & HBITACIÓN_2
        habitacion1 = new JMenuItem("Habitación 1");
        habitaciones.add(habitacion1);
        habitacion1.addActionListener(this);

        habitacion2 = new JMenuItem("Habitación 2");
        habitacion2.setEnabled(false);
        habitaciones.add(habitacion2);
        habitacion2.addActionListener(this);

        // EXTRAS: GARAJE & TRASTERO
        garaje=new JMenuItem("Garaje");
        garaje.setMnemonic(KeyEvent.VK_G);
        extras.add(garaje);
        garaje.addActionListener(this);

        trastero=new JMenuItem("Trastero");
        trastero.setMnemonic(KeyEvent.VK_T);
        extras.add(trastero);
        trastero.addActionListener(this);

        // HISTORIAL
        historial = new JTextPane();
        historial.setSize(getSize());
        historial.setPreferredSize(getSize());
        panel.add(historial);
        pack();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == habitacion1) {

        }
        if (e.getSource() == habitacion2){

        }
        if (e.getSource() == salon) {

        }
        if (e.getSource() == cocina) {

        }
        if (e.getSource() == banio) {

        }
        if (e.getSource() == garaje){

        }
        if (e.getSource() == trastero){

        }
    }
}
