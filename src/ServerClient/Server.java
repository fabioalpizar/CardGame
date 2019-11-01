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
    public boolean finish(AbstractMessage  msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String execute(Request msg){
        
        //metodo donde va a entrar el request
        //a la llamada de los metodos le hace falta los parametros
        switch(msg.getCommand()){
             case "chat":
                gameManager.chat(msg.getMessage());
                break;
            case "att":
                gameManager.attack(msg.getCharacter(), msg.getWeapon());
                //attack();
                break;
            case "gu":
                
                //giveUp();
                break;
            case "me":
                //mutualExit();
                break;
            case "nr":
                //skipTurn();
                break;
            case "rw":
                //rechargeWeapons();
                break;
            case "sg":
                //selectCharacter();
                break;
            case "sw":
                //esto es select weapon pero no es funcional con la logica
                break;
            case "uwc":
                //useWildCard();
                break;
        }
       
    
        
        String response;
        return new Response().getMessage();
    }
    
}
