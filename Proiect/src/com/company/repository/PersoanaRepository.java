package com.company.repository;

import com.company.config.databaseConfig;

import java.sql.*;

public class PersoanaRepository {
    public void CreateTable() {
        String CreateTableSQL = "CREATE TABLE IF NOT EXISTS persoane" +
                "(nume varchar(30), prenume varchar(30), varsta int)";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            start.execute(CreateTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddPersoana(String nume, String prenume, int varsta){
        String insertPersoana = "INSERT INTO persoane (nume, prenume, varsta) VALUES(?, ?, ?)";
        Connection connection = databaseConfig.getConnection();

        try{
            PreparedStatement prepareStatement = connection.prepareStatement(insertPersoana);
            prepareStatement.setString(1, nume);
            prepareStatement.setString(2, prenume);
            prepareStatement.setInt(3, varsta);

            prepareStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateVarsta(String nume, int varsta){
        String updateVarsta = "UPDATE persoane SET varsta=? where nume=?";
        Connection connection = databaseConfig.getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(updateVarsta);
            preparedStatement.setInt(1, varsta);
            preparedStatement.setString(2, nume);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeletePersoana(String nume){
        String deletePersoana = ("DELETE FROM persoane WHERE nume=?");
        Connection connection = databaseConfig.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deletePersoana);
            preparedStatement.setString(1, nume);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Print(){
        String selectSql = "SELECT * FROM persoane";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            ResultSet resultSet = start.executeQuery(selectSql);

            while(resultSet.next()){
                System.out.println("nume: " + resultSet.getString(1));
                System.out.println("prenume: " + resultSet.getString(2));
                System.out.println("varsta: "+ resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
