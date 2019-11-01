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
public class GiveUp implements ICommand{

    private CommandController controller;
    private Log.Log log;
    private Request request;
    
    public GiveUp(CommandController controller, Log.Log log) {
        this.controller = controller;
        this.log = log;
    }
    
    @Override
    public void setRequest(Request request) {
        this.request = request;
    }
    
    @Override
    public void execute() {
        controller.giveUp(request);
        log.giveUp(request);
    }
    
}
