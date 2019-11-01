/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Server.AbstractMessage;
import java.io.Serializable;

/**
 *
 * @author Pumkin
 */
public class Response extends AbstractMessage implements Serializable{
    
    private String message;

    public Response() {}
    
    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
