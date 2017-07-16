/*Consider arr is a linear array with N elements and K is a positive integer such that K<=N.
Following is the code to update an element available at the Kth position of arr*/

class ArrayUpdation{
	public void arrayUpdate(int[] arr,int k,int item){
		int n = arr.length;
		int i;
		System.out.println("The current array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}

		arr[k] = item;

		System.out.println("The updated array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}
	}
}
class UpdationDriver{
	public static void main(String[] args){
		int[] arr = {0,10,20,30,40,50,60,70,80,100};
		int k = 9,element = 90;
		ArrayUpdation obj = new ArrayUpdation();
		obj.arrayUpdate(arr,k,element);
	}
}