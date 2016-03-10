main ( ) {

    vector int numeros [ 5 ] #vetor contendo os números a serem ordenados
    numeros [ 0 ] = 10
    numeros [ 1 ] = 3
    numeros [ 2 ] = 1
    numeros [ 3 ] = 4
    numeros [ 4 ] = 2

    int tamanho = 5 # tamanho do vetor de números
    int meio  =  tamanho / 2 
    int varx
    int vary
    int vari

    while ( meio > 0 ) { 

        for ( vari = meio ; vari < tamanho ; vari = vari + vari ) {

                varx = numeros [ i ]
                vary = vari
                while ( vary >= meio ^ numeros [ vary - meio ] > varx ) {
                        numeros [ vary ] = numeros [ y - meio ]
                        vary = vary - meio
                }
                numeros [ y ] = varx
        }
        meio = meio / 2
    }
}