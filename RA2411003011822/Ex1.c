#include<stdio.h>
struct Emp{
	int Id;
	char *name;
	int salary;
	long int phoneNumber;
	float rating;
	
};
int main()
{
	struct Emp e1;
	e1.Id = 101;
	e1.name = "Nisheed";
	e1.salary = 3500000;
	e1.phoneNumber = 999999888;
	e1.rating = 4.96;
	printf("The Id of the employee is: %d\n",e1.Id);
	printf("The name of the employee is: %s\n",e1.name);
	printf("The salary of the employee is: %d\n",e1.salary);
	printf("The Phone Number of the employee is: %d\n",e1.phoneNumber);
	printf("The rating of the employee is: %.2f stars\n",e1.rating);
	return 0;
}










































