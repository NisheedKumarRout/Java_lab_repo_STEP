#include<stdio.h>
#include<stdlib.h>
int main(){
	int *ptr;
	//calloc
	ptr=(int*)calloc(5,sizeof(int));
	printf("%p",ptr);
	for(int i=0;i<5;i++)
	{
		printf("%d\n",ptr[i]);
	}
	//malloc
	ptr=(int*)malloc(5*sizeof(int));
	printf("%p",ptr);
	for(int i=0;i<5;i++)
	{
		printf("%d\n",ptr[i]);
	}
	//free
	//free(ptr);
	int *ptr1;
	ptr1=(int*)malloc(5*sizeof(int));
	printf("%p\n",ptr1);
	//realloc
	ptr1=(int*)realloc(ptr1,1*sizeof(int));
	printf("%p",ptr1);
}
