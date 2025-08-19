#include<stdio.h>
struct point
{

int x;
int y;
};
int main()
{
	struct point p1;
	printf("enter x coordinate:");
	scanf("%d",&p1.x);
	printf("enter y coordinate:");
	scanf("%d",&p1.y);
	printf("point is located at (%d,%d)");

	return 0;
	
}
