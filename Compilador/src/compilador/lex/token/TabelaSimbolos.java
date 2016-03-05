/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex.token;

import java.util.HashMap;

/**
 *
 * @author jonathas
 */
public class TabelaSimbolos {
    
    
    private HashMap<String, String> tabelaSimbolos;
    
    public TabelaSimbolos(){
        
        tabelaSimbolos = new HashMap<>();
    }
    
    public boolean addIdentificagor(String chave, String valor){
        
        if(tabelaSimbolos.containsKey(chave)){
            
            return false;
        }else{
            tabelaSimbolos.put(chave, valor);
            return true;
        }
        
    }
    
    public String getIdentificador(String chave){
        
        return tabelaSimbolos.get(chave);
    }
}
