/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_asm;

import controller.AccountController;
import java.sql.SQLException;
import model.AccountModels;

/**
 *
 * @author Quyeens
 */
public class Demo_asm {
    public static void main(String[] args) throws SQLException {
        AccountController ctrl = new AccountController();
        AccountModels model = new AccountModels();
        
        while (true) {     
            boolean menu = true;
            switch(ctrl.getHome()){
                case "1":
                    if (ctrl.getLogin()) {
                        while (menu) {                            
                            switch(ctrl.getMenu()){
                                case "1":
                                    ctrl.getInfo();
                                    break;
                                case "2":
                                    ctrl.getMoney();
                                    break;
                                case "3":
                                    ctrl.addMoney();
                                    break;
                                default:
                                    menu = false;
                                    break;
                            }
                        }
                    }
                    break;
                case "2":
                    ctrl.register();
                    break;
                default:
                    System.out.println("Nhap sai roi");
                    break;
            }
        }
    }
    
}
