package org.iesmm.dei.calculadora_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener{

    // COMPONENTES ESTÁTICOS
    private JFrame frame = this;
    private JPanel panel = new JPanel(new GridLayout(6,4));
    private JTextPane display;

    // VARIABLES DE LA LÓGICA DEL PROGRAMA
    private double numero1 = 0;
    private double numero2 = 0;
    private double resultado = 0;
    private char operacion = 'N';
    private boolean resultado_otenido = false;
    public VentanaPrincipal(){

        // MAQUETACIÓN DEL FRAME PRINCIPAL

        super("Calculadora");
        JFrame frame = this;
        setSize(300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);

        // DECLARACIÓN DE BOTONES DINÁMICOS

        for (int i = 0; i < 20; i++){
            JButton button = new JButton();
            switch (i){
                case 0:
                    button.setText("1");
                    button.setActionCommand("1");
                    break;
                case 1:
                    button.setText("2");
                    button.setActionCommand("2");
                    break;
                case 2:
                    button.setText("3");
                    button.setActionCommand("3");
                    break;
                case 3:
                    button.setText("+");
                    button.setActionCommand("+");
                    break;
                case 4:
                    button.setText("4");
                    button.setActionCommand("4");
                    break;
                case 5:
                    button.setText("5");
                    button.setActionCommand("5");
                    break;
                case 6:
                    button.setText("6");
                    button.setActionCommand("6");
                    break;
                case 7:
                    button.setText("-");
                    button.setActionCommand("-");
                    break;
                case 8:
                    button.setText("7");
                    button.setActionCommand("7");
                    break;
                case 9:
                    button.setText("8");
                    button.setActionCommand("8");
                    break;
                case 10:
                    button.setText("9");
                    button.setActionCommand("9");
                    break;
                case 11:
                    button.setText("x");
                    button.setActionCommand("x");
                    break;
                case 12:
                    button.setText(",");
                    button.setActionCommand(",");
                    break;
                case 13:
                    button.setText("0");
                    button.setActionCommand("0");
                    break;
                case 14:
                    button.setText("=");
                    button.setActionCommand("=");
                    break;
                case 15:
                    button.setText("/");
                    button.setActionCommand("/");
                    break;
                case 16:
                    button.setText("CE");
                    button.setActionCommand("CE");
                    break;
                case 17:
                    button.setText("C");
                    button.setActionCommand("C");
                    break;
                case 18:
                    button.setText("DEL");
                    button.setActionCommand("DEL");
                    break;
                case 19:
                    button.setText("SHELL");
                    button.setActionCommand("SHELL");
                    break;
            }
            button.addActionListener(this);
            add(button);
        }

        // CONFECCIÓN DEL DISPLAY

        display = new JTextPane();
        display.setText("0");
        display.setEnabled(false);
        display.setDisabledTextColor(Color.black);
        display.setPreferredSize(new Dimension(80,20));

        display.add(new JScrollPane());

        panel.add(display);
        pack();
    }

    // LISTENER DE BOTONES PULSADOS
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand){

            /** Al pulsar los números, se comprueba el display y se agregan si
             * procede al mismo, modificando la variable correspondiente en función
             * del contexto y situación de la operación.
             */
            case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                if (display.getText().equals("0") || display.getText().equals("#ERROR /0")){
                    display.setText(actionCommand);
                } else {
                    display.setText(display.getText() + actionCommand);
                }
                if (operacion != 'N'){
                    if (resultado_otenido){
                        numero1 = Double.parseDouble(display.getText());
                    } else {
                        numero2 = Double.parseDouble(display.getText());
                    }
                } else {
                    numero1 = Double.parseDouble(display.getText());
                }
                break;

            case "0":
                if (!display.getText().equals("0")){
                    if (!display.getText().equals("#ERROR /0")){
                        display.setText(display.getText() + actionCommand);
                        if (operacion != 'N'){
                            if (resultado_otenido){
                                numero1 =Double.parseDouble(display.getText());
                            } else {
                                numero2 = Double.parseDouble(display.getText());
                            }
                        } else {
                            numero1 = Double.parseDouble(display.getText());
                        }
                    }
                }
                break;

            /** Agrega un punto para operar con decimales
             * siempre y cuando no haya uno ya.
             */
            case ",":
                if (!display.getText().contains(".")){
                    display.setText(display.getText() + ".");
                }
                break;

            /** El siguiente bloque controla el estado de la operación,
             * y a continuación indica el tipo de operación  que se deberá
             * realizar cuando se pulse en el botón igual (=).
             */
            case "+":
                if (!display.getText().equals("#ERROR /0")){
                    if (operacion != 'N') numero2 = 0;
                    resultado_otenido = false;
                    operacion = '+';
                }
                display.setText("0");
                break;

            case "-":
                if (!display.getText().equals("#ERROR /0")){
                    if (operacion != 'N') numero2 = 0;
                    resultado_otenido = false;
                    operacion = '-';
                }
                display.setText("0");
                break;

            case "x":
                if (!display.getText().equals("#ERROR /0")){
                    if (operacion != 'N') numero2 = 0;
                    resultado_otenido = false;
                    operacion = 'x';
                }
                display.setText("0");
                break;

            case "/":
                if (!display.getText().equals("#ERROR /0")){
                    if (operacion != 'N') numero2 = 0;
                    resultado_otenido = false;
                    operacion = '/';
                }
                display.setText("0");
                break;

            /** Realiza la operación pertinente, controlando errores. */
            case "=":
                if (!display.getText().equals("#ERROR /0")){

                        resultado = operar(numero1, numero2);
                        display.setText(String.valueOf(resultado));
                        numero1 = resultado;
                        resultado_otenido = true;

                        if (resultado == Double.POSITIVE_INFINITY || resultado == Double.NEGATIVE_INFINITY){
                            display.setText("#ERROR /0");
                            numero1 = 0;
                            numero2 = 0;
                            resultado = 0;
                            resultado_otenido = false;
                            JOptionPane.showMessageDialog(frame, "ERROR AL INTENTAR DIVIDIR ENTRE CERO");
                        }
                }
                break;

            /** Resetea el display en el contexto de la operación actual. */
            case "CE":
                display.setText("0");
                if (resultado_otenido){
                    numero1 = 0;
                } else {
                    numero2 = 0;
                }
                break;

            /** Reinicia toda la operación, dejando los valores a cero. */
            case "C":
                display.setText("0");
                numero1 = 0;
                numero2 = 0;
                resultado = 0;
                operacion = 'N';
                resultado_otenido = false;
                break;

            /** Elimina el último número o carácter agregado al display. */
            case "DEL":
                if (!display.getText().equals("#ERROR /0")){
                    display.setText(eliminarUltimoCaracter(display.getText()));

                    if (operacion != 'N'){
                        if (resultado_otenido){
                            numero1 = Double.parseDouble(display.getText());
                        } else {
                            numero2 = Double.parseDouble(display.getText());
                        }
                    } else {
                        numero1 = Double.parseDouble(display.getText());
                    }
                }
                break;

            /** Funnción para DEBUG en consola. */
            case "SHELL":
                try {
                    System.out.println("NUM1: " + numero1
                            + " | NUM2: " + numero2
                            + " | RESULTADO: " + operar(numero1, numero2)
                            + " | OPERADOR: " + operacion);
                } catch (ArithmeticException ex){
                    System.err.println("ERROR CONTROLADO: DIVIDIR ENTRE 0 - " + ex.getMessage()
                            + "\nNUM1: " + numero1
                            + " | NUM2: " + numero2
                            + " | OPERADOR: " + operacion);
                }
        }
    }

    // CALCULAR EN FUNCIÓN AL OPERADOR PULSADO MÁS RECIENTE
    private double operar(double num1, double num2){
        double out = 0;
        switch (operacion){
            case '+':
                out = num1 + num2;
                break;
            case '-':
                out = num1 - num2;
                break;
            case 'x':
                out = num1 * num2;
                break;
            case '/':
                out = num1 / num2;
                break;
            default:
                out = Double.parseDouble(display.getText());
        }
        return out;
    }

    // ELIMINA EL ÚLTIMO NÚMERO/CARACTER DE LA CADENA DEL DISPLAY
    public static String eliminarUltimoCaracter(String msg) {
        return (msg == null || msg.isEmpty() || msg.length() == 1)
                ? "0"
                : (msg.substring(0, msg.length() - 1));
    }
}
