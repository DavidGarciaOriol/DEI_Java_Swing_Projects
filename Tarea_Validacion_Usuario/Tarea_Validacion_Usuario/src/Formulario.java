import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {

    public Formulario(){
        super("Formulario");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label_usuario = new JLabel("Usuario");
        add(label_usuario);

        JTextField textField_usuario = new JTextField();
        textField_usuario.setSize(200,40);
        add(textField_usuario);

        JLabel label_password = new JLabel("Contraseña");
        add( label_password);

        JTextField textField_password = new JTextField();
        textField_password.setSize(200,40);
        add(textField_password);
    }

}
