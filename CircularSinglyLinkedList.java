package Data_Structures;

//Implementation of Singly Circular Linked List
/*-The Implementation includes the methods to insert node into a Singly Circular Linked List
A node can be added in CLL in four ways:

	Insertion in an empty list
	Insertion at the beginning of the list
	Insertion at the end of the list
	Insertion in between the nodes

-The Implementation also includes 3 methods to delete a node from Singly Circular Linked List
Nodes in any linked list can be deleted from

	 	1) From front.
	 	2) From end.
	 	3) From middle or any particular key

-As well as a method named traverseList() which displays the current list
*/


class CircularSinglyLinkedList{


    //Private class node so that it can be only accessed by CircularSinglyLinkedList class
    protected class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }

    Node last; //Pointer that points to the last node of the circular LL
    //Last node is choosen so that using the last node insertion at the both end beginning can be done easily
	/*A node can be added in CLL in four ways:

	Insertion in an empty list
	Insertion at the beginning of the list
	Insertion at the end of the list
	Insertion in between the nodes*/




    //Method to check if the list is empty
    private boolean isEmpty(){
        if(last ==  null){
            return true;
        }
        else
            return false;
    }


    //All the methods that add node to the list returns the address of the node added to the list
    //Method to add a node when the list is empty
    protected Node addToEmpty(int data){
        if(isEmpty()){
            Node node  = new Node(data);
            node.next = node;
            last = node;
            System.out.println("Node with data "+data+" added at the beginning of the list");
            traverseList();
            return node;
        }
        else{
            System.out.println("List Contains item, Insert at the front, end or middle.");
            return null;
        }
    }


    //Method to add node at the beginning of CLL
    protected Node addBegin(int data){
        if(isEmpty()){
            Node n = addToEmpty(data);
            return n;
        }
        else{
            Node node = new Node(data);
            node.next = last.next;				//last.next contains the address of the first node
            last.next = node;					//updating the last node and it should contain the address of the first node
            System.out.println("Node with data "+data+" added at the front");
            traverseList();
            return node;
        }
    }


    //Method to add node at the end of CLL
    protected Node addEnd(int data){
        if(isEmpty()){
            Node n = addToEmpty(data);
            return n;
        }
        else{
            Node node = new Node(data);
            node.next = last.next;			//new node added to the end(node.next) must point to the beginning of the list
            last.next = node;				//and its ref. is in current last.next.
            last = node;
            System.out.println("Node with data "+data+" added at the end");
            traverseList();				//then the last node is linked to new node added and the last pointer is updated
            return node;
        }
    }



    //Method to add node after a given node
    protected Node addAfter(Node ref,int data){
        if(isEmpty() || ref == null){
            System.out.println("The CLL is empty or can't insert after null");
            return null;
        }
        else if(ref == last){
            Node node = new Node(data);
            node.next = ref.next;
            ref.next = node;
            last = node;
            System.out.println("Node with data "+data+" added after "+ref.data);
            traverseList();
            return node;
        }
        else{
            Node node = new Node(data);
            node.next = ref.next;
            ref.next = node;
            System.out.println("Node with data "+data+" added after "+ref.data);
            traverseList();
            return node;
        }
    }


	/*Nodes in any linked list can be deleted from

	 	1) From front.
	 	2) From end.
	 	3) From middle or any particular key
	 */


    //Method to remove node from the front of the CLL
    public void removeFront(){
        if(isEmpty()){
            System.out.println("The List is empty");
            return;
        }
        else if(last.next == last){
            System.out.println("Node with data "+last.data+" is removed from front");
            last = null;
            traverseList();
        }
        else{
            System.out.println("Node with data "+last.next.data+" is removed from front");
            last.next = last.next.next;
            traverseList();
        }
    }


    //Method to remove  node from the end of the CLL
    public void removeEnd(){
        if(isEmpty()){
            System.out.println("The List is empty");
            return;
        }
        else if(last.next == last){
            System.out.println("Node with data "+last.data+" is removed from end");
            last = null;
            traverseList();
        }
        else{
            Node current = last.next;
            do{
                current = current.next;
            }while(current.next != last);

            System.out.println("Node with data "+last.data+" is removed from end");
            current.next = last.next;
            last = current;
            traverseList();
        }
    }


    //Method to delete a particular key from the entire list
    protected void removeKey(int key){
        if(isEmpty()){
            System.out.println("The List is empty");
            return;
        }
        Node current = last.next;
        Node prev = null;
        int value;
        int flag = 0;
        do{
            value = current.data;
            if(value == key && last == last.next){
                last = null;
                System.out.println("After Removing node or nodes with particular key "+key+" from the CSLL :  ");
                traverseList();
                return;
            }
            else if(value == key && current == last.next){
                last.next = current.next;
                flag++;
            }
            else if(value == key && current == last){
                prev.next = last.next;
                last = prev;
                flag++;
            }
            else if(value == key){
                prev.next = current.next;
                flag++;
            }
            prev = current;
            current = current.next;
        }while(current != last.next);
        if(flag == 0){
            System.out.println("Key not found in the list");
            System.out.println("");
            return;
        }
        else{
            System.out.println("After Removing node or nodes with particular key "+key+" from the CSLL :  ");
            traverseList();
        }
    }



    //Method to Display list from front to end
    private void traverseList(){
        Node current;
        if(isEmpty()){
            System.out.println("The list is Empty");
            return;
        }
        current = last.next;
        System.out.print("Contents of the list from beginning : ");
        do{
            System.out.print(current.data+" ");
            current = current.next;
        }while(current != last.next);
        System.out.println("\n");
    }

}


