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
    public void attack(Request request) {
	Date date = new Date();
        
        String data = "Command: attack";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data);    
    }

    @Override
    public void chat(Request request) {
        Date date = new Date();
        
        String data = "Command: chat";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void giveUp(Request request) {
        Date date = new Date();
        
        String data = "Command: give up";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void mutualExit(Request request) {
        Date date = new Date();
        
        String data = "Command: mutual exit";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void nextRound(Request request) {
        Date date = new Date();
        
        String data = "Command: next round";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void rechargeWeapon(Request request) {
        Date date = new Date();
        
        String data = "Command: recharge weapon";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void selectGamer(Request request) {
        Date date = new Date();
        
        String data = "Command: select gamer";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void selectWeapon(Request request) {
        Date date = new Date();
        
        String data = "Command: select weapon";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void useWildCard(Request request) {
        Date date = new Date();
        
        String data = "Command: use wildCard";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }

    @Override
    public void exit(Request request) {
        Date date = new Date();
        
        String data = "Command: exit";
        data += " Date: " + dateFormat.format(date);
        
        data += " " + request.toString();
        
        archive.writeLog(data); 
    }
    
}
