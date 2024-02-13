#include <stdio.h>

void calcularMinEMax(int arr[], int tamanho, int *min, int *max) {
	int i = 1;
    // Verifica se o array não está vazio
    if (tamanho <= 0) {
        printf("O array esta vazio.\n");
        return;
    }

    // Inicializa min e max com o primeiro elemento do array
    *min = arr[0];
    *max = arr[0];

    // Itera sobre o array para encontrar o valor mínimo e máximo
    while (i < tamanho) {
        if (arr[i] < *min) {
            *min = arr[i];
        }
        if (arr[i] > *max) {
            *max = arr[i];
        }
        i++;
    }
}

int main() {
    int arr[] = {10, 5, 7, 15, 3, 8, 20};
    int tamanho = sizeof(arr) / sizeof(arr[0]);
    int min, max;

    // Chama a função para calcular o valor mínimo e máximo
    calcularMinEMax(arr, tamanho, &min, &max);

    // Exibe os resultados
    printf("Valor minimo: %d\n", min);
    printf("Valor maximo: %d\n", max);

    return 0;
}

