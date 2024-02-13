#include <stdio.h>

// Função para calcular a soma do dobro de A e B e atualizar A e B com seus dobros
int somaDobro(int *a, int *b) {
    *a = 2 * (*a);  // Armazena o dobro de A em A
    *b = 2 * (*b);  // Armazena o dobro de B em B

    return (*a + *b);  // Retorna a soma do dobro de A e B
}

int main() {
    int A, B;

    // Lê os valores de A e B
    printf("Digite o valor de A: ");
    scanf("%d", &A);

    printf("Digite o valor de B: ");
    scanf("%d", &B);

    // Chama a função para calcular a soma do dobro e atualizar A e B
    int resultado = somaDobro(&A, &B);

    // Exibe a soma do dobro dos valores e os novos valores de A e B
    printf("Soma do dobro de A e B: %d\n", resultado);
    printf("Novo valor de A: %d\n", A);
    printf("Novo valor de B: %d\n", B);

    return 0;
}

