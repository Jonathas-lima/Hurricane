package compilador.lex.token;

/**
 * Esta classe representa um Token, contem uma instancia de EnunToken
 * que descreve a natureza do token e o lexema correspondente ao mesmo
 * 
 * @author Jonathas
 */
public class Token{
	
	private String lexeme;
	private EnumToken tokenType;
	private int lineNumber;
        private int columnNumber;
	
	/**
	 * Construtor do token
	 * 
	 * @param tokenType
	 */
	public Token(EnumToken tokenType) {
	
		this.tokenType = tokenType;
		
	}
	
	/**
	 * Retorna o lexema
	 * 
	 * @return A string that contains a lexeme that matchs to this token
	 *         pattern, or null if it is not defined
	 */
	public String getLexeme() {
	
		return this.lexeme;
		
	}
	
	/**
	 * Set the token's lexeme
	 * 
	 * @param lexeme
	 */
	public void setLexeme(String lexeme) {
	
		this.lexeme = lexeme;
		
	}
	
	/**
	 * Return the type of the token
	 * 
	 * @return A TokenType enumeration that corresponds to this token
	 */
	public EnumToken getTokenType() {
	
		return this.tokenType;
		
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
		
		if(this.lexeme.equals(token.getLexeme()) &&
		        this.tokenType.equals(token.getTokenType())){
			
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
	
		return this.lineNumber;
		
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
		
		this.lineNumber = lineNumber;
		
	}
        
        /**
	 *Retorna o numero da coluna que o token aparece no codigo
	 * 
	 * @return int - o numero da coluna
	 */
	public int getColumnNumber() {
	
		return this.columnNumber;
		
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
		
		this.columnNumber = columnNumber;
		
	}
	
	@Override
	public int hashCode() {
	
		return this.lexeme.length() * this.tokenType.hashCode() * this.lineNumber;
		
	}
	
	@Override
	public String toString() {
	
		return "Token Type: " + this.tokenType.toString();
		
	}
}
