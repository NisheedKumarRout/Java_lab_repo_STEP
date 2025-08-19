#include<stdio.h>
struct student{

char student_name[60];
int student_age;
float student_cgpa;


};

int main(){
struct student s1;
printf("enter the name of the student");
scanf("%s",&s1.student_name);
printf("enter the age of the student");
scanf("%d",&s1.student_age);
printf("enter the cgpa of the student");
scanf("%f",&s1.student_cgpa);



printf("%s",s1.student_name);
printf("%d",s1.student_age);
printf("%f",s1.student_cgpa);









}

