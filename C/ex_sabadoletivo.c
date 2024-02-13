#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");

    /*Variáveis*/
    int a, b;

    /*inputs*/
    printf("Digite o valor de A: ");
    scanf("%d", &a);

    printf("Digite o valor de B: ");
    scanf("%d", &b);

    /*Processos*/
    if (a % b == 0){
        printf("A é multiplo de B.");
    }

    else if (b % a == 0){
        printf("A é divisor de B.");
    }
    
    else
        printf("A não é nada de B.");

    return 0;
}