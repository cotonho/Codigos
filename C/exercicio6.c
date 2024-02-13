#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <time.h>

int main() {
    setlocale(LC_ALL, "portuguese");
    srand(time(0));

    int n[3], i, l[5], j, certo;

    certo = 0;

    for (i = 0; i < 5; i++)
    {
        l[i] = rand() % 10;
    }
    
    for (i = 0; i < 3; i++)
    {
        printf("Digite um valor: ");
        scanf("%d", &n[i]);
    }
    
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j < 5; j++)
        {
            if (n[i] == l[j])
            {
                certo += 1;
            }
        }
    }

    if (certo == 3)
    {
        printf("GANHOU! Você acertou os 3 números.");
    }
    else {
        printf("PERDEU! Mais sorte na proxima.");
    }

    }