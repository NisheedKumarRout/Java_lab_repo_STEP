#include<stdio.h>
int main()
{
    int num,num2,arr[10],i=0,sum=0;
    printf("Enter a number\n");
    scanf("%d",&num);
    num2 = num;
    while(num2 != 0)
    {
        arr[i] = num2%10;
        num2 = num2/10;
        i++;
    }
    arr[i] = '\0';
    i = 0;
    while(arr[i] != '\0')
    {
        sum += arr[i]*arr[i]*arr[i];

    }
    if(sum == num)
    {
        printf("The given number is Armstrong\n");

    }
    else{
        printf("The given number is not Armstrong\n");
    }
}