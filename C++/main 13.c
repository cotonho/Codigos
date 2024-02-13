#include <stdio.h>

int main() {
    int matriz[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int *ponteiro;

    // Inicializa o ponteiro com o endere�o do primeiro elemento da matriz
    ponteiro = &matriz[0][0];

    // Percorre a matriz e imprime os seus elementos usando o ponteiro
    printf("Elementos da matriz:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d ", *(ponteiro + i * 3 + j));  // Imprime o valor apontado pelo ponteiro
        }
        printf("\n");
    }

    return 0;
}


