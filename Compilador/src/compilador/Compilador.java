/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import compilador.lex.AnalisadorLexico;
import compilador.sint.Sintatico;
import compilador.token.Token;
import util.LerArquivo;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author JonathasAlberto
 */
public class Compilador {

    public static TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();
    
    public static void main(String[] args) throws IOException {
        
        //para abrir o arquivo a ser lido
        String path = "src/codigos/shellSort.hc";
        LerArquivo la = new LerArquivo(path);
        BufferedReader BF = la.ler();
        
        //instanciando o analisador lexico
        AnalisadorLexico  an= new AnalisadorLexico(BF);
        
        
       /* Sintatico s = new Sintatico(an);
        
        s.inicio(); */
        
        //chamada a nexToken até não haver mais tokens
       Token tk = an.nexToken();
        while(tk !=null){
           
            System.out.println(tk.toString());
            tk = an.nexToken();
        } 
    }     
}
 
