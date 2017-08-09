package Data_Structures;

//Implementing Stack using singly linked list

/*Operations of the stack are implemented using linked list
Operations include push, pop, peek and display
Testing is done using a driver class to test the operations*/


class StackUsingLinkedList{

    protected class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
        }
    }


    Node top = null;

    //Method to Push data into the stack
    protected void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
        System.out.println("Item inserted into the stack : "+top.data);
        display();
    }


    //Method to pop data from the stack
    protected Integer pop(){
        if(top == null){
            System.out.println("\nStack is Empty, Nothing to remove\n");
            return null;

        }
        System.out.println("Item removed from the stack : "+top.data);
        Node temp = top;
        top = top.next;
        display();
        return temp.data;
    }


    //Method to peek data from the queue
    protected void peek(){
        if(top == null){
            System.out.println("Stack is Empty, Nothing to peek");
            return;

        }
        System.out.println("Item in the top : "+top.data);
        System.out.println("");
    }


    //Method to display the current status of the queue or its current content
    protected void display(){
        if(top == null){
            System.out.println("Stack is Empty");
            return;
        }
        Node current = top;
        System.out.print("Current item in the stack are : ");
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println("\n");
    }
}


//Driver class to test the stack operations
class StackUsingLinkedListDriver extends StackUsingLinkedList{

    public static void main(String[] args){
        StackUsingLinkedList obj = new StackUsingLinkedList();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.peek();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.peek();
    }
}
/*Output:
Item inserted into the stack : 10
Current item in the stack are : 10

Item inserted into the stack : 20
Current item in the stack are : 20 10

Item inserted into the stack : 30
Current item in the stack are : 30 20 10

Item inserted into the stack : 40
Current item in the stack are : 40 30 20 10

Item in the top : 40

Item removed from the stack : 40
Current item in the stack are : 30 20 10

Item removed from the stack : 30
Current item in the stack are : 20 10

Item removed from the stack : 20
Current item in the stack are : 10

Item removed from the stack : 10
Stack is Empty

Stack is Empty, Nothing to remove

Stack is Empty, Nothing to peek
*/

