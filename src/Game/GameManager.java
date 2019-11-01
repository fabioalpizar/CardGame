package Game;




import java.util.ArrayList;
import CharacterApi.ICharacter;
import CharacterApi.IWeapon;
import ObserverPattern.AbstractObservable;
import ObserverPattern.IObserver;
import java.util.Iterator;

/**
 *
 * @author raque
 */
public class GameManager extends AbstractObservable{
    
    private static Player turn;
    
    private static boolean mutualPlayer1 = false;
    private static boolean mutualPlayer2 = false;
    
    private Player player1;
    private Player player2;
    
    private ArrayList<ICharacter> charactersPlayer1 = new ArrayList<>(); 
    private ArrayList<ICharacter> charactersPlayer2 = new ArrayList<>(); 
    public ArrayList<ArrayList<IWeapon>> weaponsGamer1 = new ArrayList<>(); 
    public ArrayList<ArrayList<IWeapon>> weaponsGamer2 = new ArrayList<>(); 
    
    public GameManager() {}

    public void loadWeaponsGamer1(){
        ArrayList<IWeapon> weapons = new ArrayList();
        for (int i = 0; i < this.charactersPlayer1.size(); i++) {
            for (int j = 0; j < this.charactersPlayer1.get(i).getWeapons().size(); j++) {
                weapons.add(this.charactersPlayer1.get(i).getWeapons().get(j));  
            }
            this.weaponsGamer1.add(weapons);
            weapons.clear();
        }
      
    }
    
    public void loadWeaponsGamer2(){
        ArrayList<IWeapon> weapons = new ArrayList();
        for (int i = 0; i < this.charactersPlayer2.size(); i++) {
            for (int j = 0; j < this.charactersPlayer2.get(i).getWeapons().size(); j++) {
                weapons.add(this.charactersPlayer2.get(i).getWeapons().get(j));  
            }
            this.weaponsGamer2.add(weapons);
            weapons.clear();
        }
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
        this.turn = player1;
        this.charactersPlayer1 = (ArrayList<ICharacter>) player1.getCharactersPlayer();
        loadWeaponsGamer1();
        addObserver(player1);
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
        this.charactersPlayer2 = (ArrayList<ICharacter>) player2.getCharactersPlayer();
        loadWeaponsGamer2();
        addObserver(player2);
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

    public static boolean isMutualPlayer1() {
        return mutualPlayer1;
    }

    public static void setMutualPlayer1(boolean mutualPlayer1) {
        GameManager.mutualPlayer1 = mutualPlayer1;
    }

    public static boolean isMutualPlayer2() {
        return mutualPlayer2;
    }

    public static void setMutualPlayer2(boolean mutualPlayer2) {
        GameManager.mutualPlayer2 = mutualPlayer2;
    }

    public ArrayList<ArrayList<IWeapon>> getWeaponsGamer1() {
        return weaponsGamer1;
    }

    public void setWeaponsGamer1(ArrayList<ArrayList<IWeapon>> weaponsGamer1) {
        this.weaponsGamer1 = weaponsGamer1;
    }

    public ArrayList<ArrayList<IWeapon>> getWeaponsGamer2() {
        return weaponsGamer2;
    }

    public void setWeaponsGamer2(ArrayList<ArrayList<IWeapon>> weaponsGamer2) {
        this.weaponsGamer2 = weaponsGamer2;
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
         if(characters != null){
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
    
    public void attack(String characterName, String weaponName){
        IWeapon weapon = searchWeapon(characterName, weaponName);
        int totalDamage = 0;
        if(weapon!=null){
            ArrayList<ICharacter> currentCharacters = new ArrayList<>();
            System.out.println(currentCharacters);
            if(this.turn.getID() == player1.getID()){
                this.turn = this.player2;
                currentCharacters = charactersPlayer2;
            }else{
                currentCharacters = charactersPlayer1; 
            }
            for (ICharacter C : currentCharacters) {
                totalDamage = totalDamage + getDamageType(weapon, C.getType());
            }
            if(totalDamage > 100){
                Iterator<ICharacter> iter = currentCharacters.iterator();
                while (iter.hasNext()) {
                    ICharacter C = iter.next();
                    double newHP = C.getHp() - getDamageType(weapon, C.getType());
                    if(newHP < 0){
                        iter.remove();
                    }else{
                        C.setHp(newHP);   
                    }
                }
                notifyAllObservers("successAttack", "Successful attack from: " + turn.getUsername() + " - Total damage: " + totalDamage);    
            }else{
                notifyAllObservers("failedAttack", "Failed attack from: " + turn.getUsername() + " - Total damage: " + totalDamage);
            }
        }else{
            notifyAllObservers("failedAttack", "Failed attack from: " + turn.getUsername() + " - Total damage: " + totalDamage);
        }
    }
    
    public void giveUp(){
        notifyAllObservers("giveUp", turn.getUsername() + " has given up. What a loser.");
    }
    
    public void mutualExit(){
        if(turn.getID() == player1.getID()){
            //aqui jugador 1 le manda un msj de confirmacion a jugador 2
        }else{
            //aqui jugador 2 le manda un msj de confirmacion a jugador 1
        }
        
    }

        //valida que todas las armas hayan sido usadas para poder recargar
    //si una no está en la lista de armas del jugador entonces no se recarga
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
                reinsertWeapons(this.charactersPlayer1, this.weaponsGamer1);
                notifyAllObservers("Recharged weapons", turn.getUsername() );
            }else{
                notifyAllObservers("Can't recharge weapons", turn.getUsername() );
            }
        }else{
            if(validateWeapons(this.charactersPlayer2)){
                //metodo de reinserción a la lista de armas de cada personaje
                reinsertWeapons(this.charactersPlayer2, this.weaponsGamer2);
                notifyAllObservers("Recharged weapons", turn.getUsername() );
            }else{
                notifyAllObservers("Can't recharge weapons", turn.getUsername() );
            }
        }
    }
    
    public void useWildCard(String character1, String weapon1, String character2, String weapon2){
        notifyAllObservers("wildCard", "Wild Card attack incoming from: " + this.turn.getUsername());
        Player aux = this.turn;
        attack(character1, weapon1);
        this.turn = aux;
        attack(character2, weapon2);
    }
    
    public void selectCharacter(String characterName){
        //este metodo es solo mostrar por pantalla la seleccion
        ICharacter character = searchCharacter(characterName);
        if(character !=  null){
            notifyAllObservers("selectCharacter", character);  
        }else{
            notifyAllObservers("selectNull", "You don't have that character my dude");
        }
    }
    public void skipTurn(){
        notifyAllObservers("skipTurn", this.turn.getUsername() + " skiped his turn.");
        if(turn.getID() == player1.getID()){
            this.turn = player2;
        }else{
            this.turn = player1;
        }
        
    }
    
    public void chat(String msg){
        notifyAllObservers(msg, this.player1.getUsername());
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
