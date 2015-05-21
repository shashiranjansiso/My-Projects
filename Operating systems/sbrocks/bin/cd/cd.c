#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char* tokenizeWithKey(char *inputString, char key, char **before);
void trim(char *input);
int isSpace(char c);
int main(int argc, char* argv[], char* envp[]){
	char s = '/';
	const char s1[2] = "/";
	//char* s2 = "/";
	char *arguments[10];
	char *before;
	//printf("In cd.c argc : %d\n",argc);
	if(argc==1 || (strcmp(argv[1],"/")==0))
	{
		chdir("rootfs/");
		//printf(" =='t'rn %d \n",res);
		return 0;
	}
	char *bu1 = malloc(NAME_MAX);
	strcpy(bu1,argv[1]);
	
	int y = strlen(bu1);
	if(y>0 && bu1[y-1]!='/')
		strcat(bu1,s1);
	
	if(chdir(bu1)<0)
	{
		char *buf = malloc(NAME_MAX);
			getcwd(buf, NAME_MAX+1);
			char *buf1 = malloc(NAME_MAX);
			strcpy(buf1,argv[1]);
			//printf("buf in ashish cd is %s\n",buf);
			int k = strlen(buf1);
			
			if(k>0 && buf1[k-1]!='/')
				strcat(buf1,s1);
			strcat(buf,buf1);
			//char *buf2 = malloc(NAME_MAX);
			//strncpy(buf2,buf,(strlen(buf))-1);
			//printf("buf  is %s\n",buf);
			//printf("buf 2 is %s\n",buf2);
			if(chdir(buf)>=0)
				{
					free(buf);
					free(buf1);
					//free(buf2);
					return 0;
				}
			else{
			    free(buf);
				free(buf1);
				//free(buf2);
				//printf("inside the absolute stuff\n");
			}
		}
	    else
			{
			return 0;
		}
	
	//printf("outside the absolute stuff\n");
	char *after;
	int i = 0;
	int j =0;
	//printf("before ist tokenize\n");
	after = tokenizeWithKey(argv[1], s ,&before);
	
	if(after == NULL)
		{
		//printf("inside after \n");
		if (strcmp(argv[1],"..")==0)
		{
			char *buf = malloc(NAME_MAX);
	    	getcwd(buf, NAME_MAX+1);
			//printf("buf in ashish cd is %s\n",buf);
			//char temp_name[1024];
			char* iter_name = buf;
			int length = strlen(iter_name);
			int i = length-2;
			
			while(iter_name[i] != '/'&& i>0)
    			i--;	
			if(i==0)
				{
					printf("This is root directory\n");
					return 0;
			}
			else
				{
					length = i+1;
					char temp_name[1024];
					strncpy(temp_name,buf,length);
					//printf("temp name in cd is %s\n",temp_name);
					chdir(temp_name);
					return 0;
			}
	}
	else if(strcmp(argv[1],".")==0)
		{
		return 0;
	}
		else{
			printf("Not a valid pathname\n");
			return 0;
		}
	}
	

	//int res = chdir(argv[1]);
	//if(res<0)
	//{
	int k = strlen(after);
	if(k>0 && after[k-1]!='/')
		strcat(after,s1);
	//printf("after adding / in end %s \n",after);
	//printf("after ist tokenize %s %s\n",before,after);
	while(before != NULL)
	{
		//printf("before len= %d \n", strlen(before));
		arguments[i] = malloc(20);
		trim(before);
		memcpy((void *)arguments[i], (void *)before, strlen(before)+1);
		trim(arguments[i]);
		memset(before, 0, 20);
		//strcat(arguments[i], '\0');
		//printf("after %d tokenize %s \n",i,arguments[i]);
		i = i+1;
		if(after == NULL)
			break;
		if(strlen(after) == 0)
			break;
		after = tokenizeWithKey(after, s ,&before);	
	}
	for( j = 0; j < i; j++)
	{
		if (strcmp(arguments[j],"..")!=0 && (strcmp(arguments[j],".")!=0) )
			{
		     printf("Invalid path name\n");
		     return 0;
		}
	}
	int m =0;
	while(m<j)
		{
			if (strcmp(arguments[m],"..")==0)
				{
					char *buf = malloc(NAME_MAX);
					getcwd(buf, NAME_MAX+1);
					//printf("buf in ashish cd is %s\n",buf);
					//char temp_name[1024];
					char* iter_name = buf;
					int length = strlen(iter_name);
					int i = length-2;

					while(iter_name[i] != '/'&& i>0)
						i--;	
					if(i==0)
						{
							printf("Can't go beyond root directory\n");
							return 0;
					}
					else
						{	
						//printf("inside else\n");
							length = i+1;
							//printf("length is %d\n",length);
							char temp_name[1024];
							memset(temp_name,0,1024);
							strncpy(temp_name,buf,length);
							//printf("temp name in cd is %s\n",temp_name);
							chdir(temp_name);
							
					}
				free(buf);
				m++;
			}
			else if(strcmp(arguments[m],".")==0)
				{
				m++;
				continue;
			}
			else
				{
				printf("Path does not exist \n");
							return 0;
			}
		
	    }
	
		return 0; 
}

char* tokenizeWithKey(char *inputString, char key, char **before)
{
    char *srcPtr = inputString;
    char *str = NULL;
    int count = 0;
    int found = 0;
    int len = strlen(inputString);
    str = srcPtr;
    while(*srcPtr != key && count < len)
    {
        srcPtr++;
        if(*srcPtr == key)
            found = 1;
        count++;
    }
    trim(str);
    len = strlen(str);
    if(len > 0)
    {
		
        *before=malloc(len);
		memset(*before, 0, len);
		//printf("tokenizeWithKey : %s : len = %d count = %d \n", *before, strlen(*before), count);
        strncpy(*before, str, count);
		
    }
    srcPtr++;
    if(found == 1)
    {
        str = srcPtr;
        trim(str);
        return str;
    }
    return NULL;
}
void trim(char *input)
{
    char *dst = input, *src = input;
    char *end;
    
    
    while (isSpace((unsigned char)*src))
    {
        ++src;
    }
    
    
    end = src + strlen(src) - 1;
    while (end > src && isSpace((unsigned char)*end))
    {
        *end-- = 0;
    }
    
    if (src != dst)
    {
        while ((*dst++ = *src++));
    }
}

int isSpace(char c)
{
    return (c == ' ' || c == '\t' || c == '\n' || c == '\12');
}



