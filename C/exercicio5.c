#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, "portuguese");

    int n[10], p = 0, i, j, k;

    for (i = 0; i < 10; i++)
    {
        printf("Digite um número: ");
        scanf("%d", &n[i]);
    }

    for (i = 0; i < 10; i++)
    {
        if (n[i] % 2 == 0)
        {
            p++;
        }       
    }

    // separa valores menores e maiores

    j = n[0];
    k = n[0];

    for (i = 0; i < 10; i++)
    {
        // menor valor
        if (n[i] < j)
        {
            j = n[i];
        }

        // maior valor
        if (k < n[i])
        {
            k = n[i];
        }
    }

    printf("menor valor: %d \nmaior valor: %d\n", j, k);

    // 5 primeiros valores ao contrario
    for (i = 4; i >= 0; i--)
    {
        printf("%d, ", n[i]);
    }

    printf("\nA lista possui %d números pares", p);
    

    return 0;
}