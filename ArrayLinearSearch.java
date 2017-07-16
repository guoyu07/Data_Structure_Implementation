/*Consider arr is a linear array with N elements. Following is the code to find an element with a 
value of ITEM using sequential search or linear search*/

class ArrayLinearSearch{
	public boolean arraySearch(int[] arr,int item){
		int n = arr.length;
		int i = 0;
		System.out.println("The current array is: ");
		for(i = 0; i < n; i++){
			System.out.println("arr["+i+"]->"+arr[i]);
		}
		i = 0;
		while(i < n){
			if(arr[i] == item){
				System.out.println("The item "+item+" is at position: "+i);
				return true;
			}
			i++;
		}
		return false;
	}
}
class SearchDriver{
	public static void main(String[] args){
		int[] arr = {0,10,20,30,40,50,60,70,80,90};
		int key = 90;
		ArrayLinearSearch obj = new ArrayLinearSearch();
		boolean results = obj.arraySearch(arr,key);
		if (results == false){
			System.out.println("Item not available in the given array");
		}
	}
}