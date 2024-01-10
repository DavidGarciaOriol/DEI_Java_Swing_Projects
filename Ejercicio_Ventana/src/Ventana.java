import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventana extends JFrame {

    private JButton buttonSupIzq = new JButton();
    private JButton buttonSupDer = new JButton();
    private JButton buttonBotIzq = new JButton();
    private JButton buttonBotDer = new JButton();
    private JToggleButton centroButton = new JToggleButton();
    private Container contentPane = getContentPane();
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints layoutConst = new GridBagConstraints();

    public Ventana(){

        super("Centro");
        setSize(300,300);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(layout);

        buttonSupIzq.setText("Arriba Izquierda");
        buttonSupIzq.setMargin(new Insets(20,20,20,20));

        buttonSupDer.setText("Arriba Derecha");
        buttonSupDer.setMargin(new Insets(20,20,20,20));

        centroButton.setText("Aumenta Dimensión");
        centroButton.setMargin(new Insets(20,20,20,20));

        buttonBotIzq.setText("Abajo Izquierda");
        buttonBotIzq.setMargin(new Insets(20,20,20,20));

        buttonBotDer.setText("Abajo Derecha");
        buttonBotDer.setMargin(new Insets(20,20,20,20));


        layoutConst.fill = GridBagConstraints.HORIZONTAL; // 2

        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        contentPane.add(buttonSupIzq, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        contentPane.add(buttonSupDer, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        contentPane.add(centroButton, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        contentPane.add(buttonBotIzq, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        contentPane.add(buttonBotDer, layoutConst);

        buttonSupIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // setLocation(0,0);
                // setTitle("Arriba Izquierda");

                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setLocation(0,0);
                newFrame.setTitle("Arriba Izquierda");
                newFrame.setSize(300,300);

                generarBotonCerrar(newFrame);
            }
        });
        buttonSupDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // setLocation(1920-getSize().width,0);
                // setTitle("Arriba Derecha");

                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setLocation(1920-getSize().width,0);
                newFrame.setTitle("Arriba Derecha");
                newFrame.setSize(300,300);

                generarBotonCerrar(newFrame);
            }
        });
        buttonBotIzq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // setLocation(0,1080-getSize().height);
                // setTitle("Abajo Izquierda");

                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setLocation(0,1080-getSize().height);
                newFrame.setTitle("Abajo Izquierda");
                newFrame.setSize(300,300);

                generarBotonCerrar(newFrame);
            }
        });
        buttonBotDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // setLocation(1920-getSize().width,1080-getSize().height);
                // setTitle("Abajo Derecha");

                JFrame newFrame = new JFrame();
                newFrame.setVisible(true);
                newFrame.setLocation(1920-getSize().width,1080-getSize().height);
                newFrame.setTitle("Abajo Derecha");
                newFrame.setSize(300,300);

                generarBotonCerrar(newFrame);
            }
        });
        centroButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    setSize(600,600);
                    centroButton.setText("Disminuye Dimensión");
                    setTitle("600 x 600");
                } else if(e.getStateChange() == ItemEvent.DESELECTED){
                    setSize(300,300);
                    centroButton.setText("Aumenta Dimensión");
                    setTitle("300 x 300");
                }
            }
        });
    }

    public void generarBotonCerrar(JFrame newFrame){
        JButton closeButton = new JButton();
        closeButton.setText("Cerrar");
        newFrame.add(closeButton);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                newFrame.dispose();
            }
        });
    }
}
