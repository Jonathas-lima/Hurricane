/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.lex.token.AnalisadorLexico;
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
        
        AnalisadorLexico  an= new AnalisadorLexico(BF);
        
        an.processaArquivo();
    }     
}
 
