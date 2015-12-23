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
        REST("\\%"),
        CONCATENATE("~"),
	
	// Comparision operators
	
	EQUAL("=="),
	NOT_EQUAL("!="),
	LESS_THAN("<"),
	MORE_THAN(">"),
	LESS_OR_EQUAL("<="),
	MORE_OR_EQUAL(">="),
	
	// types
	INTG("intg"),
	BOOLEAN("bl"),
        REAL("rl"),
        CARACTER("crt"),
        STRING("txt"),
        VECTOR("vector"),
	
	// Constants
	
	INT_CONSTANT("^(\\+|-)?\\d+$"),
        FLOAT_CONSTANT( "^(\\+|-)([0-9]*|\\d*\\.\\d{1}?\\d*)$" ),
	TRUE("true"),
	FALSE("false"),
	
	// keywords
	MAIN( "main" ),
        OUT( "out" ),
        IN( "in" ),
        IF( "if" ),
        ELSE( "else" ),
        WHILE( "while" ),
        CONST( "const" ),
        RETURN( "return" ),
        FUNCTION( "function" ),
        VOID( "void" ),
        FOR( "for" ),
	// Special symbols
	
	OPEN_CURLY("\\{"),
	CLOSE_CURLY("\\}"),
	OPEN_PAREN("\\("),
	CLOSE_PAREN("\\)"),
	ASSIGNMENT("="),
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
