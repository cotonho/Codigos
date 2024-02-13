#include <stdio.h>

int encontrarMaiorElemento(int arr[], int tamanho) {
    int maior = arr[0];

    for (int i = 1; i < tamanho; i++) {
        if (arr[i] > maior) {
            maior = arr[i];
        }
    }

    return maior;
}

int main() {
    int N, k;

    // Ler o tamanho do array (N)
    printf("Digite o tamanho do array (N): ");
    scanf("%d", &N);

    // Alocar espaço para o array
    int *arr = (int *)malloc(N * sizeof(int));
    if (arr == NULL) {
        printf("Erro ao alocar memoria.\n");
        return 1;
    }

    // Ler os valores do array
    printf("Digite os valores do array:\n");
    for (int i = 0; i < N; i++) {
        printf("Elemento %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    // Ler o número de elementos por linha (k)
    printf("Digite o numero de elementos por linha (k): ");
    scanf("%d", &k);

    // Imprimir o array com k elementos por linha
    printf("Array com %d elementos por linha:\n", k);
    for (int i = 0; i < N; i++) {
        printf("%d ", arr[i]);
        if ((i + 1) % k == 0 || i == N - 1) {
            printf("\n");
        }
    }

    // Encontrar o maior elemento no array
    int maior = encontrarMaiorElemento(arr, N);
    printf("Maior elemento: %d\n", maior);

    // Liberar a memória alocada para o array
    free(arr);

    return 0;
}
