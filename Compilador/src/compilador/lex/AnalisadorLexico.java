package compilador.lex;

import compilador.token.Lexema;
import compilador.token.Token;
import compilador.token.TokenList;
import compilador.Compilador;
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
        //para criar as strings a partir dos caracteres lidos
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
    } 
    
    public Token nexToken() {
        
        Token tk = null;
        Lexema lx = null;
 
        if(listaLexemas.isEmpty()){
            return null;
        }else{
            
            //remore o primeiro elemento da lista de lexemas a cada chamada
            lx = listaLexemas.remove(0);
        
            /*verifica se o lexema corresponde a alguma categoria de token e
             *retorna o token do lexema correspondente.
            */
            try{
                tk = new TokenList().matchToken(lx.getValor());

                //atribui ao token o lexema
                tk.setLexeme(lx);

                //salvar os identificadores na tabela de simbolo
                if(tk.getTokenType().toString().equals("IDENTIFICADOR")){

                    Compilador.tabelaSimbolos.addIdentificagor(tk.getLexeme(), tk);
                }
                return tk;
                
            }catch(NullPointerException e){
                System.out.println("ERRO DE CODIFICAÇÃO Linha: "+lx.getLinha()
                        +" Coluna: "+ lx.getColuna());
                
                System.out.println("INSERIR ESPAÇO EM BRANCO ENTRE: "+lx.getValor());
                
                return null;
            }
        } 
    }
}


