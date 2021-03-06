#include <sys/tarfs.h>
#include <sys/kstring.h>
int fd_count = 2;
struct file *filelist;
void print_files();
void add_to_filelist(struct file *f);
char fname[1024];
void change_name(char *fname);

void change_name(char *name)
{
	//kprintf2("%s \n", fname);
	memset((void*)fname, 0, 1024);
	while(*name != '/')
		  name++;
	name++;
	int i = 0;
	while (*name)
	{
		fname[i] = *name;
		name++;
    	i++;
	}
}

uint64_t find_offset_for_file(char *name)
{
	change_name(name);
	//kprintf2("binary name shashi : %s \n", fname);
	struct posix_header_ustar *ustart;
	//uint64_t count = 0;
	ustart = (struct posix_header_ustar *)(&_binary_tarfs_start);
	//count++;
	uint64_t offset = 0;
	
	while(strlen(ustart->name) != 0)
	{
		uint64_t size = octal_to_decimal(atoi(ustart->size));
		//kprintf2("binary name is %s \n",ustart->name);
		//kprintf("binary size is %d \n",size);
		//uint64_t align = 0;
		/*if(size != 0)
			align = (size%512==0) ? size : size + (512 - size%512);
		offset = offset+ 512 + align;
		*/
		
		
		if(kstrcmp(ustart->name, fname) == 0)
		{
			//kprintf2("matched %d \n", offset);
			return offset + 512;
		}
		uint64_t align = 0;
		if(size != 0)
			align = (size%512==0) ? size : size + (512 - size%512);
		offset = offset+ 512 + align;
		ustart = (struct posix_header_ustar *)(&_binary_tarfs_start + offset);
		//count++;
		
	}
	
	return 0;	
}

void print_files()
{
	//clrscr();
	if(filelist == NULL)
	{
		return;
	}
	//kprintf2("ashish\n");
	struct file *t = filelist;
	while(t != NULL)
	{
		kprintf2("name: %s \t", t->name);
		kprintf2("fd: %d \n", t->fd);
		//kprintf("type: %d \t", t->type);
		//kprintf("size: %d \n", t->size);
		t = t->next;	
	}
}


void add_to_filelist(struct file *f)
{
	if(filelist == NULL)
	{
		filelist = f;
		f->next = NULL;
	}
	else
	{
		struct file *t = filelist;
		while(t->next != NULL)
			t = t->next;
		t->next = f;
		f->next = NULL;
	}
}

void initialize_tarfs()
{
	//clrscr();
	kstrcpy(cwd, "rootfs/");
	kprintf("_binary_tarfs_start address is %p and %x \n", &_binary_tarfs_start, &_binary_tarfs_start);
	struct posix_header_ustar *ustart;
	//uint64_t count = 0;
	ustart = (struct posix_header_ustar *)(&_binary_tarfs_start);
	//count++;
	uint64_t offset = 0;
	int index = 0;
	struct file *f = NULL;
	f = kmalloc(sizeof(struct file)); 
	f->fd=fd_count;
	f->type = TYPE_DIRECTORY;
	fd_count++;
	kstrcpy(f->name,"rootfs/");
	add_to_filelist(f);
	int size;
	char *buf = kmalloc(1024);
	while(strlen(ustart->name) != 0)
	{
		kstrcpy(buf,"rootfs/");
		//kprintf2("binary name is %s length - %d\n",ustart->name,strlen(ustart->name));
		f = kmalloc(sizeof(struct file)); 
		//kprintf2("name is  -  %s\n",buf);
		//kprintf2("name is  -  %s\n",buf);
		strcat(buf,ustart->name);
		//kprintf2("name now is  -  %s\n",buf);
		size=strlen(buf);
		
		
		kstrcpy(f->name,buf); 
		//kprintf2("name is  -  %s\n",f->name);
		memset(buf, 0, size);
		f->addr = (uint64_t)&_binary_tarfs_start + offset;
		f->fd = fd_count;
		//kprintf2("fd is  -  %d\n",f->fd);
		fd_count++;
		f->type = atoi(ustart->typeflag);
		f->size = octal_to_decimal(atoi(ustart->size));
		f->offset=0;
		f->next = NULL;
		
		uint64_t size = octal_to_decimal(atoi(ustart->size));
		uint64_t align = 0;
		if(size != 0)
			align = (size%512==0) ? size : size + (512 - size%512);
		offset = offset+ 512 + align;
		ustart = (struct posix_header_ustar *)(&_binary_tarfs_start + offset);
		add_to_filelist(f);
		index++;
		//count++;
		
	}
	//file[index] = kmalloc(sizeof(struct file));
	kfree((uint64_t)buf,strlen(buf));
	print_files();
}

int fopen(char *name)
{
	struct file *t = filelist;
	while(t->next != NULL)
	{
		if(kstrcmp(t->name,name)==0) //&& t->type==TYPE_FILE)
		{
			return t->fd;
		}
		t = t->next;
	}
	return -1;
}

