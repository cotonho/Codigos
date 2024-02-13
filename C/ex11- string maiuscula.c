#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main()
{
    char texto[51];

    printf("Digite uma frase: ");
    gets(texto);

    for (int i = 0; i < sizeof(texto); i++)
    {
    // diferencia caracteres especiais de letras
       if (tolower(texto[i]) > 'a' || tolower(texto[i]) < 'z')
       {
        texto[i] = toupper(texto[i]);        
       }
    }

    printf("%s", texto);
    


    return 0;
}