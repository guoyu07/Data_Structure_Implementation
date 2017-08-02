//Implementation of Doubly Circular Linked List
/*-The Implementation includes the methods to insert node into a Doubly Circular Linked List
A node can be added in CLL in four ways:

	Insertion in an empty list
	Insertion at the beginning of the list
	Insertion at the end of the list
	Insertion before a particular node
	Insertion after a particular node

-The Implementation also includes 3 methods to delete a node from Doubly Circular Linked List	
Nodes in any linked list can be deleted from

	 	1) From front.
	 	2) From end.
	 	3) From middle or any particular key

-As well as a method named traverseList() which displays the current list
-Along with a method named reverseTraverseList() which displays the current list in reverse
*/

class CDLListImpl{

	
	//Node class which consist of basic structure of the node(prev,data,next)
	protected class Node{
		int data;
		Node prev;
		Node next;
		Node(int d){
			data = d;
		}
	}

	Node last = null;	//Pointer that points to the last node of the circular DLL 	
			   //Last node is choosen so that using the last node insertion at the both end beginning can be done easily
				//But in Doubly CLL we can use head or last it does not matter. Both works same.
	/*A node can be added in Doubly CLL in five ways:

	Insertion in an empty list
	Insertion at the beginning of the list
	Insertion at the end of the list
	Insertion before a particular node
	Insertion after a particular node*/


	
	//Method to check if the list is empty or not
	private boolean isEmpty(){
		if(last == null){
			return true;
		}
		else{
			return false;
		}
	}
	

	//Method to add node when a list is empty
	protected Node addEmpty(int data){
		if(isEmpty()){
			Node node = new Node(data);
			node.next = node;
			node.prev = node;
			last = node;
			System.out.println("First Node with value "+data+" is added to the list");
			traverseList();
			return node;
		}
		else{
			System.out.println("List already exists add node in front, rear or middle");
			System.out.println("");
			return null;
		}
	}


	//Method to add node at the front of the list
	protected Node addFront(int data){
		if(isEmpty()){					//If list is empty we call addEmpty()
			Node n = addEmpty(data);
			return n;
		}
		else{
			Node node = new Node(data);
			node.next = last.next;
			last.next.prev = node;
			node.prev = last;
			last.next = node;
			System.out.println("Node with value "+data+" inserted at the front");
			traverseList();
			return node;

		}
	}


	//Method to add node at the end of the list
	protected Node addEnd(int data){
		if(isEmpty()){
			Node n = addEmpty(data);
			return n;
		}
		else{
			Node node = new Node(data);
			node.next = last.next;
			last.next.prev = node;
			node.prev = last;
			last.next = node;
			last = node;
			System.out.println("Node with value "+data+" inserted at the end");
			traverseList();
			return node;
		}
	}


	//Method to add node before any particular node
	protected Node addBefore(Node ref, int data){
		if(ref == null){			//Can't insert before null or when list is empty
			System.out.println("Cannot insert node before null");
			return null;
		}
		else if(ref == last.next){		//Condition when we need to insert before the FIRST node
			Node node = new Node(data);
			node.next = last.next;
			node.prev = last;
			ref.prev = node;
			last.next = node;
			System.out.println("Node with value "+data+" inserted before node("+ref.data+")");
			traverseList();
			return node;
		}	
		else{						//For all the other conditions the below code will work perfectly
			Node node = new Node(data);
			node.prev = ref.prev;
			node.next = ref;
			ref.prev.next = node;
			ref.prev = node;
			System.out.println("Node with value "+data+" inserted before node("+ref.data+")");
			traverseList();
			return node;
		}
	}


	//Method to insert a node after a particular node
	protected Node addAfter(Node ref, int data){

		if(ref == null){			//Can't insert before null or when list is empty
			System.out.println("Cannot insert node after null");
			return null;
		}
		else if(ref == last){		//Condition when we need to insert node after the LAST node
			Node node = new Node(data);
			last.next.prev = node;
			node.next = last.next;
			last.next = node;
			node.prev = last;
			last = node;
			System.out.println("Node with value "+data+" inserted after node("+ref.data+")");
			traverseList();
			return node;
		}
		else{						////For all the other conditions the below code will work perfectly
			Node node = new Node(data);
			ref.next.prev = node;
			node.next = ref.next;
			ref.next = node;
			node.prev = ref;
			System.out.println("Node with value "+data+" inserted after node("+ref.data+")");
			traverseList();
			return node;
		}
	}


	/*Nodes in any linked list can be deleted from

	 	1) From front.
	 	2) From end.
	 	3) From middle or any particular key
	 */


	//Method to remove node from the front of the Circular Doubly LL	
	protected void removeFront(){
		if(isEmpty()){
			System.out.println("List is empty, Nothing to remove");
			return;
		}
		else if(last.next == last){		//Condition when only one node is left
			System.out.println("Node removed from front with value "+last.data);
			last = null;
			traverseList();
		}
		else{
			System.out.println("Node removed from front with value "+last.next.data);
			last.next = last.next.next;
			last.next.prev = last;
			traverseList();
		}
	}


	//Method to remove node from the end of the list
	protected void removeEnd(){
		if(isEmpty()){
			System.out.println("List is empty, Nothing to remove");
			return;
		}
		else if(last.next == last){	 //Condition when only one node is left
			System.out.println("Node removed from rear with value "+last.data);
			last = null;
			traverseList();
		}
		else{
			System.out.println("Node removed from rear with value "+last.data);
			last.prev.next = last.next;
			last.next.prev = last.prev;
			last = last.prev;
			traverseList();
		}
	}


