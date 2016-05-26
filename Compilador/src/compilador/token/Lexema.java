
package compilador.token;

/**
 *
 * @author jonathas
 */

//classe representa um lexema encontrado no codigo fonte
public class Lexema {
    
    private String valor;
    private final int linha;
    private final int coluna;

    public Lexema(String valor, int linha, int coluna){

        this.valor = valor;
        this.linha = linha;
        this.coluna = coluna;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    
    @Override
	public String toString() {
	
            return "Lexema: " + valor + " Linha:  "+ linha + " Coluna: "+ coluna+ "\n";	
	}
}
