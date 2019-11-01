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
public class UseWildCard implements ICommand{
    private GameManager gameManager;
    private Log log;
    public UseWildCard(GameManager gameManager, Log log) {
        this.gameManager = gameManager;
        this.log = log;
    }
    
    @Override
    public void execute(Request request) {
        gameManager.useWildCard(request.getCharacter(), request.getWeapon(), request.getCharacter2(), request.getWeapon2());
        log.sendMessage(request.toString());
    }
    
}
