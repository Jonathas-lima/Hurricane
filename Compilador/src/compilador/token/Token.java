package compilador.token;

/**
 * Esta classe representa um Token, contem uma instancia de EnunToken
 * que descreve a natureza do token e o lexema correspondente ao mesmo
 * 
 * @author Jonathas
 */
public class Token{
	
	
	private EnumToken categoriaToken;
        private Lexema lex;
	
	
	/**
	 * Construtor do token
	 * 
	 * @param tokenType
	 */
	public Token(EnumToken tokenType) {
	
		this.categoriaToken = tokenType;
		
	}
        
        public Token(){
        
        }
	
	/**
	 * Retorna o lexema
	 * 
	 * @return uma string do lexema do token, que bate com sua 
         * classe na enumeracao.
	 */
	public String getLexeme() {
	
		return this.lex.getValor();
	}
	
	/**
	 * atribui o lexema do token
	 * 
	 * @param lexema
	 */
	public void setLexeme(Lexema lexema) {
	
		this.lex = lexema;
		
	}
	
	/**
	 * Retorna o tipo do token
	 * 
	 * @return Um TokenType enumeration que corresponde ao token
	 */
	public EnumToken getTokenType() {
	
		return this.categoriaToken;
		
	}

	/**
	 *Retorna o numero da linha que o token aparece no codigo
	 * 
	 * @return int - o numero da linha
	 */
	public int getLineNumber() {
	
		return this.lex.getLinha();
	}

        /**
	 *Retorna o numero da coluna que o token aparece no codigo
	 * 
	 * @return int - o numero da coluna
	 */
	public int getColumnNumber() {
	
		return this.lex.getColuna();
	}
	
	@Override
	public String toString() {
	
		return "Classe do Token: " + this.categoriaToken.toString()+"\n"+
                        "Linha: "+ this.lex.getLinha()+ "\n"+
                        "Coluna: "+ this.lex.getColuna() +"\n"+
                        "#########################";
	}
}
