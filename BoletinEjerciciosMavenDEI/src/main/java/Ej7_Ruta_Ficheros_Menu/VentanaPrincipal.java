package Ej7_Ruta_Ficheros_Menu;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaPrincipal extends JFrame {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout("","15[]10","[]20[]20"));
    private JTextField rutaTextField = new JTextField();
    private JMenuBar jMenuBar = createMenu();


    public VentanaPrincipal() {

        super("Mostrar");
        setMaximumSize(new Dimension(300,140));
        setMinimumSize(new Dimension(300,140));
        setPreferredSize(new Dimension(300,140));
        setSize(300,140);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        rutaTextField.setPreferredSize(new Dimension(240,20));

        add(jMenuBar, "wrap");
        panel.add(rutaTextField);

        pack();
    }

    private JMenuBar createMenu() {
        JMenuBar menu = new JMenuBar();
        menu.setSize(frame.getWidth(), 20);
        menu.setPreferredSize(new Dimension(frame.getWidth(), 20));

        JMenuItem menuItem1 = new JMenuItem("Abrir...");
        JMenuItem menuItem2 = new JMenuItem("Salir");

        JMenu submenu = new JMenu("File");

        submenu.add(menuItem1);
        submenu.add(menuItem2);
        menu.add(submenu);

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(frame);

                if (fileChooser.getSelectedFile() != null){
                    if (fileChooser.getSelectedFile().getName().endsWith(".txt")){
                        rutaTextField.setText((new File(String.valueOf(fileChooser.getSelectedFile())).getPath()));
                    } else {
                        JOptionPane.showMessageDialog(frame, "El archivo seleccionado debe ser un archivo de texto, con extensión \".txt\"");
                    }
                }
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });

        return menu;
    }
}
