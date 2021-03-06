#include <sys/process/process.h>
#include <sys/mmu/kmalloc.h>
static uint64_t pid = 1;

struct task_struct *task_list = NULL;
struct task_struct *free_task_list = NULL;
struct vm_area_struct *free_vm_list = NULL;
//uint64_t process_count = 0;
void print_task_list();
void change_task_state(struct task_struct *task);

struct vm_area_struct * create_vma(struct mm_struct *vm_mm, uint64_t start, uint64_t end, uint64_t type, uint64_t flags, uint64_t fd)     
{
	struct vm_area_struct *vma = NULL;
	//TODO allocate memory vma
	vma = get_free_vma();
	//vma = (struct vm_area_struct *)kmalloc(sizeof(struct vm_area_struct));
	vma->vm_mm = vm_mm;
	vma->vm_start = start;
	vma->vm_end = end;
	vma->vma_type = type;
	vma->vm_flags = flags;
	vma->vm_file_descp = fd;
	vma->next = NULL;
	return vma;
}

void add_to_task_list(struct task_struct *task)
{
	if(task_list == NULL)
	{
		task_list = task;
		task->next = NULL;
	}
	else{
		struct task_struct *t = task_list;
		while(t->next != NULL)
		{
			t = t->next;	
		}
		t->next = task;
		task->next = NULL;
	}
	//process_count++;
}

void add_to_free_task_list(struct task_struct *task){
	//kprintf2("adding to free task list \n");
	if(free_task_list==NULL) {
		free_task_list = task;
		free_task_list->next = NULL;	
	}
	else
	{	
		//task->next = free_task_list;
		struct task_struct *task_temp = free_task_list;
		while(task_temp->next != NULL)
		{
			task_temp = task_temp->next;	
		}
		task_temp->next = task;
		task_temp->next->next = NULL;
	}	
	
}

struct task_struct* get_free_task(){
	struct task_struct *task;
	if(free_task_list!=NULL){ // If found free in task list 
		//kprintf2("using from free task list \n");
		task = free_task_list;
		free_task_list = free_task_list->next;
		return task;
	}	
	//if no free task
	task = (struct task_struct *)kmalloc(sizeof(struct task_struct));
	task->mm = create_new_mmstruct(); 
	return task; 

}


void add_to_free_vm_list(struct vm_area_struct *vma){
	//kprintf2("adding to free vma list \n");
	if(free_vm_list==NULL) {
		free_vm_list = vma;
		//free_vm_list->next = NULL;	
	}
	else
	{	
		//vma->next = free_vm_list;
		struct vm_area_struct *vm_temp = free_vm_list;
		while(vm_temp->next != NULL)
		{
			vm_temp = vm_temp->next;	
		}
		vm_temp->next = vma;
		//vm_temp->next->next = NULL;
	}	
}

struct vm_area_struct* get_free_vma(){
	struct vm_area_struct *vma;
	if(free_vm_list!=NULL){ // If found free in task list 
		vma = free_vm_list;
		//kprintf2("using from free vma list \n");
		free_vm_list = free_vm_list->next;
		return vma;
	}	
	//if no free task
	vma = (struct vm_area_struct *)kmalloc(sizeof(struct vm_area_struct));
	return vma; 

}

void remove_from_task_list(struct task_struct *task){
	task->state = TASK_STOPPED;
	//process_count--;
	if(task_list == NULL)
		return;
	else
	{
		struct task_struct *p = task_list;
		struct task_struct *c = p->next;
		if(p == task)
		{
			task_list = task_list->next;
			return;
		}
		while(c != NULL)
		{
			if(c == task)
			{
				p->next = c->next; 
				return;
			}
			p = c;
			c= c->next;
		}
	}
}

