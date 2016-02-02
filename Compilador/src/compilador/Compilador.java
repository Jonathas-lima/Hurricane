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

/**
 *
 * @author JonathasAlberto
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String path = "src/texto.txt";
        
        LerArquivo la = new LerArquivo();
        
        BufferedReader BF = la.ler(path);
        
        la.verificaTonken(BF);
        
       
    }
    
}
