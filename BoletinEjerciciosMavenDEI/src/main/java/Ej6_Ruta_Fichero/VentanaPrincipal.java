package Ej6_Ruta_Fichero;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class VentanaPrincipal extends JFrame {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout("","15[]5[]10","20[]5[]20"));
    private JLabel msgLabel = new JLabel("Pulsa y elige una ruta");
    private JTextField rutaTextField = new JTextField();
    private JButton openButton = new JButton("...");

    public VentanaPrincipal() {

        super("Mostrar");
        setMaximumSize(new Dimension(300,140));
        setMinimumSize(new Dimension(300,140));
        setPreferredSize(new Dimension(300,140));
        setSize(300,140);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        rutaTextField.setPreferredSize(new Dimension(240,20));
        panel.add(msgLabel, "wrap");
        panel.add(rutaTextField); panel.add(openButton);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(frame);

                if (fileChooser.getApproveButtonMnemonic() != 0){
                    if (fileChooser.getSelectedFile() != null){
                        if (fileChooser.getSelectedFile().getName().endsWith(".txt")){
                            rutaTextField.setText((new File(String.valueOf(fileChooser.getSelectedFile())).getPath()));
                        } else {
                            JOptionPane.showMessageDialog(frame, "El archivo seleccionado debe ser un archivo de texto, con extensión \".txt\"");
                        }
                    }
                }
            }
        });
        pack();
    }
}
