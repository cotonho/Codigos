#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");

    /*variaveis*/
    int a, b, c;

    /*inputs*/
    printf("Digite o valor de A: ");
    scanf("%d", &a);

    printf("Digite o valor de B: ");
    scanf("%d", &b);

    printf("Digite o valor de C: ");
    scanf("%d", &c);

    /*processos*/
    if (a < b && b < c){
        printf("%d, %d, %d", a, b, c);
    }

    else if (a < c && c < b){
        printf("%d, %d, %d", a, c, b);
    }

    else if (b < a && a < c){
        printf("%d, %d, %d", b, a, c);
    }

    else if (b < c && c < a){
        printf("%d, %d, %d", b, c, a);
    }

    else if (c < a && a < b){
        printf("%d, %d, %d", c, a, b);
    }

    else
        printf("%d, %d, %d", c, b, a);
    return 0;
}
