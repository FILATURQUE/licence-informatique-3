#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>


#define BUF_SIZE 64

const char FILE_MSG[] = "Début du fichier\n";

int open_file(const char *filename);
void write_buffer(int fd, const char *buf, ssize_t n);
void copy_stdin_to_fd(int fd) {
    char buf[BUF_SIZE];
    ssize_t n;

    while ((n = read(STDIN_FILENO, buf, sizeof(buf))) > 0) {
        write_buffer(fd, buf, n);
    }

    if (n < 0) {
        perror("read");
        exit(1);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        const char USAGE[] = "Usage: ./copy_stdin fichier\n";
        write_buffer(STDERR_FILENO, USAGE, sizeof(USAGE)-1);
        return 1;
    }

    int fd = open_file(argv[1]);

    write_buffer(fd, FILE_MSG, sizeof(FILE_MSG)-1);

    /* Copier l'entrée standard dans le fichier */
    copy_stdin_to_fd(fd);

    close(fd);

    return 0;
}