/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import Game.IController;
import Game.Request;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kduran
 */
public class Log implements IController{

    private Archive archive;
    private String path = "src/Log/prueba.txt";
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public Log() {
        this.archive = new Archive(path);
    }

    @Override
    public void sendMessage(String request) {
        Date date = new Date();
        
        String data = "";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request;
        
        archive.writeLog(data);
    }

    @Override
    public void refreshGUI(String request) {
        Date date = new Date();
        
        String data = "";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request;
        
        archive.writeLog(data);    
    }

    @Override
    public void exit(String request) {
        Date date = new Date();
        
        String data = "Commant: exit";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request;
        
        archive.writeLog(data);
    }
    
}
