#include <stdio.h>

int main() {
    int vetor[5] = {10, 20, 30, 40, 50};
    int *ponteiro;

    // Inicializa o ponteiro com o endere�o do primeiro elemento do vetor
    ponteiro = vetor;

    // Percorre o vetor e imprime os seus elementos usando o ponteiro
    printf("Elementos do vetor:\n");
    for (int i = 0; i < 5; i++) {
        printf("%d ", *ponteiro);  // Imprime o valor apontado pelo ponteiro
        ponteiro++;  // Avan�a para o pr�ximo elemento do vetor
    }

    printf("\n");

    return 0;
}

