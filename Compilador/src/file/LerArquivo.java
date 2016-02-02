/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import compilador.lex.token.Token;
import compilador.lex.token.TokenList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jonathas
 */
public class LerArquivo {
    
    public BufferedReader ler (String path){
        
        BufferedReader lerFile = null;
        
        try{
            FileReader file = new FileReader(path);
        
            lerFile = new BufferedReader(file);

            
        }catch (IOException e)  {
            System.out.println(e.getMessage());
        }  
        return lerFile;
    }
    
    public void  verificaTonken(BufferedReader lerFile){
        
         TokenList listToken = new TokenList();
        
        try{
            String aux = lerFile.readLine();
        
            while(aux!=null){
            
               String aux2 ="";
        
                for(int i=0 ; i< aux.length(); i++){

                    if(aux.charAt(i)!= 32){

                        //aux2+=String.valueOf(aux.charAt(i));
                        StringBuilder txt = new StringBuilder(aux);

                        System.out.println(aux2);

                    } else{
                     
                        aux2="";
                    }
                }       
                aux = lerFile.readLine();
            }   
        }catch (IOException e){
            System.out.println("ERRO ao ler linha do arquivo");
            
        }
        
    }
    
}
