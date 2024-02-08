package iesmm.dei.conexion;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static net.sf.jasperreports.engine.util.JRLoader.getResource;

public class Conexion {
    private Connection connection;
    private String urlDB;
    private URL urlJasperReport;
    private File databaseFile;
    private File file;
    private String driver = "jdbc:sqlite:";
    private boolean conectado;

    public Conexion(String bbddPath, String jasperReportFileName){
        this.conectado = false;
        this.databaseFile = new File(bbddPath);
        this.urlDB = databaseFile.getPath();
        this.urlJasperReport = getResource(jasperReportFileName);
        this.file = new File(this.urlJasperReport.getPath());
    }

    // Inicia el programa, llamando a los métodos correspondientes.
    public void iniciar(){
        boolean conexion_realizada = conectar();

        if (conexion_realizada) { // Se comprueba que el resultado de la conexión fue satisfactorio.
            crearJasperViewer();
            // desconectar();
        }
    }

    // Método de conexión.
    private boolean conectar(){
        boolean out;
        try {
            if (databaseFile.exists() && databaseFile.isFile()){
                this.connection = DriverManager.getConnection(driver+urlDB);
                System.out.println("Conexión Establecida.");
                this.conectado = true;
                out = true;
            } else {
                System.err.println("No se ha podido establecer la conexión con la base de datos.");
                out = false;
            }
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getSQLState() + " -> " + e.getMessage());
            out = false;
        }
        return out;
    }

    // Método de desconexión.
    public void desconectar(){
        if (this.connection != null){
            try {
                this.connection.close();
                this.conectado = false;
            } catch (SQLException e) {
                System.err.println("ERROR: " + e.getSQLState() + "\n" + e.getMessage());
            }
        }
    }

    // Método que crea la vista del informe.
    private void crearJasperViewer(){
        try {
            JasperReport informe = (JasperReport) JRLoader.loadObject(this.file);
            JasperPrint print = JasperFillManager.fillReport(informe, null, this.connection);
            JasperViewer jasperViewer = new JasperViewer(print);
            jasperViewer.setVisible(true);
        } catch (JRException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    // Comprueba el estado de la conexión, para propósito de control de estado.
    public boolean isConectado() {
        return conectado;
    }
}
