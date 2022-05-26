package com.company.repository;

import com.company.config.databaseConfig;

import java.sql.*;

public class AngajatRepository {
    public void CreateTable() {
        String CreateTableSQL = "CREATE TABLE IF NOT EXISTS angajati" +
            "(nume varchar(30), prenume varchar(30), varsta int, numeJob varchar(30))";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            start.execute(CreateTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddAngajat(String nume, String prenume, int varsta, String numeJob){
        String insertAngajat = "INSERT INTO angajati(nume, prenume, varsta, numeJob) VALUES(?, ?, ?, ?)";
        Connection connection = databaseConfig.getConnection();

        try{
            PreparedStatement prepareStatement = connection.prepareStatement(insertAngajat);
            prepareStatement.setString(1, nume);
            prepareStatement.setString(2, prenume);
            prepareStatement.setInt(3, varsta);
            prepareStatement.setString(4, numeJob);

            prepareStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateNumeJob(String nume, String numeJob){
        String updatejob = "UPDATE angajati SET numeJob=? where nume=?";
        Connection connection = databaseConfig.getConnection();

        try{
                PreparedStatement preparedStatement = connection.prepareStatement(updatejob);
                preparedStatement.setString(1, numeJob);
                preparedStatement.setString(2, nume);

                preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAngajat(String nume){
        String deleteAngajat = ("DELETE FROM angajati WHERE nume=?");
        Connection connection = databaseConfig.getConnection();
        try{
                PreparedStatement preparedStatement = connection.prepareStatement(deleteAngajat);
                preparedStatement.setString(1, nume);

                preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Print(){
        String selectSql = "SELECT * FROM angajati";
        Connection connection = databaseConfig.getConnection();

        try{
            Statement start = connection.createStatement();
            ResultSet resultSet = start.executeQuery(selectSql);

            while(resultSet.next()){
                System.out.println("nume: " + resultSet.getString(1));
                System.out.println("prenume: " + resultSet.getString(2));
                System.out.println("varsta: "+ resultSet.getInt(3));
                System.out.println("nume job: " + resultSet.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
