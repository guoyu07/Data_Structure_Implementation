/*Implemenatation of doubly linked list

Implemented with the operations such as inserting a node at the
1) At the front of the DLL
2) After a given node.
3) At the end of the DLL
4) Before a given node.

Along with deleting the nodes from
1) Front of the List
2) Middle of the list
3) End of the list 

Along with the display of DLL
1) Forward Display
2) Reverse Display
*/

//Node have a data field and two reference fields prev and next to store the reference of next and previous nodes
class Node{
	int data;
	Node prev;
	Node next;
	Node(int d){
		data = d;
	}
}

/*
A node can be added in four ways
1) At the front of the DLL
2) After a given node.
3) At the end of the DLL
4) Before a given node.
*/


class DLListImpl{

	Node head;
	Node current;

	//Method to insert data at the front of the list
	public Node dLListFrontInsert(int data){
		Node node = new Node(data);

		if(head == null){
			head = node;
			node.prev = null;
			node.next = null;
		}

		else{
			head.prev = node;
			node.next = head;
			node.prev = null;
			head = node;
		}
		System.out.println("Node inserted at front with value : "+node.data);
		dLListDisplay();
		System.out.println();
		return node;
	}


	//Method to insert data at the end of the list
	public Node dLListEndInsert(int data){
		Node node = new Node(data);
		if(head == null){								//If list is empty and we need to insert
			head = node;	
		}
		else{
			current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = node;
			node.prev = current;
		}
		System.out.println("Node inserted at end with value : "+node.data);
		dLListDisplay();
		System.out.println();
		return node;
	}



	//Method to insert data after a particular node
	public Node dLListAfterInsert(Node n,int data){
		Node node = new Node(data);

		if(head == null && n == null){			//head is passed as node n when there are no node available in list
			head = node;
			System.out.println("Node inserted with after head with value : "+node.data);
			dLListDisplay();
			System.out.println();
			return node;
		}
		else if(head != null && n == null){		//list is already their and need to add node after null which is wrong input
			System.out.println("Can't add node after NULL as list is already present");
			return null;
		}
		else if(n.next == null){			//to insert any node at the end of the list
			node.prev = n;
			node.next = n.next;
			n.next = node;
			System.out.println("Node inserted after "+n.data+" with value : "+node.data);
			dLListDisplay();
			System.out.println();
			return node;
		}				
		else{								//to insert after any other node in middle
			node.prev = n;
			node.next = n.next;
			n.next.prev = node;
			n.next = node;
			System.out.println("Node inserted after "+n.data+" with value : "+node.data);
			dLListDisplay();
			System.out.println();
			return node;
		}
	}




	//Method to insert data before a particular node
	public Node dLListBeforeInsert(Node n,int data){
		Node node = new Node(data);
		if(n == null){			//if trying to insert before null or when list is empty
			System.out.println("Cannot insert before null or before head reference");
			System.out.println();
			return null;
		}
		else if(n == head){		//if a node has to be inserted before the first node
			node.next =head;
			node.prev = null;
			head = node;
			System.out.println("Node inserted before "+n.data+" with value : "+node.data);
			dLListDisplay();
			System.out.println();
			return node;
		}
		else{					//if a node has to be inserted before any other node other than first node
			node.prev = n.prev;
			node.next = n;
			n.prev.next = node;
			n.prev = node;
			System.out.println("Node inserted before "+n.data+" with value : "+node.data);
			dLListDisplay();
			System.out.println();
			return node;
		}
	}


	//Method to check if the list is empty or not
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		else{
			return false;
		}
	}



	//Method to delete the first or front node of the DLL
	public void dLListFrontDelete(){
		if(isEmpty()){
			System.out.println("List is Empty, Nothing to delete");
			return;
		}
		if(head.next == null){//If only one node is left out and is to be deleted the statement head.prev = null below will
			System.out.println("Item deleted from front : "+head.data);	//throw exception as head is updated to NULL
			head = null;
			dLListDisplay();
			System.out.println();
		}
		else{
			System.out.println("Item deleted from front : "+head.data);
			head = head.next;
			head.prev = null;													//here
			dLListDisplay();
			System.out.println();
		}
	}


	//Method to delete the list node from the DLL
	public void dLListEndDelete(){
		if(isEmpty()){
			System.out.println("List is Empty, Nothing to delete");
			return;
		}
		if(head.next == null){//If only one node is left out and is to be deleted the statement current.prev.next = null
			current = null;		// will throw exception as current.prev is updated to null
			System.out.println("Item deleted from rear : "+head.data);
			head = null;
			dLListDisplay();
			System.out.println();
		}
		else{
			current = head;
			while(current.next != null){
				current = current.next;
			}
			System.out.println("Item deleted from rear : "+current.data);
			current.prev.next = null;										//here
			current = null;
			dLListDisplay();
			System.out.println();
		}
	}

	//Method to delete the middle element of the list
	public void dLListMiddleDelete(){
		if(isEmpty()){
			System.out.println("List is Empty, Nothing to delete");
			return;
		}
		else{
			current = head;
			double count = 0;
			double mid = 0;
			while(current != null){
				count++;
				current = current.next; 
			}
			System.out.println("Current size of the DLL : "+count);
			System.out.println("");
			mid = count/2;
			mid = Math.ceil(mid);
			current = head;
			while(mid > 1){
				current = current.next;
				mid--;
			}
			System.out.println("Item deleted from middle : "+current.data);
			current.prev.next = current.next;
			current.next.prev = current.prev;
			current = null;
			dLListDisplay();
			System.out.println();
		}
	}
	

	//Method to print DLL in reverse
	public void dLLReverseDisplay(){
		current = head;
		System.out.print("The reversed items in DLL : ");
		while(current.next != null){			//Loop to get last reference of the last node
			current = current.next;
		}
		while(current != null){					//using that reference to reverse print the DLL
			System.out.print(current.data+" ");	//The prev field of dll is also null as the next field in last node
			current = current.prev;
		}
		System.out.println("\n");
	}




	//Method to display the current list
	public void dLListDisplay(){
			current = head;
		System.out.print("The current data in DLL : ");
		while(current != null){
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.print("\n");
	}
}


