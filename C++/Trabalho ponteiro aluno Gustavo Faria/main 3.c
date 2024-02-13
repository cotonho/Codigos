#include <stdio.h>

// Função para calcular a soma de A e B e armazenar o resultado em A
void calcularSoma(int *a, int b) {
    *a = (*a) + b;  // Calcula a soma e armazena em A
}

int main() {
    int A, B;

    // Lê os valores de A e B
    printf("Digite o valor de A: ");
    scanf("%d", &A);

    printf("Digite o valor de B: ");
    scanf("%d", &B);

    // Exibe os valores de A e B antes da operação
    printf("Valor de A antes da soma: %d\n", A);
    printf("Valor de B: %d\n", B);

    // Chama a função para calcular a soma e atualizar A
    calcularSoma(&A, B);

    // Exibe os valores de A e B após a operação
    printf("Valor de A apos a soma: %d\n", A);
    printf("Valor de B: %d\n", B);

    return 0;
}

