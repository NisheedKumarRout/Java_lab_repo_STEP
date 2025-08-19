#include<stdio.h>
int main()
{
    int arr[5];
    for(int i = 0 ; i < 5 ; i++)
    {
        printf("Enter the %d element of the array\n",i);
        scanf("%d",&arr[i]);
    }
    for(int i = 0 ; i < 5 ; i++)
    {
        printf("The %d element of the array is %d\n",i,arr[i]);
       
    }
    for(int i = 0 ; i < 5 ; i++)
    {
        {
            for(int j = 0 ; j < 5 ; j++)
            {
                printf("The division: %f\n", (float)arr[i]/arr[j]);
            }
        }
        
    }
    return 0;
}