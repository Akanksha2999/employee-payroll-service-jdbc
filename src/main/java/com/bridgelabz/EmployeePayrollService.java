package com.bridgelabz;

import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) throws SQLException {
        System.out.println("Status of connecting database to java code: ");
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "akanksha@99";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection done!!");
            Statement statement = connection.createStatement();
            statement.execute(" INSERT INTO employee_payroll(name,gender,basicPay,deductions,taxablePay,netPay,incomeTax,start)VALUES('Aayush','M',100000,2000,2000,1000,500,'2018-02-25')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " | " + resultSet.getString("name") + " | " + resultSet.getString("gender") + " | " + resultSet.getString("phone_number") + " | " + resultSet.getString("address") + " | " + resultSet.getString("department") + " | " + resultSet.getDouble("basicPay") + " | " + resultSet.getDouble("deductions") + " | " + resultSet.getDouble("taxablePay") + " | " + resultSet.getDouble("netPay") + " | " + resultSet.getDouble("incomeTax") + " | " + resultSet.getDate("start"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
