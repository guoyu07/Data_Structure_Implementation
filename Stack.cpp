#include<iostream>
#define size 10
using namespace std;
int push(int,int);
void pop();
void stack_check();
int top=-1;
int stack[size];
int main()
{
	int ch=0,val;
	while(ch!=5){
	cout<<"\nEnter the Choice : \n 1. Push \n 2. Pop \n 3. Check Stack \n 4. Print Stack \n 5. Exit Enter: ";
	cin>>ch;
	
		switch(ch){
			case 1: cout<<"\nEnter the value to stack: ";
					cin>>val;
					top=push(val,top);
					break;
					
			case 2: pop();
					break;
			case 3: stack_check();
					break;
			case 4: stack_check();
					for(int i=0;i<=top;i++){
					cout<<stack[i]<<" ";
					}
					break;
			case 5: exit(0);
					break;
		
			default: cout<<"\nWrong Input\n";
						break;
		}
	}
	return 1;
}

int push(int val,int top){
	top=top+1;
	stack[top]=val;
	return top;
}
void pop(){
	if(top==-1)
		cout<<"Stack Empty.\n";
	else
		cout<<"Element Removed from the stack :"<<stack[top]<<endl;
	--top; 
}
void stack_check(){
	if(top==-1)
		cout<<"Stack Empty. OR Stack Underflow\n";
	else if(top==size)
		cout<<"Stack Overflow\n";
	else
		cout<<"Stack is Neither NoR Overflow\n";
}
