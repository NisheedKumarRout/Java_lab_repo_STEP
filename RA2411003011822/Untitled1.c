#include<stdio.h>
void swap(int *x,int *y)
{
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;
}
int main()
{
    int a,b;
    printf("Enter the value of a and b\n");
    scanf("%d %d",&a,&b);
    printf("The Initial value of a is : %d and b is : %d \n",a,b);
    swap(&a,&b);
    printf("The Final value of a is : %d and b is : %d \n",a,b);
    return 0;
}
