import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JButton buttonSupIzq = new JButton();
    private JButton buttonSupDer = new JButton();
    private JButton buttonBotIzq = new JButton();
    private JButton buttonBotDer = new JButton();
    private JButton centroButton = new JButton();
    private Container contentPane = getContentPane();
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints layoutConst = new GridBagConstraints();

    public Ventana(){

        super("Ventana");
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(layout);

        buttonSupIzq.setText("Arriba Izquierda");
        buttonSupIzq.setMargin(new Insets(20,20,20,20));

        buttonSupDer.setText("Arriba Derecha");
        buttonSupDer.setMargin(new Insets(20,20,20,20));

        centroButton.setText("Centro");
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

    }

}
