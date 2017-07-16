/*Let arr be a Linear Array (unordered) with N elements and K is a positive integer such that K<=N.
Following is the code where ITEM is inserted into the Kth position of arr*/

import java.util.Arrays;
class ArrayInsertion
{	
	public  void kthInsertion(int[] arr,int k,int item){
		int n = arr.length;
		int[] updatedArray = Arrays.copyOf(arr, n+1);
		int i,j;
		System.out.println("The current array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}
		j = n;
		while(j > k){
			updatedArray[j] = updatedArray[j-1];
			j = j - 1;
		}
		
		updatedArray[k] = item;
		System.out.println("The updated array is: ");
		for(i = 0; i <= n; i++){
			System.out.println("arr["+i+"]->"+updatedArray[i]);
		}
	}
}
class InsertionDriver{
	public static void main(String[] args){
		int[] arr = {0,10,20,30,40,60,70,80,90,100};
		int k = 5, element = 50;
		ArrayInsertion obj = new ArrayInsertion();
		obj.kthInsertion(arr,k,element);
	}
}
