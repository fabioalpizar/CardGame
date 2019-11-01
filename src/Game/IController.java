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
    public void sendMessage(String request);
    
    public void refreshGUI(String request);
    
    public void exit(String request);
}
