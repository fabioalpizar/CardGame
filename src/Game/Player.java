package Game;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import ObserverPattern.IObserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Server.*;
import Server.AbstractServer.ClientHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raque
 */
public class Player implements IObserver, Serializable{
    private int ID;
    private String username;
    private List<ICharacter> charactersPlayer = new ArrayList<>();
    private ClientHandler client;

    public Player(int ID, String username, List<ICharacter> charactersPlayer) {
        this.ID = ID;
        this.username = username;
        this.charactersPlayer = charactersPlayer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ClientHandler getClient() {
        return client;
    }

    public void setClient(ClientHandler client) {
        this.client = client;
    }

    public List<ICharacter> getCharactersPlayer() {
        return charactersPlayer;
    }

    public void setCharactersPlayer(List<ICharacter> charactersPlayer) {
        this.charactersPlayer = charactersPlayer;
    }

    
    
    @Override
    public void notifyObserver(String command, Object source) {
        Response response = new Response();
        try{
            switch(command){
                case "selectCharacter":
                    ICharacter C = (ICharacter) source;
                    String weapons = "";
                    for(IWeapon i : C.getWeapons()){
                        weapons = weapons + "Weapon: " + i.getName() + "\nType: " + i.getType();
                    }
                    String msg = C.getName() + "\nHP: " + C.getHp() + "\n" + weapons;
                    response.setMessage(msg);
                    break;
                case"successAttack":
                    response.setMessage((String)source);
                    break;
                case"failedAttack":
                    response.setMessage((String)source);
                    break;
                case"giveUp":
                    response.setMessage((String)source);
                    break;
                case"wildCard":
                    response.setMessage((String)source);
                    break;
                case"skipTurn":
                    response.setMessage((String)source);
                    break;
                case"player1":
                    response.setMessage((String)source);
                case"start":
                    response.setMessage((String)source);
                    break; 
                case"end":
                    response.setMessage((String)source);
                    break; 
                default:
                    response.setMessage(command);
                    break;

            }
            this.client.oos.writeObject(response); 
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
}
