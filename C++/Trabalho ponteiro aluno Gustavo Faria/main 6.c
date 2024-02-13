#include <stdio.h>
#include <math.h>

void calc_esfera(float R, float *area, float *volume) {
    // Constante pi
    const float pi = 3.14159265359;

    // Calcular a área da superfície da esfera
    *area = 4 * pi * pow(R, 2);

    // Calcular o volume da esfera
    *volume = (4.0 / 3.0) * pi * pow(R, 3);
}

int main() {
    float raio, area, volume;

    // Ler o raio da esfera
    printf("Digite o raio da esfera: ");
    scanf("%f", &raio);

    // Chamar a função para calcular a área da superfície e o volume
    calc_esfera(raio, &area, &volume);

    // Exibir os resultados
    printf("Area da superficie: %.2f\n", area);
    printf("Volume: %.2f\n", volume);

    return 0;
}

