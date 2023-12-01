import javax.swing.*;

public class ControladorCalculadora {

    private int calcular(char operacion, int num1, int num2){

        int resultado;

        switch (operacion){
            case '+':
                resultado = num1+num2;
                break;
            case '-':
                resultado = num1-num2;
                break;
            case '*':
                resultado = num1*num2;
                break;
            case '/':
                resultado = num1/num2;
                break;
            default:
                resultado = 0;
        }
        return resultado;
    }

    private void borrarTextBox(JTextField textField){
        textField.setText("0");
    }

    private void suprimirNumero(JTextField textField){
        textField.setText(textField.getText().substring(0,-1));
    }

    private void esribirNumero(JTextField textField, char numero){
        textField.setText(textField.getText()+numero);
    }

}
