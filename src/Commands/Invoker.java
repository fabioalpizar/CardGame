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
public class Invoker {
    // aqui esta el controlador de la consola
    
    private CommandManager commandManager;
    private Request request;
    
    public Invoker() {
        this.commandManager = new CommandManager();
    }
    
    public void setCommand(ICommand command) {
        commandManager.registerCommand(command);
    }
    
    public void comunicateConsole(String string) {
        commandManager.getCommand().execute(string);
    }
}
