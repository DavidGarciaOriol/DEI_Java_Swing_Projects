package Ej5_Imitador_Espejo;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout("", "", "5[]5[]5[]5[]5"));
    private JPanel panelSuperior = new JPanel(new MigLayout("", "20[]20[]20[]20", "5[]10[]10[]5"));
    private JPanel panelInferior = new JPanel(new MigLayout("", "20[]20[]20[]20", "5[]10[]10[]5"));

    // PANEL SUPERIOR
    private JLabel original = new JLabel("Original");

    private ButtonGroup buttonGroupRadiobuttons = new ButtonGroup();
    private JRadioButton radio1 = new JRadioButton("Opcion 1");
    private JRadioButton radio2 = new JRadioButton("Opcion 2");
    private JRadioButton radio3 = new JRadioButton("Opcion 3");
    private JCheckBox check1 = new JCheckBox("Opcion 4");
    private JCheckBox check2 = new JCheckBox("Opcion 5");
    private JCheckBox check3 = new JCheckBox("Opcion 6");

    private JTextField textField = new JTextField();

    private JComboBox<String> comboBox = new JComboBox<String>();

    private JSpinner spinner = new JSpinner();

    //SEPARADOR
    private JSeparator separator = new JSeparator();

    //PANEL INFERIOR ESPEJO
    private JLabel espejo = new JLabel("Espejo");

    private ButtonGroup buttonGroupRadiobuttonsEspejo = new ButtonGroup();
    private JRadioButton radio1Espejo = new JRadioButton(radio1.getText());
    private JRadioButton radio2Espejo = new JRadioButton(radio2.getText());
    private JRadioButton radio3Espejo = new JRadioButton(radio3.getText());
    private JCheckBox check1Espejo = new JCheckBox(check1.getText());
    private JCheckBox check2Espejo = new JCheckBox(check2.getText());
    private JCheckBox check3Espejo = new JCheckBox(check3.getText());

    private JTextField textFieldEspejo = new JTextField();

    private JComboBox<String> comboBoxEspejo = new JComboBox<String>();

    private JSpinner spinnerEspejo = new JSpinner();



    public VentanaPrincipal() {

        super("Imitador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setMaximumSize(new Dimension(340, 320));
        setMinimumSize(new Dimension(340, 320));
        setSize(340, 320);
        setPreferredSize(new Dimension(340, 320));
        setResizable(false);

        // SEPARATOR
        separator.setPreferredSize(new Dimension(320,2));

        // COMBOBOX
        montarCombobox(20);

        // RADIO GROUPING ORIGINAL
        buttonGroupRadiobuttons.add(radio1);
        buttonGroupRadiobuttons.add(radio2);
        buttonGroupRadiobuttons.add(radio3);

        // RADIO GROUPING ESPEJO
        buttonGroupRadiobuttonsEspejo.add(radio1Espejo);
        buttonGroupRadiobuttonsEspejo.add(radio2Espejo);
        buttonGroupRadiobuttonsEspejo.add(radio3Espejo);

        // SIZING ORIGINAL
        textField.setPreferredSize(new Dimension(80,30));
        textField.setSize(80,30);

        comboBox.setPreferredSize(new Dimension(80,30));
        comboBox.setSize(80,30);

        spinner.setPreferredSize(new Dimension(80,30));
        spinner.setSize(80,30);

        // SIZING ESPEJO
        textFieldEspejo.setPreferredSize(new Dimension(textField.getSize()));
        textFieldEspejo.setSize(textField.getWidth(), textField.getHeight());

        comboBoxEspejo.setPreferredSize(comboBox.getSize());
        comboBoxEspejo.setSize(comboBox.getWidth(), comboBox.getHeight());

        spinnerEspejo.setPreferredSize(spinner.getSize());
        spinnerEspejo.setSize(spinner.getHeight(), spinner.getHeight());

        // LLAMADA A MÉTODOS DE MAQUETACIÓN
        montarOriginal();
        montarEspejo();
        montarVentanaPrincipal();

        // DESACTIVAMOS PANEL ESPEJO
        desactivarPanelInferior();

        // PACKING
        pack();

        // LISTENERS
        radio1.addActionListener(this);
        radio1.setActionCommand("radio1");

        radio2.addActionListener(this);
        radio2.setActionCommand("radio2");

        radio3.addActionListener(this);
        radio3.setActionCommand("radio3");

        check1.addActionListener(this);
        check1.setActionCommand("check1");

        check2.addActionListener(this);
        check2.setActionCommand("check2");

        check3.addActionListener(this);
        check3.setActionCommand("check3");

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                textFieldEspejo.setText(textField.getText()+e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                comboBoxEspejo.setSelectedIndex(comboBox.getSelectedIndex());
            }
        });

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spinnerEspejo.setValue(spinner.getValue());
            }
        });
    }

    private void desactivarPanelInferior(){
        for (Component component: panelInferior.getComponents()) {
            component.setEnabled(false);
        }
        panelSuperior.getComponents();
    }

    private void montarVentanaPrincipal(){
        panel.add(original,"wrap");
        panel.add(panelSuperior,"wrap");
        panel.add(separator,"wrap");
        panel.add(espejo,"wrap");
        panel.add(panelInferior,"wrap");
    }

    private void montarOriginal(){
        panelSuperior.add(radio1);
        panelSuperior.add(check1);
        panelSuperior.add(textField, "wrap");

        panelSuperior.add(radio2);
        panelSuperior.add(check2);
        panelSuperior.add(comboBox, "wrap");

        panelSuperior.add(radio3);
        panelSuperior.add(check3);
        panelSuperior.add(spinner, "wrap");

    }

    private void montarEspejo(){
        panelInferior.add(radio1Espejo);
        panelInferior.add(check1Espejo);
        panelInferior.add(textFieldEspejo, "wrap");

        panelInferior.add(radio2Espejo);
        panelInferior.add(check2Espejo);
        panelInferior.add(comboBoxEspejo, "wrap");

        panelInferior.add(radio3Espejo);
        panelInferior.add(check3Espejo);
        panelInferior.add(spinnerEspejo, "wrap");

    }

    private void montarCombobox(int items){
        for (int i = 0;i < items; i++){
            comboBox.addItem("Item " + (i+1));
            comboBoxEspejo.addItem("Item " + (i+1));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action){
            case "radio1":
                if (radio1.isSelected()) radio1Espejo.setSelected(true);
                else radio1Espejo.setSelected(false);
                break;
            case "radio2":
                if (radio2.isSelected()) radio2Espejo.setSelected(true);
                else radio1Espejo.setSelected(false);
                break;
            case "radio3":
                if (radio3.isSelected()) radio3Espejo.setSelected(true);
                else radio3Espejo.setSelected(false);
                break;
            case "check1":
                if (check1.isSelected()) check1Espejo.setSelected(true);
                else check1Espejo.setSelected(false);
                break;
            case "check2":
                if (check2.isSelected()) check2Espejo.setSelected(true);
                else check2Espejo.setSelected(false);
                break;
            case "check3":
                if (check3.isSelected()) check3Espejo.setSelected(true);
                else check3Espejo.setSelected(false);
                break;
        }
    }
}
