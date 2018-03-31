/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Accounts;
import java.sql.SQLException;
import java.util.Scanner;
import model.AccountModels;

/**
 *
 * @author Quyeens
 */
public class AccountController {
    AccountModels mod = new AccountModels();
    private String username;
    public String getHome(){
        System.out.println("1-Dang Nhap.");
        System.out.println("2-Dang Ky");
        Scanner sc = new Scanner(System.in);
        String pick = sc.nextLine();
        return pick;
    }
    public boolean getLogin() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("username: ");
        this.username = sc.nextLine();
        System.out.print("password: ");
        String password = sc.nextLine();
        boolean check = mod.checkLogin(username, password);
        return check;
    }
    public void register() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("username: ");
        String username = sc.nextLine();
        System.out.print("password: ");
        String password = sc.nextLine();
        boolean check = mod.addMember(username, password);
        if (check) {
            System.out.println("Thanh Cong");
        }
        else{
            System.out.println("Khong thanh cong");
        }
        return ;
    }
    public String getMenu(){
        System.out.println("1-Truy van tai khoan");
        System.out.println("2-Rut tien");
        System.out.println("3-Nap tien");
        Scanner sc = new Scanner(System.in);
        String pick = sc.nextLine();
        return pick;
    }
    
    public boolean getInfo() throws SQLException{
        mod.getAccount(this.username);
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return true ;
    }
    
    public void getMoney() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ban muon rut : ");
        int money = scanner.nextInt();
        if (mod.getMon(username, money)) {
            System.out.println("Rut tien thanh cong");
            String scan = scanner.nextLine();
        }
        else{
            System.out.println("Tai khoan khong du tien");
            return;
        }
    }
    
    public void addMoney() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ban muon nap : ");
        int money = scanner.nextInt();
        if (mod.addMon(username, money)) {
            System.out.println("Nap tien thanh cong");
            String scan = scanner.nextLine();
        }
        else{
            System.out.println("That bai");
            return;
        }
    }
}
