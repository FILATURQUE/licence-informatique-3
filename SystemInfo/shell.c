#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

#define MAX_LINE 1024
#define MAX_ARGS 64

int main() {
    char line[MAX_LINE];
    char *args[MAX_ARGS];
    ssize_t n;
    
    while (1) {
        write(STDOUT_FILENO, "> ", 2);

        n = read(STDIN_FILENO, line, MAX_LINE - 1);
        if (n <= 0) break;
        line[n] = '\0';

        // Retirer le \n final
        if (line[n-1] == '\n') line[n-1] = '\0';

        // Découpage naïf des arguments (séparateur espace)
        int argc = 0;
        char *token = strtok(line, " ");
        while (token && argc < MAX_ARGS-1) {
            args[argc++] = token;
            token = strtok(NULL, " ");
        }
        args[argc] = NULL;

        if (argc == 0) continue;
        if (strcmp(args[0], "exit") == 0) break;

        pid_t pid = fork();
        if (pid < 0) {
            write(STDERR_FILENO, "Erreur fork\n", 12);
            continue;
        }
        if (pid == 0) {
            execvp(args[0], args);
            write(STDERR_FILENO, "Erreur exec\n", 12);
            _exit(1);
        } else {
            int status;
            wait(&status);
        }
    }
    return 0;
}
