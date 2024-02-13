#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, "portuguese");
    int i, valor, soma;
    float resultado;
    
    i = 0;
    valor = 0;
    soma = 0;

    do {
        printf("Digite um valor: ");
        scanf("%d", &valor);

        if (valor >= 0)
        {
            soma += valor;
            i += 1;
        }
    } while (valor >= 0);
    
    
    if (i > 0)
    {
        resultado = soma / i;
        printf("A média desses %d números é: %.2f", i, resultado);
    }
    else{
        printf("Nenhum valor valido foi inserido: ");
    }
    


    return 0;
}