/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Game.Request;
import Log.Log;

/**
 *
 * @author kduran
 */
public class Error implements ICommand{

    private Request request;

    public Error() {
    }
    
    @Override
    public void execute(String string) {
        System.out.println("El comando no existe");
    }
    
}
