#include <stdio.h>

int main() {
    int numero;

    printf("Digite um numero inteiro: ");
    scanf("%d", &numero);

    printf("O endereco de memoria do numero e: %p\n", (void *)&numero);

    return 0;
}

