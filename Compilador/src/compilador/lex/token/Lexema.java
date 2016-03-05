/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.lex.token;

/**
 *
 * @author jonathas
 */
public class Lexema {
    
    private String valor;
    private int linha;
    private int coluna;

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
