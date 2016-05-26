
package compilador.token;

/**
 *
 * @author JonathasAlberto
 */
public class TokenList {
    
    
    //mantera uma lista de todos os tokens da linguagem.
    private final Token [] tokenList; 
    
    public TokenList(){
        //recebe todos os valores definidos na enumeracao
        EnumToken [] enumTokenList = EnumToken.values();
        
        //instancia o vetor lista com o tamanho de elementos da enumeracao
        tokenList = new Token[enumTokenList.length];
        
        //itera a lista e cria um token inserindo-o na lista de tokens
        for(int i=0; i<enumTokenList.length ; i++){
            
            tokenList[i] = new Token(enumTokenList[i]);
        }
    }
    
    /*verifica se o lexema (string) corresponde a algum 
     *tipo na enumeracao dos tokens
    */
    public Token matchToken(String str){
        
        Token token = null;

        for (Token tokenList1 : this.tokenList) {
            
            String pattern = tokenList1.getTokenType().getPattern();
                 
            if (str.matches(pattern)) {
                
                token = new Token(tokenList1.getTokenType());
                break;
            }
        }

        return token;
    }
}
