#include<stdio.h>
struct bank
{
    int accno;
    char bankname[8];

};
 int main()
 {
 struct bank b1,b2;
 scanf("%d",&b1.accno);
 scanf("%s",b1.bankname);
 printf("%d",b1.accno);
 printf("%s",b1.bankname);
 scanf("%d",&b2.accno);
 scanf("%s",b2.bankname);
 printf("%d",b2.accno);
 printf("%s",b2.bankname);
 return 0;
 }
