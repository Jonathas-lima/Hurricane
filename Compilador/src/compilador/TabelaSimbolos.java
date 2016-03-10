package compilador;

import compilador.token.Token;
import java.util.HashMap;

/**
 *
 * @author jonathas
 *
 * Guardara todos os identificadores que encontrar, de forma unica
 */
public class TabelaSimbolos {
    
    
    private HashMap<String, Token> tabelaSimbolos;
    
    public TabelaSimbolos(){
        
        tabelaSimbolos = new HashMap<>();
    }
    
    public boolean addIdentificagor(String chave, Token valor){
        
        //se ja existir ele nao adiciona e retorna false
        if(tabelaSimbolos.containsKey(chave)){
            return false;
        }else{
            tabelaSimbolos.put(chave, valor);
            return true; 
        }
    }

    public Token getByIdentificador(String chave){
        
        return tabelaSimbolos.get(chave);
    }
}