	//Method to remove a particular key from the list
	protected void removeKey(int key){
		if(isEmpty()){
			System.out.println("List is empty, Nothing to remove");
			return;
		}
		else{
			Node current = last.next;
			do{
				if(current.data == key && last == last.next){	//Condition when only one node is left and data matches key	
					last = null;
					break;
				}
				else if(current.data == key && current == last.next){ //Condition when first node data matches key	
					current.next.prev = last;
					last.next = current.next; 
				}
				else if(current.data == key && current == last){	//Condition when last node data matches the key
					current.prev.next = current.next;
					current.next.prev = current.prev;
					last = current.prev;
				}
				else if(current.data == key){			//Condition when any middle node data matches the key
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				current = current.next;
			}while(current != last.next);
			System.out.println("Nodes with value "+key+" is removed");
			traverseList();
		}
	}



	//Method to traverse the entire list from front to rear
	private void traverseList(){
		if(isEmpty()){
			System.out.print("Current contents of the List : EMPTY");
			System.out.println("");
			return;
		}
		Node currentNode = last.next;
		System.out.print("Current contents of the List : ");
		do{
			System.out.print(currentNode.data+" ");
			currentNode = currentNode.next;
		}while(currentNode != last.next);
		System.out.println("\n");
	}



	//Method to traverse the entire list from rear to front(Reverse of traverseList())
	protected void reverseTraverseList(){
		if(isEmpty()){
			System.out.print("Current contents of the List : EMPTY");
			System.out.println("");
			return;
		}
		Node current = last;
		System.out.print("Reversed contents of the List : ");
		do{
			System.out.print(current.data+" ");
			current = current.prev;
		}while(current != last);
		System.out.println("\n");
	}
}



//Driver class for the CDLListImpl class
class CDLListDriver extends CDLListImpl{

	public static void main(String[] args){
		CDLListImpl obj = new CDLListImpl();
		Node ref1,ref2,ref3,ref4,ref5;
		obj.addEmpty(50);
		obj.addFront(40);
		ref2 = obj.addFront(30);
		ref1 = obj.addFront(20);
		ref5 = obj.addEnd(60);
		ref3 = obj.addEnd(70);
		ref4 = obj.addBefore(ref1,10);
		obj.addBefore(ref2,25);
		obj.addBefore(ref3,65);
		obj.addAfter(ref3,80);
		obj.addAfter(ref4,15);
		obj.addAfter(ref2,35);
		obj.reverseTraverseList();
		obj.removeFront();
		obj.removeFront();
		obj.removeEnd();
		obj.removeEnd();
		obj.removeKey(20);
		obj.removeKey(35);
		obj.removeKey(65);
		obj.addAfter(ref5,60);
		obj.removeKey(60);
		obj.addEnd(80);
		obj.removeEnd();
		obj.removeEnd();
		obj.removeEnd();
		obj.removeFront();
		obj.removeKey(30);
	}
}
/*Output:
First Node with value 50 is added to the list
Current contents of the List : 50 

Node with value 40 inserted at the front
Current contents of the List : 40 50 

Node with value 30 inserted at the front
Current contents of the List : 30 40 50 

Node with value 20 inserted at the front
Current contents of the List : 20 30 40 50 

Node with value 60 inserted at the end
Current contents of the List : 20 30 40 50 60 

Node with value 70 inserted at the end
Current contents of the List : 20 30 40 50 60 70 

Node with value 10 inserted before node(20)
Current contents of the List : 10 20 30 40 50 60 70 

Node with value 25 inserted before node(30)
Current contents of the List : 10 20 25 30 40 50 60 70 

Node with value 65 inserted before node(70)
Current contents of the List : 10 20 25 30 40 50 60 65 70 

Node with value 80 inserted after node(70)
Current contents of the List : 10 20 25 30 40 50 60 65 70 80 

Node with value 15 inserted after node(10)
Current contents of the List : 10 15 20 25 30 40 50 60 65 70 80 

Node with value 35 inserted after node(30)
Current contents of the List : 10 15 20 25 30 35 40 50 60 65 70 80 

Reversed contents of the List : 80 70 65 60 50 40 35 30 25 20 15 10 

Node removed from front with value 10
Current contents of the List : 15 20 25 30 35 40 50 60 65 70 80 

Node removed from front with value 15
Current contents of the List : 20 25 30 35 40 50 60 65 70 80 

Node removed from rear with value 80
Current contents of the List : 20 25 30 35 40 50 60 65 70 

Node removed from rear with value 70
Current contents of the List : 20 25 30 35 40 50 60 65 

Nodes with value 20 is removed
Current contents of the List : 25 30 35 40 50 60 65 

Nodes with value 35 is removed
Current contents of the List : 25 30 40 50 60 65 

Nodes with value 65 is removed
Current contents of the List : 25 30 40 50 60 

Node with value 60 inserted after node(60)
Current contents of the List : 25 30 40 50 60 60 

Nodes with value 60 is removed
Current contents of the List : 25 30 40 50 

Node with value 80 inserted at the end
Current contents of the List : 25 30 40 50 80 

Node removed from rear with value 80
Current contents of the List : 25 30 40 50 

Node removed from rear with value 50
Current contents of the List : 25 30 40 

Node removed from rear with value 40
Current contents of the List : 25 30 

Node removed from front with value 25
Current contents of the List : 30 

Nodes with value 30 is removed
Current contents of the List : EMPTY
*/