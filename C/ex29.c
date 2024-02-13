#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");

    /*variaveis*/
    float salario, finan;

    /*inputs*/
    printf("digite o valor do salario: ");
    scanf("%f", &salario);

    printf("digite o valor do financiamento: ");
    scanf("%f", &finan);

    if (salario*5 == finan){
        printf("Financiamento Concedido");
    }

    else
        printf("Financiamento Negado");

    return 0;
}
