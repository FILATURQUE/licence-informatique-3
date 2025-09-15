#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <ctype.h>


void print_uppercase(const char *filename) {
    int fd = open(filename, O_RDONLY); // O_WRONLY → O_RDONLY pour lire le fichier
    if (fd < 0) { perror("open"); exit(1); }

    char buf[64];
    ssize_t n;
    while ((n = read(fd, buf, sizeof(buf))) > 0) {
        for (int i = 0; i < n; i++) {
            buf[i] = toupper((unsigned char)buf[i]); // conversion en majuscule
        }
        if (write(STDOUT_FILENO, buf, n) != n) { // écrire sur la sortie standard
            perror("write");
            exit(1);
        }
    }
    if (n < 0) { perror("read"); exit(1); }
    close(fd);

}
int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr,"Usage: %s <filename>\n" , argv[0]);
        return 1;
    }
    print_uppercase(argv[1]);
    return 0;
}