/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Server.AbstractMessage;

/**
 *
 * @author kduran
 */
public class Request extends AbstractMessage{
    private String command;
    private String character;
    private String weapon;
    private String character2;
    private String weapon2;
    private String message;

    public Request(){}
    
    public Request(String command, String character, String weapon, String character2, String weapon2, String message) {
        this.command = command;
        this.character = character;
        this.weapon = weapon;
        this.character2 = character2;
        this.weapon2 = weapon2;
        this.message = message;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getCharacter2() {
        return character2;
    }

    public void setCharacter2(String character2) {
        this.character2 = character2;
    }

    public String getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(String weapon2) {
        this.weapon2 = weapon2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getString(){
        String data = "";
        if(command != null){
            data += command + " ";
        }
        if (character != null){
            data += character + " ";
        }
        if (weapon != null){
            data += weapon + " ";
        }
        if (character2 != null){
            data += character2 + " ";
        }
        if (weapon2 != null){
            data += weapon2 + " ";
        }
        if (message != null){
            data += "\"" + message + "\"";
        }
        return data;
    }
    
    @Override
    public String toString() {
        String data = "";
        if (message != null) {
            data += " Message: " + message;
        }
        if (character != null) {
            data += " Character: " + character;
        }
        if (weapon != null) {
            data += " Weapon: " + weapon;
        }
        if (character2 != null) {
            data += " Character 2: " + character2;
        }
        if (weapon2 != null) {
            data += " Weapon 2: " + weapon2;
        }
        return "Request" + data;
    }
    
    
}
