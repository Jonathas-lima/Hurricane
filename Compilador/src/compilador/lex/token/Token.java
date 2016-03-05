package compilador.lex.token;

/**
 * Esta classe representa um Token, contem uma instancia de EnunToken
 * que descreve a natureza do token e o lexema correspondente ao mesmo
 * 
 * @author Jonathas
 */
public class Token{
	
	private String valorToken;
	private EnumToken categoriaToken;
	private int numLinha;
        private int numColuna;
	
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
	 * @return A string that contains a lexeme that matchs to this token
	 *         pattern, or null if it is not defined
	 */
	public String getLexeme() {
	
		return this.valorToken;
		
	}
	
	/**
	 * Set the token's lexeme
	 * 
	 * @param lexeme
	 */
	public void setLexeme(String lexeme) {
	
		this.valorToken = lexeme;
		
	}
	
	/**
	 * Return the type of the token
	 * 
	 * @return A TokenType enumeration that corresponds to this token
	 */
	public EnumToken getTokenType() {
	
		return this.categoriaToken;
		
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj == null){
			
			return false;
			
		}
		
		if(obj instanceof Token == false){
			
			return false;
			
		}
		
		Token token = (Token) obj;
		
		if(this.valorToken.equals(token.getLexeme()) &&
		        this.categoriaToken.equals(token.getTokenType())){
			
			return true;
			
		} else{
			
			return false;
			
		}
	}
	
	/**
	 *Retorna o numero da linha que o token aparece no codigo
	 * 
	 * @return int - o numero da linha
	 */
	public int getLineNumber() {
	
		return this.numLinha;
		
	}
	
	/**
	 * set a linha que o token aparece
	 * 
	 * @param lineNumber
	 * @throws IllegalArgumentException
	 *             se o numero da linha for menor que 1
	 */
	public void setLineNumber(int lineNumber) {
	
		if(lineNumber < 1){
			
			throw new IllegalArgumentException("A linha deve ser maior ou igual a 1");
			
		}
		
		this.numLinha = lineNumber;
		
	}
        
        /**
	 *Retorna o numero da coluna que o token aparece no codigo
	 * 
	 * @return int - o numero da coluna
	 */
	public int getColumnNumber() {
	
		return this.numColuna;
		
	}
	
	/**
	 * set a coluna que o token aparece
	 * 
	 * @param columnNumber
	 * @throws IllegalArgumentException
	 *             se o numero da coluna for menor que 1
	 */
	public void setLineColumn(int columnNumber) {
	
		if(columnNumber < 1){
			
			throw new IllegalArgumentException("A coluna deve ser maior ou igual a 1");
			
		}
		
		this.numColuna = columnNumber;
		
	}
	
	@Override
	public int hashCode() {
	
		return this.valorToken.length() * this.categoriaToken.hashCode() * this.numLinha;
		
	}
	
	@Override
	public String toString() {
	
		return "Token Type: " + this.categoriaToken.toString();
		
	}
}
