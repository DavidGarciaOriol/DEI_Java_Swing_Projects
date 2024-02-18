package org.example.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VentanaConversor extends JFrame {

    private JPanel panel, panelTemperaturas, panelDeslizadores, panelValores;
    private JLabel celsiusLabel, fahrenheitLabel;
    private JSlider sliderCelsius, sliderFahrenheit;
    private JTextField gradosCelsius, gradosFahrenheit;

    public VentanaConversor(){
        super("Conversor Temperatura");
        setSize(220, 360);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        panel = new JPanel(new MigLayout("", "20[]20", "5[]0[]0[]10"));
        panel.setBackground(Color.LIGHT_GRAY);

        // Paneles auxiliares para los conjuntos de elementos.
        panelTemperaturas = new JPanel(new MigLayout("", "5[]55[]10", ""));
        panelTemperaturas.setBackground(Color.LIGHT_GRAY);
        panelDeslizadores = new JPanel(new MigLayout("", "10[]40[]10", ""));
        panelDeslizadores.setBackground(Color.LIGHT_GRAY);
        panelValores = new JPanel(new MigLayout("", "20[]50[]20", ""));
        panelValores.setBackground(Color.LIGHT_GRAY);


        // Labels para las temperaturas
        fahrenheitLabel = new JLabel("ºF");
        fahrenheitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fahrenheitLabel.setPreferredSize(new Dimension(32,32));
        fahrenheitLabel.setHorizontalAlignment(SwingConstants.CENTER);

        celsiusLabel = new JLabel("ºC");
        celsiusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        celsiusLabel.setPreferredSize(new Dimension(32,32));
        celsiusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Añadimos los elementos al panel contextual
        panelTemperaturas.add(fahrenheitLabel);
        panelTemperaturas.add(celsiusLabel);


        // Deslizadores de temperaturas
        sliderFahrenheit = new JSlider();
        sliderFahrenheit.setBackground(Color.LIGHT_GRAY);
        sliderFahrenheit.setForeground(Color.BLACK);
        sliderFahrenheit.setMaximum(140);
        sliderFahrenheit.setMinimum(32);
        sliderFahrenheit.setOrientation(SwingConstants.VERTICAL);
        sliderFahrenheit.setMinorTickSpacing(10);
        sliderFahrenheit.setMajorTickSpacing(20);
        sliderFahrenheit.setPaintTrack(true);
        sliderFahrenheit.setPaintTicks(true);
        sliderFahrenheit.setPaintLabels(true);
        sliderFahrenheit.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        sliderFahrenheit.setValue(32);

        sliderCelsius = new JSlider();
        sliderCelsius.setBackground(Color.LIGHT_GRAY);
        sliderCelsius.setForeground(Color.BLACK);
        sliderCelsius.setMaximum(60);
        sliderCelsius.setMinimum(0);
        sliderCelsius.setOrientation(SwingConstants.VERTICAL);
        sliderCelsius.setMinorTickSpacing(5);
        sliderCelsius.setMajorTickSpacing(10);
        sliderCelsius.setPaintTrack(true);
        sliderCelsius.setPaintTicks(true);
        sliderCelsius.setPaintLabels(true);
        sliderCelsius.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        sliderCelsius.setValue(0);

        // Añadimos los elementos al panel contextual
        panelDeslizadores.add(sliderFahrenheit);
        panelDeslizadores.add(sliderCelsius);


        // Campos de texto para mostrar los valores de las temperaturas
        gradosFahrenheit = new JTextField();
        gradosFahrenheit.setBackground(Color.LIGHT_GRAY);
        gradosFahrenheit.setEditable(false);
        gradosFahrenheit.setEnabled(false);
        gradosFahrenheit.setDisabledTextColor(new Color(0,0,0));
        gradosFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
        gradosFahrenheit.setPreferredSize(new Dimension(40,28));
        gradosFahrenheit.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        gradosFahrenheit.setText("32");

        gradosCelsius = new JTextField();
        gradosCelsius.setBackground(Color.LIGHT_GRAY);
        gradosCelsius.setEditable(false);
        gradosCelsius.setEnabled(false);
        gradosCelsius.setDisabledTextColor(new Color(0,0,0));
        gradosCelsius.setHorizontalAlignment(SwingConstants.CENTER);
        gradosCelsius.setPreferredSize(new Dimension(40,28));
        gradosCelsius.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        gradosCelsius.setText("0");

        // Añadimos los elementos al panel contextual
        panelValores.add(gradosFahrenheit);
        panelValores.add(gradosCelsius);


        // Añadimos los paneles contextuales al panel principal.
        panel.add(panelTemperaturas, "wrap");
        panel.add(panelDeslizadores, "wrap");
        panel.add(panelValores);

        // Listeners
        sliderCelsius.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gradosCelsius.setText(String.valueOf(sliderCelsius.getValue()));
                if (sliderCelsius.hasFocus()){
                    sliderFahrenheit.setValue(sliderCelsius.getValue() * 9/5 + 32);
                }
            }
        });

        sliderFahrenheit.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gradosFahrenheit.setText(String.valueOf(sliderFahrenheit.getValue()));

                if (sliderFahrenheit.hasFocus()){
                    sliderCelsius.setValue((sliderFahrenheit.getValue()-32) * 5/9);
                }
            }
        });

        add(panel);
    }
}
