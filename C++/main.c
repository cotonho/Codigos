#include <stdio.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "");
	
    int inteiro = 10;
    float real = 3.14;
    char caractere = 'A';

    int *ptrInteiro;
    float *ptrReal;
    char *ptrChar;

    ptrInteiro = &inteiro;
    ptrReal = &real;
    ptrChar = &caractere;

    printf("Valores iniciais:\n");
    printf("Inteiro: %d\n", inteiro);
    printf("Real: %f\n", real);
    printf("Caractere: %c\n", caractere);

    // Modificando os valores usando ponteiros
    *ptrInteiro = 20;
    *ptrReal = 4.56;
    *ptrChar = 'B';

    printf("\nValores após a modificação:\n");
    printf("Inteiro: %d\n", inteiro);
    printf("Real: %f\n", real);
    printf("Caractere: %c\n", caractere);

    return 0;
}
