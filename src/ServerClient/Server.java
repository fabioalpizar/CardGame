/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;

import Game.CommandController;
import Game.GameManager;
import Game.Player;
import Game.Request;
import Game.Response;
import ObserverPattern.IObserver;
import Server.AbstractMessage;
import Server.AbstractServer;
import java.util.ArrayList;

/**
 *
 * @author Pumkin
 */
public class Server extends AbstractServer{

    private GameManager gameManager;
    private final CommandController controller;

    public Server() {
        this.gameManager = new GameManager();
        this.controller = new CommandController();
    }
    
    @Override
    public AbstractMessage evaluate(Object msg) {
        Response response = new Response();
        if((String)msg != ""){
          Request request = (Request)createMessage((String) msg);
          response.setMessage(execute(request));  
        }else{
           response.setMessage((String)msg);  
        }
        return response;
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
                break;
            case "gu":
                gameManager.giveUp();
                //giveUp();
                break;
            case "me":
                gameManager.mutualExit();
                //mutualExit();
                break;
            case "nr":
                gameManager.skipTurn();
                //skipTurn();
                break;
            case "rw":
                gameManager.rechargeWeapons();
                //rechargeWeapons();
                break;
            case "uwc":
                gameManager.useWildCard(msg.getCharacter(), msg.getWeapon(), msg.getCharacter2(), msg.getWeapon2());
                break;
            case "sg":
                gameManager.selectCharacter(msg.getCharacter());
                break;
        }
        return new Response().getMessage();
    }

    @Override
    public boolean finish(String msg) {
        if(msg.equalsIgnoreCase("end")){
            this.gameManager.notifyAllObservers("end", "Ending connection.");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void joined(Object o) {
        if(gameManager.getPlayer1() == null){
            System.out.println("Player1 added");
            gameManager.setPlayer1((Player)o);
            gameManager.getPlayer1().setClient(this.getClientList().get(this.getClientList().size()-1));
            this.gameManager.notifyAllObservers("player1", "You are player 1.");
        }else{
            System.out.println("Player2 added");
            gameManager.setPlayer2((Player)o);
            gameManager.getPlayer2().setClient(this.getClientList().get(this.getClientList().size()-1));
            this.gameManager.notifyAllObservers("start", "Game has started, player 1 starts.");
        }
    }
    
    
    @Override
    public AbstractMessage createMessage(String msg) {
        ArrayList words = controller.defineString(msg);
        Request request = controller.defineData(words);
        System.out.println(request.toString());
        return request;
    }
    
}
