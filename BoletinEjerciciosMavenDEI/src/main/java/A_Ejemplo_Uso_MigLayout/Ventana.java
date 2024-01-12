package A_Ejemplo_Uso_MigLayout;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private final int BOTON_NORMAL_WIDTH = 96, BTTNX = BOTON_NORMAL_WIDTH;
    private final int BOTON_NORMAL_HEIGHT = 24, BTTNY = BOTON_NORMAL_HEIGHT;
    JPanel panel = new JPanel(new net.miginfocom.swing.MigLayout()); // MigLayout agregado al JPanel del JFrame principal

    public Ventana(){
        super("Ventana");
        setSize(1280, 720);
        setContentPane(panel);

        JButton jButton;
        for (int i = 1; i<= 10; i++){
            jButton = new JButton("Botón" + i);

            switch (i){
                case 3, 8:
                    jButton.setSize(BTTNX, BTTNY);
                    jButton.setPreferredSize(new Dimension(BTTNX, BTTNY));
                    panel.add(jButton, "wrap");
                    break;
                case 5:
                    jButton.setSize(BTTNX*2, BTTNY);
                    jButton.setPreferredSize(new Dimension(BTTNX*2, BTTNY));
                    panel.add(jButton, "span 2, wrap");
                    break;
                case 9:
                    jButton.setSize(BTTNX*2, BTTNY);
                    jButton.setPreferredSize(new Dimension(BTTNX*2, BTTNY));
                    panel.add(jButton, "span 2");
                    break;
                default:
                    jButton.setSize(BTTNX, BTTNY);
                    jButton.setPreferredSize(new Dimension(BTTNX, BTTNY));
                    panel.add(jButton);
            }
        }
        pack();
    }
}
