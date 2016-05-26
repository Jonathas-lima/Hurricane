main ( ) {

    vector int numeros [ 5 ] #vetor contendo os números a serem ordenados
    numeros [ 0 ] = 10
    numeros [ 1 ] = 3
    numeros [ 2 ] = 1
    numeros [ 3 ] = 4
    numeros [ 4 ] = 2

    int tamanho = 5 #tamanho do vetor de números
    int meio  =  tamanho / 2 
    int var_x
    int var_y
    int var_i

    while ( meio > 0 ) { 

        for ( var_i = meio ; var_i < tamanho ; var_i = var_i + var_i ) {

                var_x = numeros [ var_i ]
                var_y = var_i
                while ( var_y >= meio ^ numeros [ var_y - meio ] > var_x ) {
                        numeros [ var_y ] = numeros [ var_y - meio ]
                        var_y = var_y - meio
                }
                numeros [ var_y ] = var_x
        }
        meio = meio / 2
    }
}