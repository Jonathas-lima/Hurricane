/*
 * Esta enumeracao descreve o os tokens presentes
 * na linguagem. É utilizada expressoes regulares
 * para representacao.
 */
package compilador.token;
/**
 *
 * @author JonathasAlberto
 */
public enum EnumToken {
      	// Operadores Artimeticos
	OP_ADICAO("\\+"),
	OP_SUBITRACAO("\\-"),
	OP_MULTIPLICACAO("\\*"),
	OP_DIVISAO("/"),
        OP_CONCATENACAO("~"),
	// Operadores de comparacao
        OP_IGUAL("=="),
	OP_DIFERENTE("!="),
	OP_MENOR_QUE("<"),
	OP_MAIOR_QUE(">"),
	OP_MAIOR_OU_IGUAL("<="),
	OP_MENOR_OU_IGUAL(">="),
	//Operadores logicos
	OP_AND("\\^"),
        OP_NOT("\\!"),
	OP_OR("\\|"),	
	// tipos
	INT("int"),
	BOOLEAN("bool"),
        REAL("real"),
        CARACTER("char"),
        STRING("text"),
        VECTOR("vector"),
	// Constantes
	INT_CONSTANTE("^(\\+|-)?\\d+$"),
        FLOAT_CONSTANTE( "(([1-9][0-9]*\\.?[0-9]*)|(\\.[0-9]+))([Ee][+-]?[0-9]+)?" ),
        STRING_CONSTANTE("^\"([\\s\\S]*)\"$"),
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
	ABRE_CHAVE("\\{"),
	FECHA_CHAVE("\\}"),
        ABRE_COLCHETE("\\["),
	FECHA_COLCHETE("\\]"),
	ABRE_PARENTESE("\\("),
	FECHA_PARENTESE("\\)"),
	ATRIBUICAO("="),
        COMENTARIO_LINHA("#"),
        SEPARADOR_VIRGULA(","),
        SEPARADOR_PONTO_VIRGULA(";"),
	// Identificadores
	IDENTIFICADOR("[a-zA-Z][a-zA-Z][a-zA-Z]\\_*[a-zA-Z]+"),
	//tokens desconhecidos pela linguagem
	DESCONHECIDO("[^\\Qa-zA-Z0-9+-*/!~<>;.=?[](){}|&\\E]");
	
        private final String pattern;
	
	private EnumToken(String pattern) {
	
		this.pattern = pattern;
	}
	
	public String getPattern() {
	
		return this.pattern;
	}
}
