/*Consider arr is a linear array with N elements and K is a positive integer such that K<=N.
Following is the code to delete an element available at the Kth position of arr.*/

class ArrayDeletion{
	public void kthDeletion(int[] arr,int k){
		int n = arr.length;
		int i;
		System.out.println("The current array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}
		while(k < n-1){
			arr[k] = arr[k+1];
			k++;
		}
		n = n -1;
		System.out.println("The updated array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}
	}
}
class DeletionDriver{
	public static void main(String[] args){
		int[] arr = {0,10,20,30,40,50,60,70,80,90};
		int k = 5;
		ArrayDeletion obj = new ArrayDeletion();
		obj.kthDeletion(arr,k);
	}
}