struct task_struct *get_next_task(struct task_struct *current_task)
{
	//clrscr();
	if(current_task == NULL)
	{
		//if current task is null return the first task
		return task_list;
	}
	else
	{
		struct task_struct *task = current_task->next;
		while(task != NULL)
		{
			if(task != current_task && task->state == TASK_RUNNABLE)
				return task;
			task= task->next;
		}
		task = task_list;
		while(task != NULL)
		{
			if(task != current_task && task->state == TASK_RUNNABLE)
				return task;
			task = task->next;
		}
	}
	return NULL;
}

struct task_struct *get_task_list()
{
	return task_list;	
}

#if 0
struct task_struct *get_next_task(struct task_struct *current_task)
{
	//clrscr();
	//print_task_list();
	if(task_list == NULL)
	{
		return NULL;
	}
	else
	{
		//clrscr();
		//print_task_list();
		struct task_struct *t = task_list;
		while(t != NULL)
		{
			if(t != current_task && t->state == TASK_RUNNABLE)	
				return t;
			t = t->next;
		}
	}
	return NULL;
}


const char *task_state[10]= {"RUNNING","IDLE","STOPPED","RUNNABLE","SLEEP","WAITING"};



void print_task_list()
{
	struct task_struct *t = task_list;
	kprintf2("--------------------------List of Process-------------------------------------\n");
	kprintf2("\n Pid	PPid	Name	State\n");
	kprintf2("-------------------------------------------------------------------------------\n");
	while(t != NULL)
	{
		kprintf2("%d	%d	%s	 %s \n",t->pid,t->ppid,t->name,task_state[t->state]);
/* 		kprintf2("task id %d", t->pid);
		kprintf2("task name %s", t->name);
		kprintf2("task state %d \n", t->state); */
		t = t->next;
	}
}
#endif
struct task_struct *get_task(uint64_t pid)
{
	struct task_struct *t = task_list;
	while(t!= NULL)
	{
		if(t->pid == pid)
			return t;
		t=t->next;
	}
	return NULL;
}

void initialise_process()
{
	
}
//TODO : Not working 

struct task_struct *create_new_task(char *taskname)
{
//if(process_count == 10)/*) && strcmp(taskname, "kill"))*/
//		return NULL;
	struct task_struct *task = NULL;
	// TODO : Get trask struct from free_task_list
	// Else kmalloc
	//task = (struct task_struct *)kmalloc(sizeof(struct task_struct));
	task = get_free_task();
	if(kstrcmp(taskname, "idle") != 0)
		add_to_task_list(task);
	task->pid = pid++;
	task->ppid = 0;
	task->sleep_time = 0;
	task->parent = NULL;
	task->pipe = NULL;
	task->child_count = 0;
	task->write_redirection_fd = 0;
	task->read_redirection_fd = 0;
	task->wait_for_child_pid = 0;
	kstrcpy(task->name, taskname);
	//task->mm = create_new_mmstruct();
	task->state = TASK_RUNNABLE;
	task->pml4e = env_setup_vm();	//virtual address
	memset((void*)task->kstack, 0, KSTACK_SIZE);
	task->next = NULL;
	task->r.ds = task->r.fs = task->r.es = task->r.gs = 0x23;
	
	//kprintf2("task pid is %d \n", task->pid);
	return task;
}

struct mm_struct * create_new_mmstruct()
{
	struct mm_struct *mm = NULL;
	mm = (struct mm_struct *)kmalloc(sizeof(struct mm_struct));
	mm->vma_list = NULL;
	mm->start_brk = 0;
	mm->end_brk = 0;
	mm->start_stack = 0;
	mm->arg_start = 0;
	mm->arg_end = 0;
	mm->env_start = 0;
	mm->env_end = 0;
	mm->total_vm_size = 0;
	mm->stack_vm = 0;
	return mm;
	
}

