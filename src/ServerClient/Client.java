/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerClient;

import Game.CommandController;
import Game.Player;
import Game.Request;
import Game.Response;
import Server.AbstractClient;
import Server.AbstractMessage;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pumkin
 */
public class Client extends AbstractClient{

    private Player player;    
    
    public Client(Player player) throws IOException, ClassNotFoundException {
        this.player = player;
        startClient(this.player);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    
    
    @Override
    public void evaluate(AbstractMessage msg) {
        Response respnse = (Response)msg;
        System.out.println(respnse.getMessage());
    }

    @Override
    public boolean finish(AbstractMessage msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
