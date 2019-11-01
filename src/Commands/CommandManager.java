/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.CommandController;

/**
 *
 * @author kduran
 */
public class CommandManager {
    private ICommand command;

    public CommandManager() {
    }
    
    public ICommand getCommand(){
        return command;
    }
    
    public void registerCommand (ICommand command) {
        this.command = command;
    }
    
}
