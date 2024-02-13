#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");

    /*Variáveis*/
    float n1, n2, n3, n4, media;

    /*inputs*/
    printf("Digite uma nota");
    scanf("%f", &n1);

    printf("Digite outra nota");
    scanf("%f", &n2);

    printf("Digite outra nota");
    scanf("%f", &n3);

    printf("Digite outra nota");
    scanf("%f", &n4);

    /*processos*/

    media = (n1 + n2 + n3 + n4) / 4;

    if (media < 5){
        printf("reprovado");
    }
    else if (media >= 5 && media < 7){
        printf("de recuperação");
    }
    else
        printf("aprovado");


    return 0;
}
