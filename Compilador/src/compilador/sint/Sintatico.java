package compilador.sint;

import compilador.lex.AnalisadorLexico;
import compilador.token.Token;

/**
 *
 * @author jonathas
 */
public class Sintatico {
   
    AnalisadorLexico al = null;
    Token tkc = null;
    
    public Sintatico(AnalisadorLexico an){
        
        this.al = an;
        tkc = an.nexToken();
    }    

    public void inicio(){
        
        if(tkc.tokenCateg().equals("MAIN")){
            tkc = al.nexToken();
            
            if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                tkc = al.nexToken();
                
                if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                    tkc = al.nexToken();
                    
                    if(tkc.tokenCateg().equals("ABRE_CHAVE")){
                        tkc = al.nexToken();
                        
                        comandos();
                        
                        if(tkc.tokenCateg().equals("FECHA_CHAVE")){
                            
                            System.out.println("TUDO OK");
                        }else{
                            msgErro("}");
                        }
                    }else{
                        msgErro("{");
                    }
                }else{
                    msgErro(")");
                }
            }else{
                msgErro("(");
            }
        }else{
            msgErro("main");
        }
        
    }
    
    private void comandos(){
        
        if(tkc.tokenCateg().equals("FUNCTION")){
            tkc = al.nexToken();
            if(tkc.tokenCateg().equals("VOID")){
                tkc = al.nexToken();
                functionOuProcedure("procedure");
            }else{
                tkc = al.nexToken();
                functionOuProcedure("function");
            }
        }else{
            declaraVar();
            tkc = al.nexToken();
        }        
    }
    
    private void declaraVar(){
        
        tipo();
        if(tkc.tokenCateg().equals("IDENTIFICADOR")){
            tkc = al.nexToken();
        }else{
            msgErro("variável");
        }
        
    }
    
    private void msgErro(String tk){
        System.out.println("ERRO: "+tk +" esperado "+" linha: "+ 
                    tkc.getLineNumber()+" coluna: "+ tkc.getColumnNumber());
    }

    private void tipo() {
        
        if(tkc.tokenCateg().equals("VECTOR")){
            tkc = al.nexToken();
            tipo_agregado();
        }else{
            tipo_simples();
        }
        
    }

    private void parametros() {
        
    }

    private void expressao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void functionOuProcedure(String tipo){
        
        if(tipo.equals("function")){
            tipo();
        }  
        if(tkc.tokenCateg().equals("IDENTIFICADOR")){
            tkc = al.nexToken();

            if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                tkc = al.nexToken();

                parametros();

                if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                    tkc = al.nexToken();

                    if(tkc.tokenCateg().equals("ABRE_CHAVE")){
                        tkc = al.nexToken();

                        comandos();

                        if(tipo.equals("function")){
                            if(tkc.tokenCateg().equals("RETURN")){
                                tkc = al.nexToken();
                                expressao();
                            }else{
                                msgErro("return");
                            }
                        }
                        
                    if(tkc.tokenCateg().equals("FECHA_CHAVE")){
                        tkc = al.nexToken();
                    }else{
                        msgErro("}");
                    }
                    }else{
                        msgErro("{");
                    }
                }else{
                    msgErro(")");
                }
            }else{
                msgErro("(");
            }
        }else{
            msgErro("variável");
        }
    }

    private void tipo_agregado() {
        tipo_simples();
        if (tkc.tokenCateg().equals("IDENTIFICADOR")){
            tkc = al.nexToken();
            
            if(tkc.tokenCateg().equals("ABRE_COLCHETE")){
                tkc = al.nexToken();
                
                if(tkc.tokenCateg().equals("INT_CONSTANTE")){
                    tkc = al.nexToken();
                }
                
                if(tkc.tokenCateg().equals("FECHA_COLCHETE")){
                    tkc = al.nexToken();
                }
            }
        }
    }

    private void tipo_simples() {
        
        switch (tkc.tokenCateg()) {
            case "int":
                tkc = al.nexToken();
                break;
            case "real":
                tkc = al.nexToken();
                break;
            case "bool":
                tkc = al.nexToken();
                break;
            case "char":
                tkc = al.nexToken();
                break;
            case "text":
                tkc = al.nexToken();
                break;
        }
    }
    
    private void instruções(){
        
        switch (tkc.tokenCateg()) {
            case "IF":
                instCondicionais();
                break;
                
            case "WHILE":
            case "FOR":
                instIterativas();
                break;
                
            case "IN":
            case "OUT":
                instEntradaSaida();
                break;
        }  
    }
    
    private void instEntradaSaida(){
        switch (tkc.tokenCateg()) {
            case "IN":
                tkc = al.nexToken();
                if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                    tkc = al.nexToken();
                    parametros();
                    if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                        
                    }
                }   
                break;
                
            case "OUT":
                tkc = al.nexToken();
                if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                    tkc = al.nexToken();
                    string();
                    if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                        tkc = al.nexToken();
                    }
                } 
                break;
            default:
                msgErro("in ou out");
        }
    }
    
    private void instIterativas(){
        
        switch (tkc.tokenCateg()) {
            case "WHILE":
                tkc = al.nexToken();
                if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                    tkc = al.nexToken();
                    exp_bool();
                    
                    if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                        tkc = al.nexToken();
                        
                        if(tkc.tokenCateg().equals("ABRE_CHAVE")){
                            tkc = al.nexToken();
                            comandos();
                            
                            if(tkc.tokenCateg().equals("FECHA_CHAVE")){
                                tkc = al.nexToken();
                            }else{
                                msgErro("}");
                            }
                        }else{
                            msgErro("{");
                        }
                    }else{
                        msgErro(")");
                    }
                }else{
                    msgErro("(");
                }   break;
            case "FOR":
                tkc = al.nexToken();
                if(tkc.tokenCateg().equals("ABRE_PARENTESE")){
                    tkc = al.nexToken();
                    exp_arit();
                    if(tkc.tokenCateg().equals("SEPARADOR_PONTO_VIRGULA")){
                        tkc = al.nexToken();
                        exp_bool();
                        if(tkc.tokenCateg().equals("SEPARADOR_PONTO_VIRGULA")){
                            tkc = al.nexToken();
                            exp_arit();
                            if(tkc.tokenCateg().equals("FECHA_PARENTESE")){
                                tkc = al.nexToken();
                                if(tkc.tokenCateg().equals("ABRE_COLCHETE")){
                                    tkc = al.nexToken();
                                    comandos();
                                    if(tkc.tokenCateg().equals("FECHA_COLCHETE")){
                                        tkc = al.nexToken();
                                    }else{
                                        msgErro("}");
                                    }
                                }else{
                                    msgErro("{");
                                }
                            }else{
                                msgErro(")");
                            }
                        }else{
                            msgErro(";");
                        }
                    }else{
                        msgErro(";");
                    }
                }else{
                    msgErro("(");
                }   break;
            default:
                msgErro("while ou for");
                break;
        }
    }

    private void instCondicionais(){
        
    }

    private void string(){
        
    }
    
    private void exp_bool(){
      
    }

    private void exp_arit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


