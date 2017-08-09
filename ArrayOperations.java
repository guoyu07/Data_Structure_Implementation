package Data_Structures;

/*Implementation of Basic Operations on a integer array
Operations on array include:

1) kth Insertion
2) kth Deletion
3) kth Updation
4) Linear Search for a key

Along with Formatted output display.
*/

import java.util.Arrays;
class ArrayOperations{


	/*Let arr be a Linear Array (unordered) with N elements and K is a positive integer such that K<=N.
	Following is the code where ITEM is inserted into the Kth position of arr*/

    //Method to add an element at position k
    protected void kthInsertion(int[] arr,int k,int item){
        int n = arr.length;
        int[] updatedArray = Arrays.copyOf(arr, n+1);	//Arrays.copyOf(old_array, new_array_size) copies the old array into
        int i,j;										//new Sized array
        int pos = k;

        System.out.println("The current array is: ");	//style printing
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");						//till here


        j = n;
        while(j > k){									//Shifting elements on the right of the position k by 1
            updatedArray[j] = updatedArray[j-1];
            j = j - 1;
        }

        updatedArray[k] = item;							//Inserting element at the position k
        System.out.println("The updated array after inserting element at position "+pos+" : ");
        for(i = 0; i <= n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i <= n; i++){
            System.out.print(" "+updatedArray[i]+" ");
        }
        System.out.println("\n");
    }




	/*Consider arr is a linear array with N elements and K is a positive integer such that K<=N.
	Following is the code to delete an element available at the Kth position of arr.*/

    //Method to delete element at position K
    protected void kthDeletion(int[] arr,int k){
        int n = arr.length;
        int i,pos = k;

        System.out.println("The current array is: ");
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");


        while(k < n-1){				///Shifting elements to the left by 1
            arr[k] = arr[k+1];
            k++;
        }
        n = n -1;


        System.out.println("The updated array after deleting element at position "+pos+" :");
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");
    }



	/*Consider arr is a linear array with N elements and K is a positive integer such that K<=N.
	Following is the code to update an element available at the Kth position of arr*/

    //Method to update Kth element in the array
    public void arrayUpdate(int[] arr,int k,int item){
        int n = arr.length;
        int i;


        System.out.println("The current array is: ");
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");

        arr[k] = item;			//Updating element at position k

        System.out.println("The updated array after updating element at position "+k+" : ");
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");
    }



	/*Consider arr is a linear array with N elements. Following is the code to find an element with a
	value of ITEM using sequential search or linear search*/

    //Method to search an element in the array using linear search
    public boolean arraySearch(int[] arr,int item){
        int n = arr.length;
        int i = 0;


        System.out.println("The current array is: ");
        for(i = 0; i < n; i++){
            System.out.print("["+i+"] ");
        }
        System.out.println("");
        for(i = 0; i < n; i++){
            System.out.print(" "+arr[i]+" ");
        }
        System.out.println("\n");


        i = 0;
        while(i < n){		//Linear Search algorithm
            if(arr[i] == item){
                System.out.println("The item "+item+" is at position: "+i);
                System.out.println("");
                return true;
            }
            i++;
        }
        return false;
    }



}


//Driver class for ArrayOperations
class ArrayOperationsDriver extends ArrayOperations{
    public static void main(String[] args){
        int[] arr = {0,10,20,30,40,60,70,80,90,100};
        int k = 5, element = 50,key;
        ArrayOperations obj = new ArrayOperations();

        System.out.println("\n------------kthInsertion Operation--------------\n");
        obj.kthInsertion(arr,k,element);


        System.out.println("\n------------kthDeletion Operation--------------\n");
        k = 1;
        obj.kthDeletion(arr,k);


        System.out.println("\n------------kthUpdation Operation--------------\n");
        k = 9;
        element = 99;
        obj.arrayUpdate(arr,k,element);


        System.out.println("\n------------Linear Search Operation--------------\n");
        key = 40;
        boolean results = obj.arraySearch(arr,key);
        if (results == false){
            System.out.println("Item not available in the given array");
            System.out.println("");
        }

        key = 1000;
        results = obj.arraySearch(arr,key);
        if (results == false){
            System.out.println("Item "+key+" not available in the given array");
        }
    }
}

/*Output:
------------kthInsertion Operation--------------

The current array is:
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  10  20  30  40  60  70  80  90  100

The updated array after inserting element at position 5 :
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
 0  10  20  30  40  50  60  70  80  90  100


------------kthDeletion Operation--------------

The current array is:
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  10  20  30  40  60  70  80  90  100

The updated array after deleting element at position 1 :
[0] [1] [2] [3] [4] [5] [6] [7] [8]
 0  20  30  40  60  70  80  90  100


------------kthUpdation Operation--------------

The current array is:
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  20  30  40  60  70  80  90  100  100

The updated array after updating element at position 9 :
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  20  30  40  60  70  80  90  100  99


------------Linear Search Operation--------------

The current array is:
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  20  30  40  60  70  80  90  100  99

The item 40 is at position: 3

The current array is:
[0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
 0  20  30  40  60  70  80  90  100  99

Item 1000 not available in the given array
*/
