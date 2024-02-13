#include <stdio.h>

void encontrarMinEMax(int arr[], int tamanho, int *min, int *max) {
    // Verifica se o array n�o est� vazio
    if (tamanho <= 0) {
        printf("O array esta vazio.\n");
        return;
    }

    // Inicializa min e max com o primeiro elemento do array
    *min = arr[0];
    *max = arr[0];

    // Itera sobre o array para encontrar o valor m�nimo e m�ximo
    for (int i = 1; i < tamanho; i++) {
        if (arr[i] < *min) {
            *min = arr[i];
        }
        if (arr[i] > *max) {
            *max = arr[i];
        }
    }
}

int main() {
    int arr[] = {10, 5, 7, 15, 3, 8, 20};
    int tamanho = sizeof(arr) / sizeof(arr[0]);
    int minimo, maximo;

    // Chama a fun��o para calcular o valor m�nimo e m�ximo
    encontrarMinEMax(arr, tamanho, &minimo, &maximo);

    // Exibe os resultados
    printf("Valor minimo: %d\n", minimo);
    printf("Valor maximo: %d\n", maximo);

    return 0;
}

