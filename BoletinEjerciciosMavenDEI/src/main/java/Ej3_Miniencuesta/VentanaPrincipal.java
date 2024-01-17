package Ej3_Miniencuesta;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout(
            "",
            "25[]25",
            "20[]7[]7[]7[]5[]5[]7[]7[]7[]7[]7[]7[]7[]20"
    ));
    private JPanel panelSecundario = new JPanel(new MigLayout(
            "",
            "[]40[]",
            ""
    ));
    private JLabel eligeOSLabel = new JLabel("Elige un sistema operativo");
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton windowsOSRadio = new JRadioButton("Windows");
    private JRadioButton linuxOSRadio = new JRadioButton("Linux");
    private JRadioButton macOSRadio = new JRadioButton("Mac");
    private JLabel eligeEspecialidadLabel = new JLabel("Elige tu especialidad");
    private JCheckBox programacionCheckbox = new JCheckBox("Programación");
    private JCheckBox dgraficoCheckbox = new JCheckBox("Diseño Gráfico");
    private JCheckBox administracionCheckbox = new JCheckBox("Administración");
    private JLabel horasPCLabel = new JLabel("Horas que dedicas en el ordenador");
    private JLabel numeroHorasPCLabel = new JLabel("0");
    private JSlider horasPCSlider = new JSlider(SwingConstants.HORIZONTAL);
    private JButton generarButton = new JButton("Generar");
    private JSeparator separator1 = new JSeparator();
    private JSeparator separator2 = new JSeparator();

    public VentanaPrincipal(){

        super("Mini Encuesta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);

        panel.add(eligeOSLabel, "wrap");

        bg.add(windowsOSRadio);
        panel.add(windowsOSRadio, "wrap");

        bg.add(linuxOSRadio);
        panel.add(linuxOSRadio, "wrap");

        bg.add(macOSRadio);
        panel.add(macOSRadio, "wrap");

        separator1.setPreferredSize(new Dimension(240,2));
        panel.add(separator1, "wrap");
        panel.add(eligeEspecialidadLabel, "wrap");

        panel.add(programacionCheckbox, "wrap");
        panel.add(dgraficoCheckbox, "wrap");
        panel.add(administracionCheckbox, "wrap");

        separator2.setPreferredSize(new Dimension(240,2));
        panel.add(separator2, "wrap");
        panel.add(horasPCLabel, "wrap");

        panelSecundario.add(numeroHorasPCLabel);

        horasPCSlider.setMaximum(24);
        horasPCSlider.setMinimum(0);
        horasPCSlider.setValue(0);
        panelSecundario.add(horasPCSlider);
        panel.add(panelSecundario, "wrap");

        panel.add(generarButton);
        pack();

        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String out = "Tu sistema operativo es: ";

                if (windowsOSRadio.isSelected()) {
                    out += "\n - Windows";
                }  else if (linuxOSRadio.isSelected()) {
                    out += "\n - Linux";
                }  else if (macOSRadio.isSelected()) {
                    out += "\n - Mac";
                }

                out += "\nTus especialidades son: ";

                if (programacionCheckbox.isSelected()){
                    out += "\n - Programación";
                }
                if (dgraficoCheckbox.isSelected()){
                    out += "\n - Diseño Gráfico";
                }
                if (administracionCheckbox.isSelected()){
                    out += "\n - Administración";
                }

                out += "\nY el número de horas dedicadas al ordenador son: \n - "
                        + numeroHorasPCLabel.getText();

                JOptionPane.showMessageDialog(frame, out);
            }
        });
        horasPCSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                numeroHorasPCLabel.setText(String.valueOf(((JSlider) e.getSource()).getValue()));
            }
        });
    }
}
