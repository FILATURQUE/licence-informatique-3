#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char const *argv[])
{
    for (int i = 2; i < argc; i++)
    {
        pid_t pid = fork();

        if (pid < 0)
        {
            perror("fork echoue");
            exit(1);
        }
        
        if (pid == 0){

            execlp(argv[1],argv[i]);
            perror("execlp");
            _exit(1);

        }
        wait(NULL);
    }
    
    
    return 0;
}
