public class StackInArray {
    private int array[];
    private int size;
    private int index;

    StackInArray(int size){        // Stack constructor initializing the variables and taking argument for size variable
        this.size = size;
        array = new int[size];
    }
    public void push(int element){      //this method pushes the element one by one
        if(isFull()){
            System.out.println("stack is full:(");
        }
        array[index] = element;
        index++;
    }
    public int pop(){       //this method deletes or pops the last element recently added
        if(isEmpty()){
            System.out.println("stack is empty:(");
        }
        return array[--index];
    }
    public boolean isEmpty(){         //this method check if the stack is empty or not
        if (index == 0){
            return true;
        }
        return false;
    }
    public boolean isFull(){       //this method checks if the Stack's size is full or not
        if(index == size){
            return  true;
        }
        return false;
    }
    public int size(){         // this method returns the size of the array.
        return index;
    }
}
class StackClient{
    public static void main(String[] args) {
        StackInArray stack = new StackInArray(5);
        stack.push(8);
        stack.push(10);
        stack.push(11);
        stack.push(13);
        stack.push(15);

        System.out.println("1. Size of stack after push operations: "+stack.size());

        System.out.print("2. pop elements from stack : ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println("\n3. Size of stack After pop operations: "+stack.size());
    }
}
