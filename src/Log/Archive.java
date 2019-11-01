/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kduran
 */
public class Archive {
    private String path;

    public Archive(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public void writeLog(String data) {
        File archivo = new File(path);
        BufferedWriter bw;
        try {
            if(archivo.exists()) {
                String dataa = "";
                BufferedReader br=new BufferedReader(new FileReader(path));
                String linea= br.readLine();
                while(linea!=null){
                    dataa += linea +"\n";
                    linea = br.readLine();
                }
                br.close();
                dataa+=data;
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(dataa);

            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.newLine();
                bw.write(data);
            }
            bw.close();

        } catch (IOException ex) {
            System.out.println("error");
            Logger.getLogger(Archive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
