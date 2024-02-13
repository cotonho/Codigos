#include <stdio.h>

int main() {
    int A;
    int *B, **C, ***D;

    // Inicializa os ponteiros
    B = &A;
    C = &B;
    D = &C;

    // Lê o valor de A
    printf("Digite um valor para A: ");
    scanf("%d", &A);

    // Calcula o dobro, triplo e quádruplo usando os ponteiros
    int dobro = *B * 2;
    int triplo = **C * 3;
    int quadruplo = ***D * 4;

    // Exibe os resultados
    printf("Dobro: %d\n", dobro);
    printf("Triplo: %d\n", triplo);
    printf("Quadruplo: %d\n", quadruplo);

    return 0;
}

