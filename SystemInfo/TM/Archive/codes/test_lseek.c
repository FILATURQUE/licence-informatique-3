# include <unistd.h>
# include <stdlib.h>
# include <stdio.h>
# include <fcntl.h>

void test_lseek(const char *filename){
    int fd = open(filename,O_RDONLY);
    if (fd < 0) {
        perror("open");
        exit(1);
    }
    ssize_t  buff[64];
    write(STDOUT_FILENO,buff,read(fd,buff,10));
    lseek(fd, 0, SEEK_SET);
    write(STDOUT_FILENO,buff,read(fd,buff,10));
    close(fd);
}

int main(int argc, char *argv[]){
    if (argc != 2){
        const char USAGE[] = "Usage: ./test_lseek fichier\n";
        write(STDERR_FILENO, USAGE, sizeof(USAGE)-1);
        return 1;
    }

    test_lseek(argv[1]);

    return 0;
}