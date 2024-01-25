import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame implements ActionListener{

    // CONTADORES

    private int entradas_habitacion = 0;
    private int entradas_salon = 0;
    private int entradas_cocina = 0;
    private int entradas_banio = 0;
    private int entradas_garaje = 0;
    private int entradas_trastero = 0;

    // COMPONENTS
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
        salon.setSelected(true);
        salon.setMnemonic(KeyEvent.VK_S);
        casa.add(salon);
        salon.addActionListener(this);

        casa.add(new JSeparator());

        cocina=new JRadioButton("Cocina");
        cocina.setSelected(true);
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
        historial.setEditable(false);
        historial.setSize(getSize());
        historial.setPreferredSize(getSize());
        panel.add(historial);
        pack();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == habitacion1) {
            entradas_habitacion++;
            historial.setText(historial.getText() + "\n" + "Has entrado a la habitación "
                    + entradas_habitacion + (entradas_habitacion>1?" veces.":" vez."));
        }
        if (e.getSource() == salon) {
            entradas_salon += salon.isSelected()?1:0;
            historial.setText(historial.getText() + "\n" + "Has entrado al salón "
                    + entradas_salon + (entradas_salon>1||entradas_salon==0?" veces.":" vez.") + " Estado "
                    + (salon.isSelected()?"activado.":"desactivado."));
        }
        if (e.getSource() == cocina) {
            entradas_cocina ++;
            historial.setText(historial.getText() + "\n" + "Has entrado a la cocina "
                    + entradas_cocina + (entradas_cocina>1?" veces.":" vez.") + " Estado "
                    + (cocina.isSelected()?"activado.":"desactivado."));
        }
        if (e.getSource() == banio) {
            entradas_banio ++;
            historial.setText(historial.getText() + "\n" + "Has entrado al baño " + entradas_banio
                    + (entradas_banio>1?" veces.":" vez.") + " Estado "
                    + (banio.isSelected()?"activado.":"desactivado."));
        }
        if (e.getSource() == garaje){
            entradas_garaje++;
            historial.setText(historial.getText() + "\n" + "Has entrado al garaje "
                    + entradas_garaje + (entradas_garaje>1?" veces.":" vez."));
        }
        if (e.getSource() == trastero){
            entradas_trastero++;
            historial.setText(historial.getText() + "\n" + "Has entrado al trastero "
                    + entradas_garaje + (entradas_garaje>1?" veces.":" vez."));
        }
    }
}
