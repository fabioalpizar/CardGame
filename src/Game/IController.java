/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author kduran
 */
public interface IController {
    public void attack(Request request);
    
    public void chat(Request request);

    public void giveUp(Request request);
    
    public void mutualExit(Request request);
    
    public void nextRound(Request request);
    
    public void rechargeWeapon(Request request);
    
    public void selectGamer(Request request);
    
    public void selectWeapon(Request request);
    
    public void useWildCard(Request request);
    
    public void exit(Request request);
}
