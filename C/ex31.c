#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
    setlocale(LC_ALL, "portuguese");
    
    /*Variáveis*/
    int n[4];
    int divisao = 0, somaPares = 0, t = 0;

    /*Inputs*/
    printf("Digite um número: ");
    scanf("%d", &n[0]);

    printf("Digite outro número: ");
    scanf("%d", &n[1]);

    printf("Digite outro número: ");
    scanf("%d", &n[2]);

    printf("Digite outro número: ");
    scanf("%d", &n[3]);

    /*Processamento*/

    for(int i = 0; i < 4; i++){
        if (n[i] % 2 == 0) {
            divisao++;
            somaPares += n[i];
        }
    }

    if (divisao > 0){
        t = (somaPares / divisao);
        printf("Exestem %d números pares, e a médias deles é %d.", divisao, t);
    }
    
    else
        printf("Não ha numeros pares.");
    

    return 0;
}