#include <stdio.h>
#include <stdlib.h>

void lerElementos(int *vetor, int tamanho) {
    printf("Digite os elementos do vetor:\n");
    for (int i = 0; i < tamanho; i++) {
        printf("Elemento %d: ", i + 1);
        scanf("%d", &vetor[i]);
    }
}

int main() {
    int n;

    // Ler a quantidade de elementos
    printf("Digite a quantidade de elementos: ");
    scanf("%d", &n);

    // Aloca dinamicamente o vetor
    int *vetor = (int *)malloc(n * sizeof(int));

    // Verifica se a alocação foi bem-sucedida
    if (vetor == NULL) {
        printf("Erro ao alocar memoria.\n");
        return 1;
    }

    // Chama a função para ler os elementos do vetor
    lerElementos(vetor, n);

    // Exibe os elementos do vetor
    printf("Elementos do vetor:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", vetor[i]);
    }
    printf("\n");

    // Libera a memória alocada para o vetor
    free(vetor);

    return 0;
}
