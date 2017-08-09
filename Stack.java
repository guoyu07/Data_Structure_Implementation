package Data_Structures;

//Stack implementation using an array.(Stack Size:5)
//Basic operations of the stack is implemented such as push, pop, peek and isEmpty with overflow and underflow Conditions

class Stack{

    public int top = -1;
    public int[] stack =  new int[5];
    public int val;

    public boolean isFull(){						//This method returns if the stack is full or not
        int l = stack.length;						//Returns True if stack is full else false
        if(top < l-1)
            return false;
        else
            return true;
    }

    public boolean isEmpty(){						//This method checks if the stack is empty or not. If empty it return true
        if(top == -1){								//else false. If the value of top is -1 the the stack is empty.
            System.out.println("Stack is Empty");
            return true;
        }
        else
            return false;
    }

    public void push(int item){						//In this method, a value is pushed into the stack.
        if(isFull()){	// Overflow Condition		//The top pointer is incremented and the item is stored at that location
            System.out.println("Stack is Full");
            return;
        }
        else{
            top++;
            stack[top] =  item;
            System.out.println("The item pushed in the stack at position "+top+"->"+stack[top]);
        }
    }

    public Integer pop(){							//In this method the top most value is popped from the stack
        if(isEmpty()){	// Underflow Conditon 		//And if the stack is empty then we can't pop anything hence return null
            return null;
        }
        else{

            val = stack[top];						//OR int val = stack[top--];In the combination of the two statment or one
            top--;									//single stat. , initially the current val of top is stored to show which
            System.out.println("Item removed from the stack is:"+val);	//value is being removed.Then the pointer top is
            return val;								// decremented.
        }

    }

    public int peek(){								//This method just returns the top most value from the stack.
        System.out.println("The item peeked is: "+stack[top]); //It doesn't pops the value from stack
        return stack[top];
    }
}
class StackDriver{								//Driver class for Stack
    public static void main(String[] args){
        Stack obj = new Stack();
        System.out.println("\n/*Size of the Stack is 5*/\n");
        obj.isEmpty();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60);	//Checking Overflow Condition
        obj.pop();
        obj.peek();
        obj.pop();
        obj.pop();
        obj.push(10);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();		//Checking Underflow Condition
    }
}
//Output:
/*Size of the Stack is 5*/

/*
Stack is Empty
The item pushed in the stack at position 0->10
The item pushed in the stack at position 1->20
The item pushed in the stack at position 2->30
The item pushed in the stack at position 3->40
The item pushed in the stack at position 4->50
Stack is Full
Item removed from the stack is:50
The item peeked is: 40
Item removed from the stack is:40
Item removed from the stack is:30
The item pushed in the stack at position 2->10
Item removed from the stack is:10
Item removed from the stack is:20
Item removed from the stack is:10
Stack is Empty
*/