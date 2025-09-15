#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>

void write_buffer(int fd, const char *buf, ssize_t n);

int open_file(const char *filename) {
    int fd = open(filename, O_WRONLY);
    if (fd < 0) {
        perror("open");
        exit(1);
    }
    return fd;
}

/* int main(int argc, char *argv[]) {
    if (argc != 2) {
        const char USAGE[] = "Usage: ./open_file fichier\n";
        write_buffer(STDERR_FILENO, USAGE, sizeof(USAGE)-1);
        return 1;
    }

    int fd = open_file(argv[1]);

    write_buffer(fd, FILE_MSG, sizeof(FILE_MSG));

    close(fd);

    return 0;
} */