void free_task_struct(struct task_struct *task)
{
	//kprintf2("freeing memory for %s \n", task->name);
 // uint64_t old_cr3 = read_cr3();
//	kprintf("old cr3 %p , task cr3 %p \n", getCR3(), virt_to_phy(task->pml4e, 0));
  write_cr3(virt_to_phy(task->pml4e, 0));
  remove_from_task_list(task);
  free_task_mm_struct(task->mm, task);
  task->state = TASK_STOPPED;
  //counter removed fromt ask 
  task->next = NULL;
  task->e_entry = 0;
  //task->rip = 0;
  //task->rsp = 0;
  task->ppid = 0;
  task->write_redirection_fd = 0;
  task->read_redirection_fd = 0;
  task->pipe = NULL;
  task->parent = NULL;
  task->child_count = 0;
  task->wait_for_child_pid = 0;
  task->sleep_time = 0;
	
  //remove all page table entries
  
  //clear kstack
  //memset((void*)task->kstack, 0, 512);
  //kfree(vma->vm_start,vma->vm_end-vma->vm_start);
  write_cr3(getCR3());
  //reset_page_tables(task->pml4e);
  	
  task->pml4e = 0;
  //kfree(task);
  add_to_free_task_list(task);
}

void free_task_mm_struct(struct mm_struct *mm, struct task_struct *task){
	struct vm_area_struct *vma = mm->vma_list;
	mm->total_vm_size = 0;
	mm->stack_vm = 0;
	//int i = 0;
	while(vma!=NULL){
		//kprintf2("free_task_mm_struct %d \n", i++);
		if(vma->vma_type == VMA_STACK)
		{
		//	kprintf2("freeing memory for stack %s \n", task->name);
			//memset((void*)vma->vm_end,0,vma->vm_start-vma->vm_end);
			kfree(vma->vm_end,vma->vm_start-vma->vm_end);
		}
		else if(task->parent == NULL && vma->vma_type == VMA_HEAP)
		{
		//	kprintf2("freeing memory for heap %s \n", task->name);
			//memset((void*)vma->vm_start,0,vma->vm_end-vma->vm_start);
			kfree(vma->vm_end,vma->vm_start-vma->vm_end);
		}
		else if(task->parent == NULL && vma->vma_type == VMA_NORMAL)
		{
		//	kprintf2("freeing memory for normal vma %s \n", task->name);
			//memset((void*)vma->vm_start,0,vma->vm_end-vma->vm_start);
			kfree(vma->vm_start,vma->vm_end-vma->vm_start);
		}
		vma->vm_mm = NULL;
		vma->vm_start = 0;
		vma->vm_end = 0;
		vma->vm_flags = 0;
		vma->vm_file_descp = 0;
		//add_to_free_vm_list(vma);
		vma = vma->next;
	}
	mm->vma_list = NULL;
	mm->start_brk = 0;
	mm->end_brk = 0;
	mm->start_stack = 0;
	mm->arg_start = 0;
	mm->arg_end = 0;
	mm->env_start = 0;
	mm->env_end = 0;
	mm->total_vm_size = 0;
	mm->stack_vm = 0;
	//kprintf2("free_task_mm_struct end %s \n", task->name);
}

void add_to_vma_list(struct mm_struct *mm, struct  vm_area_struct *vma)
{
	if(mm->vma_list == NULL)
		mm->vma_list = vma;
	else
	{
		struct vm_area_struct *temp_vma = mm->vma_list;
		while(temp_vma->next != NULL)
		{
			temp_vma = temp_vma->next;
		}
		temp_vma->next = vma;
	}
}

void update_time_slices()
{
	struct task_struct *t = task_list;
	while(t != NULL)
	{
		if(t->state == TASK_SLEEP)
		{
			change_task_state(t);
		}
		t = t->next;
	}
}

void change_task_state(struct task_struct *task)
{
	if(task == NULL)
		return;
	else
	{
		if(task->sleep_time == 0)
			task->state = TASK_RUNNABLE;
		else
			task->sleep_time--;
	}
}

void remove_from_parent(struct task_struct *child)
{
	struct task_struct *parent = child->parent;
//	if(parent == NULL)
//		return;
	parent->child_count--;
	if(parent->state == TASK_WAITING && parent->wait_for_child_pid == child->pid)
	{
		parent->state = TASK_RUNNABLE;
	}
}
