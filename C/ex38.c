#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, "portuguese");
    int i;
    float salario, salario2k[2], salario1k, salario_aumentado;
    
    salario2k[0] = 0;
    salario2k[1] = 0;

    for (i = 0; i < 2; i++) {
        printf("Digite o salário: ");
        scanf("%f", &salario);

        if (salario >= 2000) {
            salario2k[0]++;
            salario2k[1] += salario;
        }
        else {
            salario1k += salario;
        }
    }

    salario_aumentado = salario1k + (salario1k * 0.075);

    printf("Número de salários acima de 2000: %d\n", (int)salario2k[0]);
    printf("Valor total de salários: R$%.2f\n", salario2k[1]);
    printf("Valor aumentado dos salários que são menores que 2000: R$%.2f\n", salario_aumentado);

    return 0;
}