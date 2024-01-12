package A_Ejemplo_Uso_MigLayout;

public class App {

    public static void main(String[] args) {

        try{
            Ventana ventana = new Ventana();
            ventana.setVisible(true);
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage() +"\n"+ e.getLocalizedMessage() +"\n"+ e.getCause() +"\n"+ e.getStackTrace());
        }

    }
}
