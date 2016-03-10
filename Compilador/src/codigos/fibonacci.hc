main ( ) {

    int limite
    int alfa
    int beta
    int ceta
    int inte

    alfa = 0
    beta = 1
    inte = 0 #variável controladora da estrutura de repetição

    out ( "Insira_o_limite_para_a_série" )
    in ( limite )

    while ( inte < limite ) {
        ceta = alfa + beta
        alfa = beta
        beta = ceta
        out ( c )
        inte = inte + 1
    }
}