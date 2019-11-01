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
    private Log log;

    public Error(Log log) {
        this.log = log;
    }
    
    @Override
    public void setRequest(Request request) {
        this.request = request;
    }
    
    @Override
    public void execute() {
        System.out.println("El comando no existe");
        log.exit(request);
    }
    
}
