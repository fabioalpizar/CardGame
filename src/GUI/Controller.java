/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import Loader.CharacterJsonLoader;
import Loader.WeapJsonLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Controller {
    
    private List<ICharacter> charList;
    private List<ICharacter> playerCharacters;
    private GameFrame gameFrame;
    private String userName;
    private String rivalName;

    public Controller() {
        WeapJsonLoader weaponLoader = new WeapJsonLoader();
        List<IWeapon> weaponList = weaponLoader.load("src\\Resources\\json\\weapons.json");
        CharacterJsonLoader charLoader = new CharacterJsonLoader(weaponList);
        charList = charLoader.load("src\\Resources\\json\\characters.json");
        playerCharacters = new ArrayList();
    }

    void setPlayerCharacters(ArrayList<String> characters) {
        //contiene los characters que eligio el jugador
        for (int i = 0; i < characters.size(); i++) {
            for (int e = 0; e < charList.size(); e++) {
                if (charList.get(e).getType().equals(characters.get(i)) ) {
                    playerCharacters.add( charList.get(e) );
                }
            }
        }
    }
    
    public void setUserName(String userName) {
        // contiene el username
        this.userName = userName;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    void setRivalName(String name) {
        this.rivalName = name;
    }
    
    public String getRivalName() {
        setRivalName("Player 2");
        return this.rivalName;
    }

    public List<ICharacter> getPlayerCharacters() {
        return playerCharacters;
    }
    
    public List<String> getImgList() {
        List<String> imgList = new ArrayList<>();
        for(ICharacter c: playerCharacters) {
            imgList.add(c.getImgPaths().get(0));
        }
        return imgList;
    }
    
    public String weaponsToString(List<Integer> list) {
        String text = "|\t";
        for(Integer i: list) {
            text = text + i + " |\t";
        }
        return text;
    }
    
    public String getImagePath(String name) {
        String path = "";
        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(i).getType().equals(name) ) {
                path = charList.get(i).getImgPaths().get(0);
            }
        }
        return path;
    }

    public ICharacter getCharacter1() {
        return playerCharacters.get(0);
    }

    public ICharacter getCharacter2() {
        return playerCharacters.get(1);
    }

    public ICharacter getCharacter3() {
        return playerCharacters.get(2);
    }

    public ICharacter getCharacter4() {
        return playerCharacters.get(3);
    }

    void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    
    void addConsoleText(String message) {
        gameFrame.addMessage(message);
    }

    public String sendMessage(String text) {
        return text;
    }

}