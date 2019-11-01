/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.CommandController;
import Game.GameManager;
import Game.Request;
import Log.Log;

/**
 *
 * @author kduran
 */
public class GiveUp implements ICommand{

    private GameManager controller;
    private Log log;
    public GiveUp(GameManager controller, Log log) {
        this.controller = controller;
        this.log = log;
    }
    
    @Override
    public void execute(Request string) {
        controller.giveUp();
        log.sendMessage(string.toString());
    }
    
}
