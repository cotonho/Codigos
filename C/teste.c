#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

const int j = 10;

int main()
{
    setlocale(LC_ALL, "");

    
    int i;

    printf("Qual o seu numero favorito? ");
    scanf("%d", &i);

    printf("Seu número favorito é %d", i);
    








    return 0;
}