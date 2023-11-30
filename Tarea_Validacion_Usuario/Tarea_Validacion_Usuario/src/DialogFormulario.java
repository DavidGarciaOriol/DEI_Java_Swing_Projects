import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogFormulario extends JDialog implements ActionListener {

    private JButton button;
    private JLabel userpasscorrecto_label;

    public DialogFormulario(Formulario parent, boolean modal, boolean user_pass_correctos){
        super(parent, modal);
        setLayout(null);



        setBounds(440,10,410,210);

        userpasscorrecto_label = new JLabel();
        if (user_pass_correctos){
            userpasscorrecto_label.setText("CORRECTO");
        } else {
            userpasscorrecto_label.setText("INCORRECTO");
        }
        userpasscorrecto_label.setBounds(115,60,200,30);
        add(userpasscorrecto_label);

        button = new JButton("Volver");
        button.setBounds(105,110,200,40);
        add(button);

        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            //Cierro la pantalla
            setVisible(false);
        }
    }
}
