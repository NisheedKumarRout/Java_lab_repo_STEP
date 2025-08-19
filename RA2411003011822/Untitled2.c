#include<stdio.h>
struct supermart
{
    int itemno;
    char itemname[10];
    float price;
};
  int main()
{
      struct supermart s1,s2;
      scanf("%d",&s1.itemno);
      scanf("%s",s1.itemname);
      scanf("%.2f",&s1.price);
      printf("%d",s1.itemno);
      printf("%s",s1.itemname);
      printf("%.2f",s1.price);
      scanf("%d",&s2.itemno);
      scanf("%s",s2.itemname);
      scanf("%.2f",&s2.price);
      printf("%d",s2.itemno);
      printf("%s",s2.itemname);
      printf("%.2f",s2.price);
      return 0;
  }
