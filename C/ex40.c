#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, "portuguese");
    int i, n1, n2, j, f;

    printf("Digite o valor de inicio: ");
    scanf("%d", &n1);

    printf("Digite o valor de termino: ");
    scanf("%d", &n2);

    for (i = n1; i <= n2; i++)
    {
        if (i <= 1)
        {
            continue;
        }
        
        f = 0;
        for (j = 2; j * j <= i; j++)
        {
            
            if (i % j == 0)
            {
                f++;
            }
            break;
        }

        if (f == 0)
        {
            printf("%d ", i);
        }
    }
    


    return 0;
}