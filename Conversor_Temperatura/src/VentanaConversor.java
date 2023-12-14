import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class VentanaConversor extends JFrame {

    private JLabel celsiusLabel = new JLabel("Cº");
    private JLabel fahrenheitLabel = new JLabel("Fº");
    private JSlider sliderCelsius = new JSlider();
    private JSlider sliderFahrenheit = new JSlider();
    private JTextField gradosCelsius = new JTextField();
    private JTextField gradosFahrenheit = new JTextField();
    public VentanaConversor(){
        super("Conversor Temperatura");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3,2));

        celsiusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        celsiusLabel.setSize(60,60);
        fahrenheitLabel.setHorizontalAlignment(SwingConstants.CENTER);

        sliderCelsius.setMaximum(60);
        sliderCelsius.setMinimum(0);
        sliderCelsius.setOrientation(SwingConstants.VERTICAL);
        sliderCelsius.setMinorTickSpacing(5);
        sliderCelsius.setMajorTickSpacing(10);
        sliderCelsius.setPaintTrack(true);
        sliderCelsius.setPaintTicks(true);
        sliderCelsius.setPaintLabels(true);

        sliderFahrenheit.setMaximum(140);
        sliderFahrenheit.setMinimum(32);
        sliderFahrenheit.setOrientation(SwingConstants.VERTICAL);
        sliderFahrenheit.setMinorTickSpacing(10);
        sliderFahrenheit.setMajorTickSpacing(20);
        sliderFahrenheit.setPaintTrack(true);
        sliderFahrenheit.setPaintTicks(true);
        sliderFahrenheit.setPaintLabels(true);

        gradosCelsius.setSize(20,20);
        gradosCelsius.setMargin(new Insets(10,10,10,10));
        gradosCelsius.setEditable(false);
        gradosCelsius.setHorizontalAlignment(SwingConstants.CENTER);

        gradosFahrenheit.setSize(20,20);
        gradosFahrenheit.setMargin(new Insets(10,10,10,10));
        gradosFahrenheit.setEditable(false);
        gradosFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);

        cp.add(celsiusLabel); cp.add(fahrenheitLabel);
        cp.add(sliderCelsius); cp.add(sliderFahrenheit);
        cp.add(gradosCelsius); cp.add(gradosFahrenheit);

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
    }
}
