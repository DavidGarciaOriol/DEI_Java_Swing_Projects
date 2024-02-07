package sqlite_ej_1;

import java.sql.*;

public class Main {
    public static void getQuery(String filename) {
        // SQLite connection string
        String url = "jdbc:sqlite:BBDD/" + filename;

        // SQL statement for creating a new table
        String sql = "";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        getQuery("agendaDB.db");
    }
}


