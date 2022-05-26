package com.company.repository;
import com.company.config.databaseConfig;

import java.sql.*;

public class AdresaRepository {
    public void CreateTable() {
        String CreateTableSQL = "CREATE TABLE IF NOT EXISTS adrese" +
                "(tara varchar(30), oras varchar(30), strada varchar(30), numar int)";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            start.execute(CreateTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddAdresa(String tara, String oras, String strada, int numar){
        String insertAdresa = "INSERT INTO adrese (tara, oras, strada, numar) VALUES(?, ?, ?, ?)";
        Connection connection = databaseConfig.getConnection();

        try{
            PreparedStatement prepareStatement = connection.prepareStatement(insertAdresa);
            prepareStatement.setString(1, tara);
            prepareStatement.setString(2, oras);
            prepareStatement.setString(3, strada);
            prepareStatement.setInt(4, numar);

            prepareStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateNumar(String strada, int numar){
        String updateNumar = "UPDATE adrese SET numar=? where strada=?";
        Connection connection = databaseConfig.getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateNumar);
            preparedStatement.setInt(1, numar);
            preparedStatement.setString(2, strada);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void DeleteAdresa(String strada){
        String deleteAdresa = ("DELETE FROM adrese WHERE strada=?");
        Connection connection = databaseConfig.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAdresa);
            preparedStatement.setString(1, strada);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Print(){
        String selectSql = "SELECT * FROM adrese";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            ResultSet resultSet = start.executeQuery(selectSql);

            while(resultSet.next()){
                System.out.println("tara: " + resultSet.getString(1));
                System.out.println("oras: " + resultSet.getString(2));
                System.out.println("strada: " + resultSet.getString(3));
                System.out.println("numar: "+ resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
