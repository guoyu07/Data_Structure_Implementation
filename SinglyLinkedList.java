package Data_Structures;

//Singly Linked List Implementation
//This is a simple linked list or singly linked list with operations such as insertion, display, search
//along with first_node_removal, last_node_removal, particular_key_removal operation on the linked list


//This class contains two fields for a node
//one stores the data and another store the reference of next node in list
class SinglyNode{
    int data;
    SinglyNode next;
    SinglyNode(int value){
        data = value;
        next = null;
    }
}

class SinglyLinkedList{

    SinglyNode head;				//Stores the reference of starting  point of the list
    SinglyNode current;
    SinglyNode prev;
    SinglyNode temp;

    //Method to insert a node at the end of the linked list
    public void linkedListInsertion(int data){
        SinglyNode node = new SinglyNode(data);				//Creating a new node- node and its data field stores data value through
        //parameterized constructor and the reference field next is null

        if(head == null){						//If the head is null means the list is empty and first node has to be added
            head = node;
            System.out.println("Node inserted with value: "+node.data);
        }
        else{
            current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = node;
            System.out.println("Node inserted with value: "+node.data);
        }
    }



    //Method to check if the list is empty or not.
    public boolean isEmpty(){
        if(head == null){						//If the head is null means the list is empty
            return true;
        }
        else
            return false;
    }



    //Method to delete the first node of the list
    public void linkedListFirstNodeDeletion(){
        if(isEmpty()){									//lower bound if the array is empty
            System.out.println("The Linked list is empty, nothing to remove.");
            return;
        }
        current = head;									//middle and upper bound if the array contains one or two or n items
        head = head.next;
        current = null;
        linkedListDisplay();
    }




    //Method to delete the last node of the linked list
    public void linkedListLastNodeDeletion(){
        if(isEmpty()){									//lower bound if the linked list is empty
            System.out.println("The Linked list is empty, nothing to remove.");
            return;
        }
        else if(head.next == null){				//To check if their is only one node in the list
            head = null;
            linkedListDisplay();
            return;
        }
        current = head;
        while(current.next != null){			//Storing the current and the previous node reference
            prev = current;
            current = current.next;
        }
        current = null;		//Making the last node null for java GC deallocation process
        prev.next = null;	//Changing the next field of the node of the 2nd last(prev) node to null to mark it is the last
        linkedListDisplay();

    }


    //Method to remove a particular key from the list and there can be 3 conditions or cases or situations as mentioned below
    public void linkedListKeyDeletion(int key){
        if(isEmpty()){
            System.out.println("The Linked list is empty, nothing to remove.");
            return;
        }
        if(head.next == null && head.data == key){	//If their is only one node and that node contains the key
            head = null;
            linkedListDisplay();
            return;
        }
        while(head.data == key){	//If there is a series of nodes starting from the head node with the key value
            head = head.next;
        }
        current = head;				//If the key node is in between two nodes or at the end
        prev = head;
        while(current != null){
            if(current.data == key){
                temp = current.next;
                prev.next = temp;
            }
            prev = current;
            current = current.next;
        }
        linkedListDisplay();
    }



    //Method to display the entire list
    public void linkedListDisplay(){
        if(isEmpty()){
            System.out.println("The Linked list is currently empty.");
            return;
        }
        else{
            current = head;
            System.out.print("The  current linked list contains : ");
            while(current != null){
                System.out.print(current.data+" ");
                current = current.next;
            }
            System.out.println();
        }
    }


    //Method to search a key in the list
    public void search(int value){
        current = head;
        while(current != null){
            if(current.data == value){
                System.out.println("The key is found in the list");
                return;
            }
            current = current.next;
        }
        System.out.println("Key not found in the list");
    }
}


class SinglyLinkedListDriver{
    public static void main(String[] args){
        SinglyLinkedList obj = new SinglyLinkedList();
        obj.linkedListInsertion(10);
        obj.linkedListInsertion(20);
        obj.linkedListInsertion(30);
        obj.search(20);
        obj.search(40);
        obj.linkedListDisplay();
        obj.linkedListInsertion(40);
        obj.linkedListInsertion(50);
        obj.linkedListDisplay();
        obj.linkedListFirstNodeDeletion();
        obj.linkedListFirstNodeDeletion();
        obj.linkedListLastNodeDeletion();
        obj.linkedListLastNodeDeletion();
        obj.linkedListLastNodeDeletion();
        obj.linkedListLastNodeDeletion();
        obj.linkedListInsertion(10);
        obj.linkedListFirstNodeDeletion();
        obj.linkedListInsertion(10);
        obj.linkedListInsertion(20);
        obj.linkedListInsertion(10);
        obj.linkedListInsertion(40);
        obj.linkedListInsertion(60);
        obj.linkedListInsertion(10);
        obj.linkedListKeyDeletion(10);
        obj.linkedListKeyDeletion(40);
        obj.linkedListKeyDeletion(60);
        obj.linkedListKeyDeletion(20);
    }
}
/*Output:
Node inserted with value: 10
Node inserted with value: 20
Node inserted with value: 30
The key is found in the list
Key not found in the list
The  current linked list contains : 10 20 30
Node inserted with value: 40
Node inserted with value: 50
The  current linked list contains : 10 20 30 40 50
The  current linked list contains : 20 30 40 50
The  current linked list contains : 30 40 50
The  current linked list contains : 30 40
The  current linked list contains : 30
The Linked list is currently empty.
The Linked list is empty, nothing to remove.
Node inserted with value: 10
The Linked list is currently empty.
Node inserted with value: 10
Node inserted with value: 20
Node inserted with value: 10
Node inserted with value: 40
Node inserted with value: 60
Node inserted with value: 10
The  current linked list contains : 20 40 60
The  current linked list contains : 20 60
The  current linked list contains : 20
The Linked list is currently empty.
*/
