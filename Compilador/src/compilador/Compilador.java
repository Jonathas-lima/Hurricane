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
                    
            linha = linha + "@";
            System.out.println("linha: "+ linha);
            for(int i = 0; i<linha.length();i++){
                                           
                char caracter = linha.charAt(i);
                //System.out.println(caracter);
                //35 = #(tabela ascii)
                if(caracter == 35){
                    break;
                }
                if (caracter == 32 || caracter == 64){
                
                    tk = tklist.matchToken(str.toString());
                
                    str.delete(0, str.length());
                    
                    if (tk != null){
                        System.out.println(tk.toString());
                    }else{
                        System.out.println("tk null");
                    }
                }else{
                    
                     str.append(caracter);
                }
            }
            numLinha++;
        }    
    }     
}
 
