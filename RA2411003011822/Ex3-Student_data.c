#include<stdio.h>
struct student{
    char* regNo;
    char* name;
    int marks;
};
int main()
{
    struct student s1;
    struct student *ptr = &s1;
    ptr->regNo = "RA2411003011822";
    ptr->name = "Nisheed";
    ptr->marks = 995;
    printf("The registration number of the student is: %s\n",ptr->regNo);
    printf("The name of the student is:                %s\n",ptr->name);
    printf("The marks of the student is: %d\n",ptr->marks);
    return 0 ;
}

