/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.CommandController;
import Game.Request;
import Log.Log;

/**
 *
 * @author kduran
 */
public class Exit implements ICommand{
    private CommandController controller;
    private Log log;
    public Exit(CommandController controller, Log log) {
        this.controller = controller;
        this.log = log;
    }

    @Override
    public void execute(Request string) {
        controller.exit("");
        log.sendMessage(string.toString());
    }
    
}
