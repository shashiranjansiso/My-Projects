#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(int argc, char *argv[],char *envp[]){
//printf("ashish\n");
	int f,n;
	char buf[80];
	//printf("inside cat \n");
	//printf("num args are %d \n", argc);
	/*for(int i = 0; i < argc; i++)
		printf("arguments are %s \n", argv[i]);*/
	if(argc!=2)
	{
		printf("Usage : cat <file-name> %d \n ", argc);
		return 0;
	}
	//printf("arg 1 :%s\n",argv[1]);
	f = open(argv[1],O_RDONLY);
	if (f < 0)
	{
		char *buf = malloc(NAME_MAX);
		getcwd(buf, NAME_MAX+1);
		strcat(buf,argv[1]);
		f = open(buf,O_RDONLY);
	}
	if (f > 0)
	{
	while((n=read(f,buf,80))>0)
		write(1,buf,n);
	close(f);
	return 0;
	}
	else
	{
	//printf("fd %d \n",f);	
	printf("Not a valid path\n");	
	return 0;
	}
	return 0;
}
