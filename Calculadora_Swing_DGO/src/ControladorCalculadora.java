public class ControladorCalculadora {

    public int calcular(char operacion, int num1, int num2){

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
}
