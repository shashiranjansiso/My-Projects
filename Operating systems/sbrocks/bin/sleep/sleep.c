#include<stdlib.h>
#include<stdio.h>
#include <string.h>
int main(int argc, char* argv[], char* envp[]){
	if(argc<2){
		printf("Usage: sleep <num_seconds>.\n");
		exit(1);
	}
	int sec = atoi(argv[1]);
	sleep(sec);
	return 0;
}

