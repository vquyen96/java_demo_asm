/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Accounts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Quyeens
 */
public class AccountModels {
    public boolean checkLogin(String username, String password) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_asm?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '"+username+"' AND password = '"+password+"'");
        if (rs.next()) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean addMember(String username, String password) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_asm?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        try{  
            stt.execute("INSERT INTO accounts(username,password,balance,createdAt,status) VALUE('"
                +username+"','"
                +password+"',0,0,1)");
            return true;
        }catch(ArithmeticException e){
            System.out.println(e);
            return false;
        }
        
    }
    public void getAccount(String username) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_asm?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '"+username+"'");
        while (rs.next()) {
            System.out.println(" ---- ");
            System.out.println("AccountNumber : " + rs.getInt("accountNumber"));
            System.out.println("Username : " + rs.getString("username"));
            System.out.println("Balance : " + rs.getInt("balance"));
        }
    }
    
    public boolean getMon(String username, int mon) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_asm?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '"+username+"'");
        int balance = 0;
        while (rs.next()) {
            balance = rs.getInt("balance");
            if (balance<mon) {
                return false;
            }
            else{
                balance-=mon;
            }
            stt.execute("UPDATE accounts SET balance = "+balance+" WHERE username = '"+username+"'");
            return true;
        }
        return false;
    }
    
    public boolean addMon(String username, int mon) throws SQLException{
        Connection cnn = 
                DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_asm?useUnicode=true&characterEncoding=UTF-8","root","");
        Statement stt = cnn.createStatement();
        ResultSet rs = stt.executeQuery("SELECT * FROM accounts WHERE username = '"+username+"'");
        int balance = 0;
        while (rs.next()) {
            balance = rs.getInt("balance");
            balance+=mon;
            stt.execute("UPDATE accounts SET balance = "+balance+" WHERE username = '"+username+"'");
            return true;
        }
        return false;
    }
}
