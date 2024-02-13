#include <iostream>
#include <unistd.h>
#include <cstring>

int main() {
    int pipe_fd[2];
    
    // Criar o pipe
    if (pipe(pipe_fd) == -1) {
        perror("Erro ao criar o pipe");
        return 1;
    }else{
	std::cout<<"Pipe criado com sucesso."<<std::endl;
    }

    // Criar um processo filho
    pid_t pid = fork();

    if (pid == -1) {
        perror("Erro ao criar o processo filho");
        return 1;
    } else if (pid == 0) {
	std::cout<<"Processo Filho Criado com sucesso."<<std::endl;
        // Este Ã© o cÃ³digo do processo filho

        // Fechar a extremidade de escrita do pipe
        close(pipe_fd[1]);

        // Ler dados do pipe
        char buffer[256];
        ssize_t bytes_lidos = read(pipe_fd[0], buffer, sizeof(buffer));

        if (bytes_lidos == -1) {
            perror("Erro ao ler do pipe");
            return 1;
        }

        // Exibir os dados lidos
        std::cout << "Processo filho leu: " << buffer << std::endl;

        // Fechar a extremidade de leitura do pipe
        close(pipe_fd[0]);
    } else {
        // Este Ã© o cÃ³digo do processo pai

        // Fechar a extremidade de leitura do pipe
        close(pipe_fd[0]);

        // Escrever dados no pipe
        const char *mensagem = "Dados escritos no Pipe";
        ssize_t bytes_escritos = write(pipe_fd[1], mensagem, strlen(mensagem));

        if (bytes_escritos == -1) {
            perror("Erro ao escrever no pipe");
            return 1;
        }

        // Fechar a extremidade de escrita do pipe
        close(pipe_fd[1]);
    }

    return 0;
}
