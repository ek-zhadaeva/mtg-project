//import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class BDWorker {


    private final String URL = "jdbc:mariadb://localhost:3306/mtg_exchange";
    private final String LOGIN = "mtg_user";
    private final String PASSWORD = "secret";

    private Connection connection;

    public BDWorker() {

        try {
          //  Driver driver = new FabricMySQLDriver();
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);


        } catch (SQLException e) {
            System.err.println("Неудалось подключить класс драйвера!");
        } catch (ClassNotFoundException e) {
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
