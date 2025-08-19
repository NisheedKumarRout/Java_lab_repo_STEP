#include<stdio.h>
struct SuperMarket
{
char itemname[34];
int cost;
int total;
};
int main()
{
struct SuperMarket a1;
printf("Enter the name of the item");
scanf(" %s",&a1.itemname);
scanf("%d",&a1.cost);
scanf("%d",&a1.total);
printf("%s",a1.itemname);
prinf("%d",a1.cost);
printf("%d",a1.total);
if(a1.total>50){
    printf("good purchase");
}
else{
    printf("I should purchase more next time");
 }
 }
