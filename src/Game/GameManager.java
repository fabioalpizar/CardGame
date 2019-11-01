package Game;




import java.util.ArrayList;
import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import ObserverPattern.AbstractObservable;
import ObserverPattern.IObserver;

/**
 *
 * @author raque
 */
public class GameManager extends AbstractObservable{
    
    private static Player turn;
    
    private Player player1;
    private Player player2;
    
    private ArrayList<ICharacter> charactersPlayer1 = new ArrayList<>(); 
    private ArrayList<ICharacter> charactersPlayer2 = new ArrayList<>(); 
    private ArrayList<ArrayList<IWeapon>> weaponsPlayer1 = new ArrayList<>(); 
    private ArrayList<ArrayList<IWeapon>> weaponsPlayer2 = new ArrayList<>();

    public GameManager(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        loadWeaponsGamer1();
        loadWeaponsGamer2();
    }
    
    
    public static Player getTurn() {
        return turn;
    }

    public static void setTurn(Player turn) {
        GameManager.turn = turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
        addObserver(player1);
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public ArrayList<ICharacter> getCharactersPlayer1() {
        return charactersPlayer1;
    }

    public void setCharactersPlayer1(ArrayList<ICharacter> charactersPlayer1) {
        this.charactersPlayer1 = charactersPlayer1;
    }

    public ArrayList<ICharacter> getCharactersPlayer2() {
        return charactersPlayer2;
    }

    public void setCharactersPlayer2(ArrayList<ICharacter> charactersPlayer2) {
        this.charactersPlayer2 = charactersPlayer2;
    }

    public ArrayList<ArrayList<IWeapon>> getWeaponsPlayer1() {
        return weaponsPlayer1;
    }

    public void setWeaponsPlayer1(ArrayList<ArrayList<IWeapon>> weaponsPlayer1) {
        this.weaponsPlayer1 = weaponsPlayer1;
    }

    public ArrayList<ArrayList<IWeapon>> getWeaponsPlayer2() {
        return weaponsPlayer2;
    }

    public void setWeaponsPlayer2(ArrayList<ArrayList<IWeapon>> weaponsPlayer2) {
        this.weaponsPlayer2 = weaponsPlayer2;
    }
    
    
    public void loadWeaponsGamer1(){
        ArrayList<IWeapon> weapons = new ArrayList();
        for (int i = 0; i < this.charactersPlayer1.size(); i++) {
            for (int j = 0; j < this.charactersPlayer1.get(i).getWeapons().size(); j++) {
                weapons.add(this.charactersPlayer1.get(i).getWeapons().get(j));  
            }
            this.weaponsPlayer1.set(i,weapons);
            weapons.clear();
        }
      
    }
    
    public void loadWeaponsGamer2(){
        ArrayList<IWeapon> weapons = new ArrayList();
        for (int i = 0; i < this.charactersPlayer2.size(); i++) {
            for (int j = 0; j < this.charactersPlayer2.get(i).getWeapons().size(); j++) {
                weapons.add(this.charactersPlayer2.get(i).getWeapons().get(j));  
            }
            this.weaponsPlayer2.set(i,weapons);
            weapons.clear();
        }
    }
    
    
    
    //metodo para buscar el personaje en la lista
    public ICharacter searchCharacter(String nameCharacter){
        ArrayList<ICharacter> characters = searchCharactersList(turn.getID());
        if(characters!=null){
            for(ICharacter character: characters){
                if(character.getName().equals(nameCharacter)){
                    return character;
                }
            }
        }
        
        return null;  
    }
    
    //metodo para buscar la lista de los guerreros de cada jugador
    public ArrayList searchCharactersList(int idPlayer){
        if(idPlayer == player1.getID()){
            return this.charactersPlayer1;
        }else{
            return this.charactersPlayer2;
        }

    }
   
    //metodo para buscar el arma de cada persona
    public IWeapon searchWeapon(String ch1, String weaponName){
        ArrayList<ICharacter> characters = searchCharactersList(turn.getID());
         if(characters!=null){
            for(ICharacter character: characters){
                if(character.getName().equals(ch1)){
                    for(IWeapon weapon: character.getWeapons()){
                        if(weapon.getName().equals(weaponName)){
                            return weapon;
                        }
                    }

                }
            }
         
         }
        return null;
    }
        //valida que todas las armas hayan sido usadas para poder recargar
    //si una no está en la lista de armas del jugador entonces no se recarga
    public boolean weaponsUsed(ArrayList<IWeapon> weapons, ArrayList<ICharacter> characters){
        for (ICharacter C : characters) {
            if(C.getWeapons().size() > 0){
                return false;
            }
        }
        return true;  
    }
    
    public boolean attack(String characterName, String weaponName){
        IWeapon weapon = searchWeapon(characterName, weaponName);
        int totalDamage = 0;
        ArrayList<ICharacter> currentCharacters = new ArrayList<>();
        if(this.turn.getID() == player1.getID()){
            this.turn = this.player2;
            currentCharacters = charactersPlayer1;
        }else{
           currentCharacters = charactersPlayer2; 
        }
        for (ICharacter C : currentCharacters) {
            totalDamage = totalDamage + getDamageType(weapon, C.getType());
        }
        if(totalDamage > 100){
            for (ICharacter C : currentCharacters) {
                double newHP = C.getHp() - getDamageType(weapon, C.getType());
                C.setHp(newHP);
            }
            return true;   
        }
        return false;
    }
    
    public void giveUp(){
        if(turn.equals(player1.getID())){
            System.out.println("msj  ganó el jugador 2");
            //
        }else{
            System.out.println("msj ganó el jugador 1");
        }
    }
    
    public void mutualExit(){
        if(turn.getID()==player1.getID()){
            //aqui jugador 1 le manda un msj de confirmacion a jugador 2
        }else{
            //aqui jugador 2 le manda un msj de confirmacion a jugador 1
        }
        
    }

    //metodo para validar que los personajes hayan usado todas sus armas
    public boolean validateWeapons(ArrayList<ICharacter> characters){
        for(ICharacter character: characters){
            if(character.getWeapons().size()>0){
                return false;
            }
        }
        return true;
    }
    //metodo para reinsertar las armas en cada personaje, esto para recargar
    public void reinsertWeapons(ArrayList<ICharacter> characters, ArrayList<ArrayList<IWeapon>> weapons){
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).setWeapons(weapons.get(i));   
        }
    }
    public void rechargeWeapons(){
        if(turn.getID()==player1.getID()){
            if(validateWeapons(this.charactersPlayer1)){
                //metodo de reinserción a la lista de armas de cada personaje
                reinsertWeapons(this.charactersPlayer1, this.weaponsPlayer1);
            }else{
                System.out.println("no puede recargar");
            }
        }else{
            if(validateWeapons(this.charactersPlayer2)){
                //metodo de reinserción a la lista de armas de cada personaje
                reinsertWeapons(this.charactersPlayer2, this.weaponsPlayer2);
            }else{
                System.out.println("no puede recargar");
            }
        }
    }
    public void useWildCard(String character1, String weapon1, String character2, String weapon2){
        attack(character1, weapon1);
        attack(character2, weapon2);
    }
    
   
     
    public void skipTurn(){
        if(turn.getID()==player1.getID()){
            this.turn = player2;
        }else{
            this.turn = player1;
        }
        
    }
    
    public void chat(String msj){
        if(turn.getID()==player1.getID()){
            //jugador 1 le manda mensaje a jugador 2
        }else{
            //jugador 2 le manda mensaje a jugador 1
        }
    }
    
    public int getDamageType(IWeapon weapon, String type){
        int damage;
        switch(type){
            case "air":
                damage = weapon.getMultipliers().get(0);
                break;
            case "fire":
                damage = weapon.getMultipliers().get(1);
                break;
            case "water":
                damage = weapon.getMultipliers().get(2);
                break;
            case "light":
                damage = weapon.getMultipliers().get(3);
                break;
            case "dark":
                damage = weapon.getMultipliers().get(4);
                break;
            case "electric":
                damage = weapon.getMultipliers().get(5);
                break;
            case "ice":
                damage = weapon.getMultipliers().get(6);
                break;
            case "acid":
                damage = weapon.getMultipliers().get(7);
                break;            
            case "spirit":
                damage = weapon.getMultipliers().get(8);
                break;                          
            default:
                damage = weapon.getMultipliers().get(9);
                break;
        }
        return damage;
    }
  
}
