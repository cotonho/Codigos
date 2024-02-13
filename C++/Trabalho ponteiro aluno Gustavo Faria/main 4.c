#include <stdio.h>

// Fun��o para ordenar tr�s valores inteiros e verificar se s�o iguais
int ordenarValores(int *a, int *b, int *c) {
    int temp;

    // Ordena os valores em ordem crescente
    if (*a > *b) {
        temp = *a;
        *a = *b;
        *b = temp;
    }

    if (*a > *c) {
        temp = *a;
        *a = *c;
        *c = temp;
    }

    if (*b > *c) {
        temp = *b;
        *b = *c;
        *c = temp;
    }

    // Verifica se os valores s�o iguais
    if (*a == *b && *b == *c) {
        return 1;  // Todos os valores s�o iguais
    } else {
        return 0;  // Os valores s�o diferentes
    }
}

int main() {
    int A, B, C;

    // L� os valores de A, B e C
    printf("Digite o valor de A: ");
    scanf("%d", &A);

    printf("Digite o valor de B: ");
    scanf("%d", &B);

    printf("Digite o valor de C: ");
    scanf("%d", &C);

    // Chama a fun��o para ordenar os valores e verifica se s�o iguais
    int saoIguais = ordenarValores(&A, &B, &C);

    // Exibe os valores ordenados
    printf("Valores ordenados: %d, %d, %d\n", A, B, C);

    // Exibe se os valores s�o iguais ou diferentes
    if (saoIguais) {
        printf("Os valores sao iguais.\n");
    } else {
        printf("Os valores sao diferentes.\n");
    }

    return 0;
}

