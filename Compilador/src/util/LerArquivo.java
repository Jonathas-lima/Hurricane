/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jonathas
 */
public class LerArquivo {
    
    private final String path;
    
    public LerArquivo(String path){
        this.path = path;
    }
    
    
    public BufferedReader ler (){
        
        BufferedReader lerFile = null;
        
        try{
            FileReader file = new FileReader(path);
        
            lerFile = new BufferedReader(file);

            
        }catch (IOException e)  {
            System.out.println(e.getMessage());
        }  
        return lerFile;
    }
    
}
