/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex.token;

/**
 *
 * @author JonathasAlberto
 */
public class TokenList {
    
    
    private final Token [] tokenList; //mantera uma lista de todos os tokens.
    
    public TokenList(){
        
        EnumToken [] enumTokenList = EnumToken.values();
        tokenList = new Token[enumTokenList.length];
        
        for(int i=0; i<enumTokenList.length ; i++){
            
            tokenList[i] = new Token(enumTokenList[i]);
        }
    }
    
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
    
    @Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
		
        for (Token tokenList1 : this.tokenList) {
            result.append("\n\n" + tokenList1.toString());
        }
		
		return result.toString();
		
	}
    
    
    
}
