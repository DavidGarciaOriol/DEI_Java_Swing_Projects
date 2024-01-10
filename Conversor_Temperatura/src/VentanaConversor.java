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

        GridLayout gridLayout = new GridLayout(3,2);

        cp.setLayout(gridLayout);

        celsiusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        celsiusLabel.setSize(60,60);

        fahrenheitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fahrenheitLabel.setSize(60,60);

        JPanel panelSliderCelsius = new JPanel();
        JPanel panelSliderFahrenheit = new JPanel();

        panelSliderCelsius.setLayout(new BoxLayout(panelSliderCelsius, BoxLayout.Y_AXIS));
        panelSliderCelsius.add(sliderCelsius);

        panelSliderFahrenheit.setLayout(new BoxLayout(panelSliderFahrenheit, BoxLayout.Y_AXIS));
        panelSliderFahrenheit.add(sliderFahrenheit);

        sliderCelsius.setLayout(new BoxLayout(sliderCelsius, BoxLayout.Y_AXIS));
        sliderCelsius.setMaximum(60);
        sliderCelsius.setMinimum(0);
        sliderCelsius.setOrientation(SwingConstants.VERTICAL);
        sliderCelsius.setMinorTickSpacing(5);
        sliderCelsius.setMajorTickSpacing(10);
        sliderCelsius.setPaintTrack(true);
        sliderCelsius.setPaintTicks(true);
        sliderCelsius.setPaintLabels(true);
        sliderCelsius.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));

        sliderFahrenheit.setLayout(new BoxLayout(sliderFahrenheit, BoxLayout.Y_AXIS));
        sliderFahrenheit.setMaximum(140);
        sliderFahrenheit.setMinimum(32);
        sliderFahrenheit.setOrientation(SwingConstants.VERTICAL);
        sliderFahrenheit.setMinorTickSpacing(10);
        sliderFahrenheit.setMajorTickSpacing(20);
        sliderFahrenheit.setPaintTrack(true);
        sliderFahrenheit.setPaintTicks(true);
        sliderFahrenheit.setPaintLabels(true);

        gradosCelsius.setEditable(false);
        gradosCelsius.setHorizontalAlignment(SwingConstants.CENTER);

        gradosFahrenheit.setEditable(false);
        gradosFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);

        cp.add(celsiusLabel); cp.add(fahrenheitLabel);
        cp.add(panelSliderCelsius); cp.add(panelSliderFahrenheit);
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
