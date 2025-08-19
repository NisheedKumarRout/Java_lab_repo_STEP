#include<stdio.h>
struct employee{
    char* ID;
    char* name;
    int age;
};
int main()
{
    struct employee e1;
    struct employee *ptr = &e1;
    ptr->ID = "86EE";
    ptr->name = "XYZ";
    ptr->age = 31;
    printf("The ID of the employee is %s\n",ptr->ID);
    printf("The name of the employee is %s\n",ptr->name);
    printf("The age of the employee is %d\n",ptr->age);
    return 0;

}
