#include<stdio.h>
int main()
{
    float cel,farh;
    printf("Enter the temperature in celcius\n");
    scanf("%f",&cel);
    farh=((9*cel)/5)+32;
    printf("The temperature you entered in celcius is : %.2f and the temperature in Farhenheit is : %.2f\n",cel, farh);
    return 0;
}