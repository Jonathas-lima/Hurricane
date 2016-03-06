/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathas
 */
public class AnalisadorLexico {
    
    private final BufferedReader bf ;
    private Lexema lexema;
    private final List <Lexema> listaLexemas;
    
    public AnalisadorLexico(BufferedReader bf){
        
        this.bf = bf;
        listaLexemas = new ArrayList<>();
        
        try{
            this.processaArquivo();
        }catch( IOException e){
            System.out.println("ERRO ao processar arquivo"+ e.getMessage());
        }
    }
    
    private void processaArquivo() throws IOException{
       
        //para ler linha por linha do arquivo
        String linha; 
        //conta o numero da linha
        int numLinha = 1;
        //conta a coluna lida, para add ao lexema o valor onde ele aparece
        int numColuna =1;
        //
        StringBuilder str = new StringBuilder();
        
        //ler linha por linha
        while((linha = bf.readLine())!=null){
            
            //adiciona o @ no final da linha para servir de terminador
            linha = linha + "@";
            
            //para ler caracter a caracter
            for(int i = 0; i<linha.length();i++){

                //ver caracter a caracter 
                char caracter = linha.charAt(i);
                
                //35 = #(tabela ascii) comentarios da linguagem
                if(caracter == 35){
                    break;
                }
                //32 = espaco em branco || 64 = @ (terminador de linha) 
                if (caracter == 32 || caracter == 64 && !linha.equals("@")){
                    
                    if(str.length()!=0){    //para nao colocar espacos em braco
                        
                        //instancia o lexema encontrado, com valor, linha e coluna
                        lexema = new Lexema(str.toString(), numLinha, numColuna - str.length());
                        //adiciona a lista o lexema para posterior chamada de nexToken()
                        listaLexemas.add(lexema);
                        str.delete(0, str.length());   //limpa a str
                    }
                    
                }else{
                    //para nao adicionar o '@' a str
                    if(caracter != 64){
                        str.append(caracter);
                    }
                }
                numColuna++;
            }
            numLinha++;  
            numColuna=1;
        } 
        bf.close();
        //System.out.println(listaLexemas.toString());
    } 
    
    public Token nexToken() {
        
        Token tk = null;
        Lexema lx = null;
 
        if(listaLexemas.isEmpty()){
            return null;
        }else{
            
            lx = listaLexemas.remove(0);
        
            tk = new TokenList().matchToken(lx.getValor());
            
            tk.setLexeme(lx.getValor());
            tk.setLineColumn(lx.getColuna());
            tk.setLineNumber(lx.getLinha());
            
            if(tk.getTokenType().toString().equals("IDENTIFICADOR")){
                
                
            }
            
            return tk;
        } 
    }
}


