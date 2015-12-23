/*
 * Esta enumeracao descreve o os tokens presentes
 * na linguagem. É utilizada expressoes regulares
 * para representacao.
 */
package compilador.lex;

/**
 *
 * @author JonathasAlberto
 */
public enum EnumToken {
    
    	// Arithmetic Operators
	PLUS("\\+"),
	MINUS("\\-"),
	TIMES("\\*"),
	DIVIDE("/"),
	
	// Comparision operators
	
	EQUAL("=="),
	NOT_EQUAL("<>"),
	LESS_THAN("<"),
	MORE_THAN(">"),
	LESS_OR_EQUAL("<="),
	MORE_OR_EQUAL(">="),
	
	// types
	INT("int"),
	BOOLEAN("boolean"),
	
	// Constants
	
	INT_CONSTANT("\\-?[0-9]*"),
	TRUE("true"),
	FALSE("false"),
	
	// keywords
	
	PRINTF("printf"),
	IF("if"),
	ELSE("else"),
	WHILE("while"),
	CONTINUE("continue"),
	BREAK("break"),
	RETURN("return"),
	
	// Special symbols
	
	OPEN_CURLY("\\{"),
	CLOSE_CURLY("\\}"),
	OPEN_PAREN("\\("),
	CLOSE_PAREN("\\)"),
	ASSIGNMENT("="),
	COMA(","),
	SEMICOLON(";"),
	
	// Identifiers
	
	IDENTIFIER("[a-zA-Z][a-zA-Z]*"),
	
	// Unknow token
	UNKNOW("[^\\Qa-zA-Z0-9+-*/!~<>;.,=?[](){}|&\\E]");
	
	private String pattern;
	
	private EnumToken(String pattern) {
	
		this.pattern = pattern;
		
	}
	
	public String getPattern() {
	
		return this.pattern;
		
	}
    
    
    
}
