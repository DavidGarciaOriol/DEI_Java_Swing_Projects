package Ej4_Numeros_Aleatorios;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VentanaPrincipal extends JFrame {

    private JFrame frame = this;
    private JPanel panel = new JPanel(new MigLayout(
            "",
            "10[]40[]20",
            "20[]10[]15[]15[]20"
    ));
    private JLabel num1Label = new JLabel("Número 1");
    private JLabel num2Label = new JLabel("Número 2");
    private JSpinner minSpinner = new JSpinner();
    private JSpinner maxSpinner = new JSpinner();
    private JTextField resutado = new JTextField();
    private JButton generarButton = new JButton("Generar");

    public VentanaPrincipal(){

        super("Generador Aleatorios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        resutado.setEditable(false);

        panel.add(num1Label);

        minSpinner.setPreferredSize(new Dimension(60,20));
        panel.add(minSpinner, "wrap");

        panel.add(num2Label);

        maxSpinner.setPreferredSize(new Dimension(60,20));
        panel.add(maxSpinner, "wrap");

        resutado.setPreferredSize(new Dimension(60,20));
        resutado.setText("0");
        panel.add(resutado, "wrap");

        panel.add(generarButton, "wrap");
        pack();

        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    resutado.setText(String.valueOf(generarRandom((int)(minSpinner.getValue()), ((int)maxSpinner.getValue()))));
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(frame, "El número superior debe ser mayor al inferior.");
                }
            }
        });
    }

    private int generarRandom(int num1, int num2){
        Random r = new Random();
        int result = r.nextInt((num2+1)-num1) + num1;
        return result;
    }
}
