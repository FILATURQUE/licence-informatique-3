#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

#define BUF_SIZE 64

void write_buffer(int fd, const char *buf, ssize_t n) {
    ssize_t written = write(fd,buf,n);
    if (written != n) {
        perror("write");
        exit(1);
    }
}
