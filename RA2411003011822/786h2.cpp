#include<stdio.h>
#include<string.h>
struct student
{
	int id;
	char name [50];
	float marks;

};
int main(){
    struct student s1;
	s1.id =101;
	strcpy (s1.name,"john");
	s1.marks =85.50;
printf("student id:%d\n",s1.id);
printf("student name:%s\n",s1.name);
printf("student marks:%.2f\n",s1.marks);
return 0;



}
