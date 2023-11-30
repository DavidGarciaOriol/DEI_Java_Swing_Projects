import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame implements ActionListener{
    private Container contentPane;
    private GridLayout gridLayout;
    private JLabel label_usuario, label_password;
    private JTextField textField_usuario, textField_password;
    private JButton button_enviar;

    public Formulario(){
        super("Formulario");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        gridLayout = new GridLayout(5,1);
        gridLayout.setHgap(3); gridLayout.setVgap(3);
        contentPane.setLayout(gridLayout);

        label_usuario = new JLabel("Usuario");
        contentPane.add(label_usuario);

        textField_usuario = new JTextField();
        textField_usuario.setSize(160,20);
        contentPane.add(textField_usuario);

        label_password = new JLabel("Contraseña");
        contentPane.add(label_password);

        textField_password = new JTextField();
        textField_password.setSize(160,20);
        contentPane.add(textField_password);

        button_enviar = new JButton();
        button_enviar.setText("Enviar");
        button_enviar.addActionListener(this);
        contentPane.add(button_enviar);

    }

    public boolean validarDatos(JTextField usuarioTextField, JTextField passwordTextField){

        boolean out;

        String usuario = usuarioTextField.getText();
        String password = passwordTextField.getText();

        if (validarUsuario(usuario) && validarPassword(password)){
            System.out.println("CORRECTO");
            out = true;
        } else {
            System.err.println("INCORRECTO");
            out = false;
        }
        return out;
    }

    public boolean validarUsuario(String usuario){
        return usuario.equals("Anacleto");
    }

    public boolean validarPassword(String password){
        return password.equals("12345678");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean user_pass_correctos = validarDatos(textField_usuario, textField_password);
        DialogFormulario dialogFormulario = new DialogFormulario(this,true, user_pass_correctos);
        dialogFormulario.setVisible(true);
    }
}
