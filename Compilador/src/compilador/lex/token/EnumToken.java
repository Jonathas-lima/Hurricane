/*
 * Esta enumeracao descreve o os tokens presentes
 * na linguagem. É utilizada expressoes regulares
 * para representacao.
 */
package compilador.lex.token;
/**
 *
 * @author JonathasAlberto
 */
public enum EnumToken {
      	// Operadores Artimeticos
	PLUS("\\+"),
	MINUS("\\-"),
	TIMES("\\*"),
	DIVIDE("/"),
        CONCATENATE("~"),
	// Operadores de comparacao
	EQUAL("=="),
	NOT_EQUAL("!="),
	LESS_THAN("<"),
	MORE_THAN(">"),
	LESS_OR_EQUAL("<="),
	MORE_OR_EQUAL(">="),
	//Operadores logicos
	AND("\^"),
	NOT("\!"),
	OR("\|"),	
	// tipos
	INTG("int"),
	BOOLEAN("bool"),
        REAL("real"),
        CARACTER("char"),
        STRING("text"),
        VECTOR("vector"),
	// Constantes
	INT_CONSTANT("^(\\+|-)?\\d+$"),
        FLOAT_CONSTANT( "(([1-9][0-9]*\\.?[0-9]*)|(\\.[0-9]+))([Ee][+-]?[0-9]+)?" ),
	TRUE("true"),
	FALSE("false"),
	// Palavras reservadas
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
        // Simbolos especiais
	OPEN_CURLY("\\{"),
	CLOSE_CURLY("\\}"),
	OPEN_PAREN("\\("),
	CLOSE_PAREN("\\)"),
	ASSIGNMENT("="),
        LINE_COMMENT("#"),
	// Identificadores
	IDENTIFIER("[a-zA-Z]+"),
	//tokens desconhecidos pela linguagem
	UNKNOW("[^\\Qa-zA-Z0-9+-*/!~<>;.,=?[](){}|&\\E]");
	private String pattern;
	
	private EnumToken(String pattern) {
	
		this.pattern = pattern;
	}
	
	public String getPattern() {
	
		return this.pattern;
	}
}
