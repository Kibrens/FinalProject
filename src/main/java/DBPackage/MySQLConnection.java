package DBPackage;

import org.springframework.stereotype.Component;

import static DBPackage.Initialize.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private Connection con;

    private MySQLConnection() {

        try {

            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public Connection getCon() {
        return con;
    }
}
