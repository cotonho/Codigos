#include <stdio.h>
#include <math.h>

void calc_esfera(float R, float *area, float *volume) {
    // Constante pi
    const float pi = 3.14159265359;

    // Calcular a �rea da superf�cie da esfera
    *area = 4 * pi * pow(R, 2);

    // Calcular o volume da esfera
    *volume = (4.0 / 3.0) * pi * pow(R, 3);
}

int main() {
    float raio, area, volume;

    // Ler o raio da esfera
    printf("Digite o raio da esfera: ");
    scanf("%f", &raio);

    // Chamar a fun��o para calcular a �rea da superf�cie e o volume
    calc_esfera(raio, &area, &volume);

    // Exibir os resultados
    printf("Area da superficie: %.2f\n", area);
    printf("Volume: %.2f\n", volume);

    return 0;
}

