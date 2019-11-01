/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import CharacterApi.Weapon;
import Game.*;
import Commands.*;
import Game.Request;
import Loader.*;
import ServerClient.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pumkin
 */
public class CardGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        WeapJsonLoader weaponLoader = new WeapJsonLoader();
        List<IWeapon> weaponList = weaponLoader.load("src\\Resources\\weapons.json");
        
        CharacterJsonLoader charLoader = new CharacterJsonLoader(weaponList);
        List<ICharacter> characterList = charLoader.load("src\\Resources\\characters.json");
        Player player1 = new Player(1, "player1");
        CommandController controller;
        
        try {
            Client client = new Client(player1);
            controller = new CommandController(client);
            
            client.setController(controller);
            Invoker invoker = new Invoker();
        
            ArrayList words = controller.defineString("att P1 A1");
            Request request = controller.defineData(words);
            ICommand command = controller.registerCommandString(request.getCommand());
            invoker.setCommand(command);
            invoker.comunicateConsole("att P1 A1");
            
        } catch (IOException ex) {
            Logger.getLogger(CardGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
