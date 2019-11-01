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
public class Client2Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        WeapJsonLoader weaponLoader = new WeapJsonLoader();
        List<IWeapon> weaponList = weaponLoader.load("src\\Resources\\weapons.json");
        
        CharacterJsonLoader charLoader = new CharacterJsonLoader(weaponList);
        List<ICharacter> charactersList = charLoader.load("src\\Resources\\characters.json");
        
        List<ICharacter> charactersListPlayer2 = new ArrayList<>();
        charactersListPlayer2.add(charactersList.get(5));
        charactersListPlayer2.add(charactersList.get(6));
        charactersListPlayer2.add(charactersList.get(7));
        charactersListPlayer2.add(charactersList.get(8));
        
        Player player2 = new Player(2, "Kristal", charactersListPlayer2);

        Client client = new Client(player2);
        
    }
}
