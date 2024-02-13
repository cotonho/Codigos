#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// não funciona com letras acentuadas e outros caracteres
// especiais, perdi muito tempo tentando descobrir uma forma 
// de resolver isso mas não descobri

int main()
{
    char frase[101];
    int tamanho_frase, j, resultado = 1, inicio, fim, espacos = 0;

    printf("Digite uma frase: ");
    gets(frase);

    tamanho_frase = strlen(frase);

    //remve espa�os
    for (int i = 0, j = 0; i < tamanho_frase; i++) {
        if (frase[i] != ' ') {
            frase[j] = frase[i];
            j++;
        }
        else{
            espacos++;
        }
    }
    frase[tamanho_frase - espacos] = '\0';

    printf("%s\n", frase);

    for(int i = 0; i < tamanho_frase; i++){
        inicio = i;
        fim = tamanho_frase - 1 - i;

        while(tolower(frase[inicio]) <= 'a' || tolower(frase[inicio]) >= 'z' && inicio < tamanho_frase){
                   inicio++;
        }

        while(tolower(frase[fim]) <= 'a' || tolower(frase[fim]) >= 'z' && fim >= 0){
                    fim--;
        }

        if(inicio < tamanho_frase && fim >= 0){
            if(tolower(frase[inicio]) != tolower(frase[fim])) {
                resultado = 0;
                break;
            }
        }
        else{
        break;} //se chegou aqui a string � um plidromo
    }

        if(resultado){
            printf("Essa frase é um polidromo.");
        }
        else{
            printf("Essa frase não é um polidromo.");
        }

    return 0;
}
