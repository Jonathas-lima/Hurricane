/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.lex.token.Token;
import compilador.lex.token.TokenList;
import file.LerArquivo;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author JonathasAlberto
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        String path = "src/texto.txt";
        
        LerArquivo la = new LerArquivo(path);
        
        BufferedReader BF = la.ler();
        
        String linha;
        int numLinha=1;
        StringBuilder str = null;
 
        TokenList tklist = new TokenList();
        Token tk = null;
        
        while((linha = BF.readLine())!=null){
                
            str = new StringBuilder();
            
            for(int i = 0; i<linha.length();i++){
                                           
                char caracter = linha.charAt(i);
                
                //35 = #(tabela ascii)
                if(caracter == 35){
                    break;
                }
                
                tk = tklist.matchToken(Character.toString(caracter));
                if(tk ==null){                
                    str.append(caracter);
                }else{
                    System.out.println(tk.toString());
                }
            }
            //System.out.println("str "+numLinha +": "+str.toString());
            numLinha++;
        }             
    }     
}
 
