package Data_Structures;

//Implementation of circular queue using array

/*Circular Queue also uses the same implementation as queue(Both uses FIFO Implementation).
This implementation demonstrates the enqueue operation, dequeue operation along with display().
The Circular Queue eliminates the flaw of simple queue which couldn't store data even if the queue had space in it.
*/

public class CircularQueue {
        int[] cQueue;
        int front;
        int rear;
        int count;
        int capacity;

        CircularQueue(int size){    //parameterized constructor to initialize the properties of the object
            cQueue = new int[size];
            capacity = size;
            front = 0;
            rear = 0;
            count = 0;          //Count variable keeps track of number of elements present in queue in current instance
        }


        //Method to push an element in the queue from rear
        private void enQueue(int data){
            if(count >= capacity){
                System.out.println("The Queue is full\n");
                return;
            }
            else{
                count++;
                cQueue[rear] = data;
                System.out.println("Item pushed into the circular queue: "+data);
                rear = (rear + 1)%capacity; //using "%" we are keeping the pointers within the range of the array
                display();
            }

        }


        //Method to pop an element from the queue from front
        private Integer deQueue(){
            if(count <= 0){
                System.out.println("Queue is Empty, Nothing to remove");
                return null;
            }
            else{
                int value = cQueue[front];
                front = (front + 1)%capacity;//After last index(4) it will point to the first index(0)
                count--;                        //(4+1)%5 = 0
                System.out.println("Item popped from the circular queue: "+value);
                display();
                return value;
            }

        }


        //Method to display the content of the circular queue from front to rear
        private void display(){
            if(count <= 0){
                System.out.println("Queue is Empty");
                return;
            }
            int currentCount = count;
            int frontTemp = front;
            System.out.print("The Contents of the Circular Queue are: ");
            while(currentCount > 0){
                if(frontTemp == capacity - 1){         //If the pointer points to last index of array it needs to be
                    System.out.print(+cQueue[frontTemp]+" ");   //initialized to zero
                    frontTemp = 0;
                }
                else{
                    System.out.print(+cQueue[frontTemp]+" ");
                    frontTemp++;
                }
                currentCount--;
            }
            System.out.println("\n");
        }


    //Driver method to test the implementation of circular queue
    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(5);
        obj.enQueue(10);
        obj.enQueue(20);
        obj.enQueue(30);
        obj.enQueue(40);
        obj.enQueue(50);
        obj.enQueue(60);
        obj.deQueue();
        obj.enQueue(60);
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(10);
        obj.enQueue(20);
        obj.enQueue(30);
        obj.enQueue(40);
    }
}
//Circular Queue Size: 5
/*
Output:
Item pushed into the circular queue: 10
The Contents of the Circular Queue are: 10

Item pushed into the circular queue: 20
The Contents of the Circular Queue are: 10 20

Item pushed into the circular queue: 30
The Contents of the Circular Queue are: 10 20 30

Item pushed into the circular queue: 40
The Contents of the Circular Queue are: 10 20 30 40

Item pushed into the circular queue: 50
The Contents of the Circular Queue are: 10 20 30 40 50

The Queue is full

Item popped from the circular queue: 10
The Contents of the Circular Queue are: 20 30 40 50

Item pushed into the circular queue: 60
The Contents of the Circular Queue are: 20 30 40 50 60

Item popped from the circular queue: 20
The Contents of the Circular Queue are: 30 40 50 60

Item popped from the circular queue: 30
The Contents of the Circular Queue are: 40 50 60

Item popped from the circular queue: 40
The Contents of the Circular Queue are: 50 60

Item popped from the circular queue: 50
The Contents of the Circular Queue are: 60

Item popped from the circular queue: 60
Queue is Empty
Item pushed into the circular queue: 10
The Contents of the Circular Queue are: 10

Item pushed into the circular queue: 20
The Contents of the Circular Queue are: 10 20

Item pushed into the circular queue: 30
The Contents of the Circular Queue are: 10 20 30

Item pushed into the circular queue: 40
The Contents of the Circular Queue are: 10 20 30 40
 */
