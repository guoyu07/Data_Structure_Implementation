#include<iostream>
#include<conio.h>
using namespace std;
int Partition(int a[], int beg, int end)          
{
int p=beg, pivot=a[beg], loc;

for(loc=beg+1;loc<=end;loc++)
{
if(pivot>a[loc])
{
a[p]=a[loc];
a[loc]=a[p+1];
a[p+1]=pivot;

p=p+1;
}
}
return p;
}


void QuickSort(int a[], int beg, int end)
{
if(beg<end)
{
int p=Partition(a,beg,end);                      
QuickSort(a,beg,p-1);                             
QuickSort(a,p+1,end);			              
}
}


int main()
{
int a[100],i,n,beg,end;
cout<<"Enter the No. of Elements : ";
cin>>n;

for(i=1;i<=n;i++)
{
cin>>a[i];
}
beg=1;
end=n;

QuickSort(a,beg,end);                        	  

cout<<"\nAfter Sorting : \n";
for(i=1;i<=n;i++)
{
cout<<a[i]<<endl;
}
getch();
}
