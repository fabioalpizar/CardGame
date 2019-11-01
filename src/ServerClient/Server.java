/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;

import Commands.ICommand;
import Commands.Invoker;
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
    private Invoker invoker;
    
    public Server() {
        this.gameManager = new GameManager();
        this.controller = new CommandController(gameManager);
        this.invoker = new Invoker();
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
        ICommand command = controller.registerCommandString(msg.getCommand());
        invoker.setRequest(msg);
        invoker.setCommand(command);
        invoker.comunicateConsole();
        
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