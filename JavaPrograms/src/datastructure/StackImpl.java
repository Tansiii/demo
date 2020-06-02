package datastructure;
class Node
{
    int data;
    Node next ;
}
 class Stack1 {
 private Node top ;
    Stack1()
    {
      this.top = null;
    }

    public void push(int x)
    {
        Node n = new Node();

        if(n == null)
        {
            System.out.println("Stack Overflow");
            return;
        }

        System.out.println("Adding " + x);
        // set the data in allocated node
        n.data = x;
        // Set the .next pointer of the new node to point to the current
        // top node of the list
        n.next = top;
        // update top pointer
        top = n;
    }

    public void pop()
    {
        if(top == null)
        {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println("Removing " + top.data);
        top = top.next;
    }

    public int peek()
    {
        if(top == null)
        {
            System.out.println("stack is Empty");
            return -1;
        }
        else
        {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class StackImpl
{
    public static void main(String[] args)
    {
        Stack1 stack = new Stack1();

        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is " +  stack.peek());


        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.print("Stack is empty");
        } else {
            System.out.print("Stack is not empty");
        }
    }
}
