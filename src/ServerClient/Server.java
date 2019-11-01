/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;

import Game.GameManager;
import Game.Player;
import Game.Request;
import Game.Response;
import ObserverPattern.IObserver;
import Server.AbstractMessage;
import Server.AbstractServer;

/**
 *
 * @author Pumkin
 */
public class Server extends AbstractServer{

    private GameManager gameManager;
    
    @Override
    public AbstractMessage evaluate(Object msg) {
        Response response = new Response();
        if(msg.getClass().equals(msg)){
            if(gameManager.getPlayer1() != null){
                gameManager.setPlayer1((Player)msg);
                response.setMessage("Joined game.");
            }else{
                gameManager.setPlayer2((Player)msg);
                response.setMessage("Joined game versus " + gameManager.getPlayer1().getUsername());
            }
        }else{
            response.setMessage(execute((Request)msg));
        }
        return response;
    }

    @Override
    public boolean finish(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String execute(Request msg){
        String response;
        return response;
    }
    
}
