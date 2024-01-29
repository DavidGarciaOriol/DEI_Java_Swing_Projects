package org.iesmm.dei.calculadora_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private JPanel panel = new JPanel(new GridLayout(6,4));
    private JTextPane display;
    private int numero1 = 0;
    private int numero2 = 0;
    private int resultado = 0;
    private char operacion = 'N';
    public VentanaPrincipal(){

        super("Calculadora");
        JFrame frame = this;
        setSize(300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(panel);

        // DECLARACIÓN DE BOTONES

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
        display = new JTextPane();
        display.setText("0");
        display.setEnabled(false);
        display.setDisabledTextColor(Color.black);
        display.setPreferredSize(new Dimension(80,20));

        panel.add(display);
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        switch (actionCommand){
            case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                if (display.getText().equals("0") || display.getText().equals("#ERROR /0"))
                    display.setText(actionCommand);
                else display.setText(display.getText() + actionCommand);
                break;
            case "0":
                if (!display.getText().equals("0"))
                    if (!display.getText().equals("#ERROR /0"))
                        display.setText(display.getText() + actionCommand);
                break;
            case "+":
                if (!display.getText().equals("#ERROR /0"))
                    numero1 = numero1!=0?numero1:Integer.parseInt(display.getText());
                display.setText("0");
                operacion = '+';
                break;
            case "-":
                if (!display.getText().equals("#ERROR /0"))
                    numero1 = numero1!=0?numero1:Integer.parseInt(display.getText());
                display.setText("0");
                operacion = '-';
                break;
            case "x":
                if (!display.getText().equals("#ERROR /0"))
                    numero1 = numero1!=0?numero1:Integer.parseInt(display.getText());
                display.setText("0");
                operacion = 'x';
                break;
            case "/":
                if (!display.getText().equals("#ERROR /0"))
                    numero1 = numero1!=0?numero1:Integer.parseInt(display.getText());
                display.setText("0");
                operacion = '/';
                break;
            case "=":
                if (!display.getText().equals("#ERROR /0")){
                    try {
                        if (numero2 == 0)
                            numero2 = Integer.parseInt(display.getText());
                        resultado = operar(numero1, numero2);
                        display.setText(String.valueOf(resultado));
                        numero1 = resultado;
                        resultado = 0;

                    } catch (ArithmeticException ex){
                        display.setText("#ERROR /0");
                        numero1 = 0;
                        numero2 = 0;
                        resultado = 0;
                    }

                }
                break;
            case "CE":
                // TODO: CLEAR ENTRY
                display.setText("0");
                numero2 = 0;
                break;
            case "C":
                display.setText("0");
                numero1 = 0;
                numero2 = 0;
                resultado = 0;
                operacion = 'N';
                break;
            case "DEL":
                if (!display.getText().equals("#ERROR /0")){
                    display.setText(eliminarUltimoCaracter(display.getText()));
                    numero1 = operacion=='N'?Integer.parseInt(display.getText()):numero1;
                    numero2 = operacion=='N'?numero2:Integer.parseInt(display.getText());
                }
                break;
            case "SHELL":
                try {
                    System.out.println("NUM1: " + (numero1==Integer.parseInt(display.getText())?numero1:Integer.parseInt(display.getText()))
                            + " | NUM2: " + (numero2==0?Integer.parseInt(display.getText()):numero2)
                            + " | RESULTADO: " +operar(numero1, (numero2==0?Integer.parseInt(display.getText()):numero2))
                            + " | OPERADOR: " + operacion);
                } catch (ArithmeticException ex){
                    System.err.println("ERROR CONTROLADO: DIVIDIR ENTRE 0 - " + ex.getMessage()
                            + "\nNUM1: " + (numero1==Integer.parseInt(display.getText())?numero1:Integer.parseInt(display.getText()))
                            + " | NUM2: " + (numero2==0?Integer.parseInt(display.getText()):numero2)
                            + " | OPERADOR: " + operacion);
                }
        }
    }

    // CALCULAR EN FUNCIÓN AL OPERADOR PULSADO MÁS RECIENTE
    private int operar(int num1, int num2){
        int out = 0;
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
                out = Integer.parseInt(display.getText());
        }
        return out;
    }

    public static String eliminarUltimoCaracter(String msg) {
        return (msg == null || msg.isEmpty() || msg.length() == 1)
                ? "0"
                : (msg.substring(0, msg.length() - 1));
    }
}