int fread(uint64_t fd,char* buf,uint64_t nbytes)
{
	struct file *t =filelist;
	while(t->next != NULL)
	{	
		if(t->fd == fd)
		{	
		 uint64_t start= (uint64_t)(&_binary_tarfs_start + find_offset_for_file(t->name));
		 int size = t->size;
		   if(size - t->offset < nbytes)
			   nbytes = size - t->offset;

		   //kprintf("name of file read %s",t->name);
		   memcpy((void *)buf, (void *) (start+t->offset), nbytes);
		   t->offset = t->offset+nbytes;
		   return nbytes;	
		}
		t = t->next;
	}
	return -1;
}

uint64_t fwrite(uint64_t fd, char *buf, uint64_t nbytes)
{
	struct file *t = filelist;
	while(t->next != NULL)
	{	
		if(t->fd == fd)
		{	
			//write to this file
			 uint64_t addr = t->addr + t->offset;
			 memcpy((void *)addr, (void *) buf, nbytes);
			 t->offset = t->offset+nbytes;
			 return 0;
		}
		t = t->next;
	}
	return -1;
}

void fclose(uint64_t fd)
{
    struct file *t =filelist;
	while(t->next != NULL)
	{	
		if(t->fd == fd)
		{	
			 t->offset = 0;
			 return;
		}
		t = t->next;
	}
}

struct file *dopen(uint64_t fd, uint64_t buf)
	{
	struct file *t = filelist;
		while(t->next != NULL)
			{
			if(t->fd == fd && t->type == TYPE_DIRECTORY)
					{
					   int len = strlen(t->name); 
						//kprintf2("%s\n",t->name);
					   char* name = t->name;
				    if(t->next != NULL && kstrncmp(t->next->name, name,len)==0){
							//kprintf2("name of next file %s\n",t->name);
						  return t->next;
						}
						else{
							return NULL;
						}
			}
				t=t->next;
			}			
			return NULL;
}



/* int dopen(uint64_t fd, uint64_t buf)
	{
	struct file *t = filelist;
		while(t->next != NULL)
			{
			if(t->fd == fd && t->type == TYPE_DIRECTORY)
					{
					// int len = strlen(t->name); 
					// char* name = t->name;
					
						kprintf("name of next file%s\n",t->name);
						  return t->addr;
					}
				t=t->next;
			}			
			return -1;

}
 */
struct file *dread(struct file* f)
{
	struct file *t = filelist;
	while(t->next != NULL)
	{
		if(t->fd == f->fd)
		{
			char temp_name[1024];
			//int j =0;
			char* iter_name = f->name;
			int length = strlen(iter_name);
			int i = length-2;
			//kprintf2("length of file %s is %d\n",iter_name,length);
			while(iter_name[i] != '/')
    			i--;		//temp_name[j]=iter_name[i];
			length = i+1;
			kstrncpy(temp_name,f->name,length);
			//kprintf2("temp_name after modification %s length %d\n",temp_name,length);
			 //int len = strlen(t->name); 
			 //char* name = t->name;
			while(t->next!=NULL && kstrncmp(t->next->name, temp_name,length)==0)
			{
				//kprintf2("inside while\n");
				//kprintf2("t->next->name%s\n",t->next->name);
				//kprintf2("f->name%s\n",f->name);
			  if(kstrncmp(t->next->name, f->name,strlen(f->name))!=0){
				  			
							//kprintf2("name of next file %s\n",t->next->name);
						  return t->next;
						}
						
				t=t->next;
			}
			return NULL;
				
		}	
		    t=t->next;
	}
			return NULL;
}

void set_cwd(char *dpath)
{
	kstrcpy(cwd, dpath);	
}

char *get_cwd()
{
	return cwd;	
}

uint64_t get_fdcount()
{
	return fd_count;
}
	
void set_fdcount(uint64_t c)
{
	fd_count = c;	
}

/*void dread(uint64_t fd)
	
	{
	struct file *t =filelist;
	while(t->next != NULL)
			{	
				if(t->fd == fd)
					{
					 int len = strlen(t->name); //abc  3
					 char* name = t->name;
					if(t->next == NULL)
						{ return;}
					 t= t->next;
					char* newname = t->name;
					while(kstrncmp(newname, name,len)==0)
					 {
						kprintf("%s\n",newname);
						 if(t->next == NULL)
						{ return;}
						t = t->next;
						newname = t->name;
					 }
					break;
				}
		t = t->next;
	}
	return ;
}
*/

uint64_t fseek(uint64_t fd,uint64_t offset,uint64_t whence)
{
	struct file *t =filelist;
	while(t->next != NULL)
	{	
		if(t->fd == fd)
		{	
			if (whence==0)
				t->offset = offset;
			else if(whence == 1)
				t->offset = t->offset + offset;
			else if(whence == 2)
				t->offset = t->size + offset;
			else
				t->offset = -1;
		   return t->offset;	
		}
		t = t->next;
	}
	return -1;
}
