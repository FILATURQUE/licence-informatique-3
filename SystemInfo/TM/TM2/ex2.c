#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int running = 0;
    int max_parallel = atoi(argv[2]);

    for (int i = 3; i < argc; i++)
    {
        while (running >= max_parallel) // attendre si trop de processus actif
        {
            wait(NULL);
            running--;
        }

        pid_t pid = fork();

        if (pid < 0)
        {
            perror("fork echoue");
            exit(1);
        }

        // Lancement des processus
        if (pid == 0)
        {    
            execlp(argv[1],argv[i]);
            perror("execlp");
            _exit(1);
        }
        running ++;
    }
    for (int i = 3; i < argc; i++)
    {     
        wait(NULL);
        running --;
    }
    
    
    return 0;
}
