//Queue implementation using an array.(Queue Size:5)
//Basic operations of the Queue is implemented such as enqueue,dequeue,isFull,isEmpty,peek along with traversal of the current queue

class SimpleQueueImpl{
	
	public int front = -1;				//front points to the front end of the queue from where item is dequeued
	public int rear = -1;				//rear points to the rear end of the queue from where item is enqueued
	public int dequeued_value;
	public int capacity;				//Sizeof the queue
	public int[] queue;

	public SimpleQueueImpl(int size){	//Parameterized Constructor to initialize the queue
		queue = new int[size];
		capacity = size;

	}


	//Method to enqueue data to the queue from rear end
	public void enqueue(int value){
		if(isFull() && front == rear){			//Upperbound conditions to check if Queue is full. If the queue if empty
			front = rear = -1; 					//and just rear(along with front) has reached its end point which is size of the 
		}										//then it must be reintialized to -1
		else if(isFull()){
			System.out.println("Queue is Full");	//Upperbound condition to check if Queue is actually full.
			return;
		}		
		rear++;
		queue[rear] = value;
		System.out.println("Item enqueued in queue at position "+rear+" : "+queue[rear]);
	}


	//Method to dequeue data from the queue
	public Integer dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty, Nothing to Remove");
			return null;
		}
		else{
			front++;
			dequeued_value = queue[front];
			System.out.println("Item dequeued at position "+front+" : "+dequeued_value);
			return dequeued_value;
		}

	}


	//Method to check if queue is full or not
	public boolean isFull(){
		if(rear < capacity-1){
			return false;
		}
		else
			return true;
	}


	//Method to check if the queue is empty or not
	public boolean isEmpty(){		
		if(front == rear){				
			return true;
		}
		else
			return false;
	}


	//Method to get the front value of the queue without dequeuing
	public Integer peek(){
		if(front == -1){		//If any item has not yet been dequeued and queue is peeked.Initally front is
			System.out.println("Item at the front(Next to be removed) : "+queue[0]); //initialized to -1 hence it is incremented
			return queue[0];
		}
		else{
			System.out.println("Item at the front(Next to be removed) : "+queue[front]);
			return queue[front];
		}
	}


	//Method to traverse the current queue status
	public void queueTraverse(){
		if(isEmpty()){
			System.out.println("Queue is Empty, Nothing to Traverse");
			return ;
		}
		else if(front == -1){					//If any item has not yet been dequeued and queue is traversed.Initally front is 
			for(int i = 0; i <=rear; i++){		//initialized to -1 hence it is incremented
				System.out.print(+queue[i]+" ");
			}
			System.out.println("\n");
		}
		else if(front > -1){
			int start = front + 1;
			for(int i = start; i <=rear; i++){
				System.out.print(+queue[i]+" ");
			}
			System.out.println("\n");
		}
	}


}


//Driver class for SimpleQueueImpl
class QueueDriver{
	public static void main(String[] args){
		SimpleQueueImpl obj = new SimpleQueueImpl(5);
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);
		obj.enqueue(60);	//Checking Overflow Condition
		obj.peek();	
		obj.queueTraverse();	
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.queueTraverse();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();		//Checking Underflow Condition
		obj.enqueue(10);
		obj.enqueue(20);
		obj.queueTraverse();

	}
}
/* Output:
Item enqueued in queue at position 0 : 10
Item enqueued in queue at position 1 : 20
Item enqueued in queue at position 2 : 30
Item enqueued in queue at position 3 : 40
Item enqueued in queue at position 4 : 50
Queue is Full
Item at the front(Next to be removed) : 10
10 20 30 40 50 

Item dequeued at position 0 : 10
Item dequeued at position 1 : 20
Item dequeued at position 2 : 30
40 50 

Item dequeued at position 3 : 40
Item dequeued at position 4 : 50
Queue is Empty, Nothing to Remove
Item enqueued in queue at position 0 : 10
Item enqueued in queue at position 1 : 20
10 20 
*/