//Driver class for DLListImpl
class DLLDriver{

	public static void main(String[] args){
		DLListImpl obj = new DLListImpl();
		Node ref1;
		Node ref2 = null;
		Node ref3;
		Node ref4;
		obj.dLListAfterInsert(ref2,1);
		obj.dLListBeforeInsert(ref2,10);
		obj.dLListEndInsert(60);
		ref1 = obj.dLListFrontInsert(10);
		obj.dLListFrontInsert(20);
		ref2 = obj.dLListFrontInsert(30);
		obj.dLListEndInsert(40);
		ref3 = obj.dLListEndInsert(50);
		obj.dLListBeforeInsert(ref1,25);
		obj.dLListAfterInsert(ref1,35);
		ref4 = obj.dLListBeforeInsert(ref2,15);
		obj.dLListBeforeInsert(ref3,100);
		obj.dLListAfterInsert(ref4,16);
		obj.dLListAfterInsert(ref3,99);
		obj.dLListFrontDelete();
		obj.dLListFrontDelete();
		obj.dLListEndInsert(105);
		obj.dLLReverseDisplay();
		obj.dLListEndDelete();
		obj.dLListEndDelete();
		obj.dLListMiddleDelete();
		obj.dLListMiddleDelete();
		obj.dLListMiddleDelete();
		obj.dLListEndDelete();
		obj.dLListEndDelete();
		obj.dLListEndDelete();
		obj.dLListEndDelete();
		obj.dLListFrontDelete();
		obj.dLListFrontDelete();
		obj.dLListEndDelete();
		obj.dLListFrontDelete();
		obj.dLListEndDelete();
	}
}

/*Output:
Node inserted with after head with value : 1
The current data in DLL : 1 

Cannot insert before null or before head reference

Node inserted at end with value : 60
The current data in DLL : 1 60 

Node inserted at front with value : 10
The current data in DLL : 10 1 60 

Node inserted at front with value : 20
The current data in DLL : 20 10 1 60 

Node inserted at front with value : 30
The current data in DLL : 30 20 10 1 60 

Node inserted at end with value : 40
The current data in DLL : 30 20 10 1 60 40 

Node inserted at end with value : 50
The current data in DLL : 30 20 10 1 60 40 50 

Node inserted before 10 with value : 25
The current data in DLL : 30 20 25 10 1 60 40 50 

Node inserted after 10 with value : 35
The current data in DLL : 30 20 25 10 35 1 60 40 50 

Node inserted before 30 with value : 15
The current data in DLL : 15 30 20 25 10 35 1 60 40 50 

Node inserted before 50 with value : 100
The current data in DLL : 15 30 20 25 10 35 1 60 40 100 50 

Node inserted after 15 with value : 16
The current data in DLL : 15 16 30 20 25 10 35 1 60 40 100 50 

Node inserted after 50 with value : 99
The current data in DLL : 15 16 30 20 25 10 35 1 60 40 100 50 99 

Item deleted from front : 15
The current data in DLL : 16 30 20 25 10 35 1 60 40 100 50 99 

Item deleted from front : 16
The current data in DLL : 30 20 25 10 35 1 60 40 100 50 99 

Node inserted at end with value : 105
The current data in DLL : 30 20 25 10 35 1 60 40 100 50 99 105 

The reversed items in DLL : 105 99 50 100 40 60 1 35 10 25 20 30 

Item deleted from rear : 105
The current data in DLL : 30 20 25 10 35 1 60 40 100 50 99 

Item deleted from rear : 99
The current data in DLL : 30 20 25 10 35 1 60 40 100 50 

Current size of the DLL : 10.0

Item deleted from middle : 35
The current data in DLL : 30 20 25 10 1 60 40 100 50 

Current size of the DLL : 9.0

Item deleted from middle : 1
The current data in DLL : 30 20 25 10 60 40 100 50 

Current size of the DLL : 8.0

Item deleted from middle : 10
The current data in DLL : 30 20 25 60 40 100 50 

Item deleted from rear : 50
The current data in DLL : 30 20 25 60 40 100 

Item deleted from rear : 100
The current data in DLL : 30 20 25 60 40 

Item deleted from rear : 40
The current data in DLL : 30 20 25 60 

Item deleted from rear : 60
The current data in DLL : 30 20 25 

Item deleted from front : 30
The current data in DLL : 20 25 

Item deleted from front : 20
The current data in DLL : 25 

Item deleted from rear : 25
The current data in DLL : 

List is Empty, Nothing to delete
List is Empty, Nothing to delete
*/