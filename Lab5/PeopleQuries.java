/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author alsul
 */
public class PeopleQuries {

    private static final String URL = "jdbc:mysql://localhost:3306/addressappdb";
    private final String user="root";
    private final String pass="3638";
    private Connection connection;

    private PreparedStatement selectAllPeople;
    private PreparedStatement selectByPhoneNumber;
    private PreparedStatement insertNewPerson;

    public PeopleQuries() {
        try {
            connection = DriverManager.getConnection(URL,user,pass);

            selectAllPeople = connection.prepareStatement("SELECT * FROM PEOPLE");

            selectByPhoneNumber = connection.prepareStatement("SELECT * FROM PEOPLE WHERE NUMBER = ? ");

            insertNewPerson = connection.prepareStatement("INSERT INTO PEOPLE (firstname,lastname,number) VALUES (?,?,?)");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    public List<People> getAllPeople() {

        try ( ResultSet resultSet = selectAllPeople.executeQuery()) {
            List<People> result = new ArrayList<People>();

            while (resultSet.next()) {
                result.add(new People(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("number")));
            }

            return result;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;

    }

    public List<People> getPeopleByNumber(int number) {

        try {
            selectByPhoneNumber.setInt(1, number);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        try ( ResultSet resultSet = selectByPhoneNumber.executeQuery()) {
            List<People> result = new ArrayList<People>();

            while (resultSet.next()) {
                result.add(new People(
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("number")));

            }

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    
    public boolean isInDB(int number){
        try {
            selectByPhoneNumber.setInt(1, number);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try ( ResultSet resultSet = selectByPhoneNumber.executeQuery()) {
            List<People> result = new ArrayList<People>();

            
            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        return false;
    }

    public int addPeople(String firstName, String lastName, int number) {
        
        try{
            insertNewPerson.setString(1,firstName);
            insertNewPerson.setString(2,lastName);
            insertNewPerson.setInt(3, number);
            
            return insertNewPerson.executeUpdate();
            
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
     }
    
    
    public void close(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
