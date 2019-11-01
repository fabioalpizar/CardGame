/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.CommandController;
import Game.Request;

/**
 *
 * @author kduran
 */
public class RechargeWeapon implements ICommand{

    private CommandController controller;
    
    public RechargeWeapon(CommandController controller) {
        this.controller = controller;
    }
            
    @Override
    public void execute(String string) {
        controller.sendMessage(string);
    }
    
}
