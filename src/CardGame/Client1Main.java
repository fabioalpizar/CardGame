/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import Game.Player;
import Loader.CharacterJsonLoader;
import Loader.WeapJsonLoader;
import ServerClient.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pumkin
 */
public class Client1Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        WeapJsonLoader weaponLoader = new WeapJsonLoader();
        List<IWeapon> weaponList = weaponLoader.load("src\\Resources\\weapons.json");
        
        CharacterJsonLoader charLoader = new CharacterJsonLoader(weaponList);
        List<ICharacter> charactersList = charLoader.load("src\\Resources\\characters.json");
        
        List<ICharacter> charactersListPlayer1 = new ArrayList<>();
        charactersListPlayer1.add(charactersList.get(0));
        charactersListPlayer1.add(charactersList.get(1));
        charactersListPlayer1.add(charactersList.get(2));
        charactersListPlayer1.add(charactersList.get(4));
        
        Player player1 = new Player(1, "Raquel", charactersListPlayer1);

        Client client = new Client(player1);
        
    }
}
