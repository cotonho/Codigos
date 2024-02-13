#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, "");

    int R[10], S[20], i;
    srand(time(0));

    //Letra A
    for(i=0; i<10; i++){
        R[i] = rand() % 100;
    }

    for(i=0; i<20; i++){
        S[i] = rand() % 100;
    }


    //Letra B
    int X[30];

    for(i=0; i<10; i++){
        X[i] = R[i];
        printf("União: %d\n", X[i]);
    }
    for(i=0; i<20; i++){
        X[(i + 10)] = S[i];
        printf("União: %d\n",X[(i+10)]);
    }

    //Letra C
    int Y[30], posicao;
    posicao = 0;

    for(i=0; i<20; i++){
        for (int j = 0; j < 10; j++) {
            if (S[i] == R[j]) {
            Y[posicao] = S[i];
            printf("Interceção: %d\n", Y[posicao]);
            posicao += 1;
            }
        }
    }

    printf("Fim.");
    return 0;}