//Driver class for CircularSinglyLinkedList
//It extends CircularSinglyLinkedList so that it can access its protected operations(Methods)
class CircularSinglyLinkedListDriver extends CircularSinglyLinkedList{
    public static void main(String[] args){
        CircularSinglyLinkedList obj = new CircularSinglyLinkedList();
        Node ref1,ref2,ref3;
        ref2 = obj.addToEmpty(10);
        obj.addToEmpty(10);
        obj.addBegin(5);
        obj.addEnd(20);
        ref1 = obj.addBegin(2);
        ref3 = obj.addEnd(25);
        obj.addAfter(ref1,3);
        obj.addAfter(ref2,15);
        obj.addAfter(ref3,30);
        obj.removeFront();
        obj.removeFront();
        obj.removeEnd();
        obj.removeKey(5);
        obj.removeKey(25);
        obj.removeKey(15);
        obj.removeKey(25);
        obj.removeKey(20);
        obj.removeKey(10);
    }
}




/*Output:
Node with data 10 added at the beginning of the list
Contents of the list from beginning : 10

List Contains item, Insert at the front, end or middle.
Node with data 5 added at the front
Contents of the list from beginning : 5 10

Node with data 20 added at the end
Contents of the list from beginning : 5 10 20

Node with data 2 added at the front
Contents of the list from beginning : 2 5 10 20

Node with data 25 added at the end
Contents of the list from beginning : 2 5 10 20 25

Node with data 3 added after 2
Contents of the list from beginning : 2 3 5 10 20 25

Node with data 15 added after 10
Contents of the list from beginning : 2 3 5 10 15 20 25

Node with data 30 added after 25
Contents of the list from beginning : 2 3 5 10 15 20 25 30

Node with data 2 is removed from front
Contents of the list from beginning : 3 5 10 15 20 25 30

Node with data 3 is removed from front
Contents of the list from beginning : 5 10 15 20 25 30

Node with data 30 is removed from end
Contents of the list from beginning : 5 10 15 20 25

After Removing node or nodes with particular key 5 from the CSLL :
Contents of the list from beginning : 10 15 20 25

After Removing node or nodes with particular key 25 from the CSLL :
Contents of the list from beginning : 10 15 20

After Removing node or nodes with particular key 15 from the CSLL :
Contents of the list from beginning : 10 20

Key not found in the list

After Removing node or nodes with particular key 20 from the CSLL :
Contents of the list from beginning : 10

After Removing node or nodes with particular key 10 from the CSLL :
The list is Empty
*/

