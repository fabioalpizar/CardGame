/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import CharacterApi.Weapon;
import Loader.*;
import java.util.List;

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
        
    }
    
}
