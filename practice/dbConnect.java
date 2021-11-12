/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author alsul
 */
public class dbConnect {

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:derby:D:\\db-derby-10.15.2.0-bin\\lib\\testDB;create=true";
        String select_sql = "SELECT * FROM people";
        //String insert_sql = "INSERT INTO PEOPLE(name,id,age) VALUES " + "('klooo',2,30)";

        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();

        //statement.executeUpdate(insert_sql);
        ResultSet result = statement.executeQuery(select_sql);

        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
        for (int i = 1; i < numberOfColumns; i++) {
            System.out.printf("%-8s\t", metaData.getColumnName(i));
            System.out.println();
            System.out.println(numberOfColumns);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("NAME");
                int age = result.getInt("age");
                System.out.printf("%d\t \t %s \t \t %d \n", id, name, age);
            }

        }

    }

}
