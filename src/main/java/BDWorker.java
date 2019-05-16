//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class BDWorker {


    private final String URL = "jdbc:mysql://localhost:3306/mtg_exchange";
    private final String LOGIN = "mtg_user";
    private final String PASSWORD = "secret";

    private Connection connection;

    public BDWorker() {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
