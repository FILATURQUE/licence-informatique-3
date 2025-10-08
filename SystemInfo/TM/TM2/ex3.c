#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    int index = 0;
    pid_t* tab = malloc((argc - 2) * sizeof(pid_t));
    
    if (tab == NULL) 
    {
        perror("malloc failed");
        exit(1);
    }

    for (int i = 2; i < argc; i++)
    {
        pid_t pid = fork();
        tab[index] = pid;

        if (pid < 0)
        {
            perror("fork echoue");
            exit(1);
        }

        if (pid == 0)
        {
            execlp(argv[1],argv[i]);
            perror("execlp");
            _exit(1);
        } 
        index++;
    }
    for (int i = 0; i < argc-2; i++)
    {
        int status;
        waitpid(tab[i],&status,0);
        if (WIFEXITED(status))
        {
            printf("Fils %d termine avec code %d\n",tab[i],WEXITSTATUS(status));
        }
    }
    free(tab);
    return 0;
}
