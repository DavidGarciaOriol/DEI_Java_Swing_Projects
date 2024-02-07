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
    private File file;

    public Conexion(){
        this.urlDB = "D:\\ciclot\\DGO\\DEI_Java_Swing_Projects\\DEI_Jasper_Java\\bbdd\\Northwind.db";
        this.urlJasperReport = getResource("MiReport.jasper");
        file = new File(this.urlJasperReport.getPath());
    }

    public void iniciar(){
        boolean conexion_realizada = conectar();
        if (conexion_realizada) {
            crearJasperViewer();
            desconectar();
        }
    }

    private boolean conectar(){
        boolean out = false;
        try {
            this.connection = DriverManager.getConnection(urlDB);
            System.out.println("Conexión establecida con SQLite");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getSQLState() + "\n" + e.getMessage());
        }
        return out;
    }

    private void desconectar(){
        if (this.connection != null){
            try {
                this.connection.close();
            } catch (SQLException e) {
                System.err.println("ERROR: " + e.getSQLState() + "\n" + e.getMessage());
            }
        }
    }

    private void crearJasperViewer(){
        try {
            JasperReport informe = (JasperReport) JRLoader.loadObject(file);
            JasperPrint print = JasperFillManager.fillReport(informe, null, connection);
            JasperViewer jasperViewer = new JasperViewer(print);
            jasperViewer.setVisible(true);
        } catch (JRException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
