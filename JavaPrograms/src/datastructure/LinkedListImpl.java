package datastructure;

class Node1
{
    int data  ;
    Node1 next;


    public Node1()
    {

    }
    public  Node1(int data)
    {
        this.data = data;
        this.next = null;

    }
}

public class LinkedListImpl {

    Node1 head;
    public LinkedListImpl(Node1 head)
    {
       this.head = head;
    }
    public  void insertAtEnd(int data)
    {

        Node1 n = new Node1(data);
        Node1 curr = head ;
            if(head == null)
            {
                head = n;
            }
            else{
                while(curr.next!=null)
                {
                    curr = curr.next;
                }
                curr.next = n;
            }
    }

    public  void insertAtStart(int data)
    {

        Node1 n = new Node1(data);

        if(head == null)
        {
            head =n;
        }
        else
        {
            n.next = head;
            head = n;
        }
    }

    public  void insertAtAfter(int insertAfter ,int data )
    {

        Node1 n = new Node1(data);
         Node1 curr = head;
         while(curr.data == insertAfter)
         {
             n.next = curr.next;
             curr.next = n;
             break;
         }
         curr = curr.next;
    }

    public  Node1 deleteAtEnd()
    {

        Node1 curr = head;
        if(curr == null || curr.next == null)
        {
            head = null ;
            return curr;
        }
        Node1  nextNode = curr.next;
        while(curr.next!=null)
        {
            if(nextNode.next == null)
            {
                curr.next = null;
            }
            curr = nextNode;
            nextNode = nextNode.next;
        }
        return curr;
    }

    public  Node1 deleteAtStart()
    {

        if(head == null)
        {
            return  null;
        }
        else
        {
            Node1 toDelete = head;
            head = head.next;
            return toDelete;
        }
    }

    public  Node1 toDeleteAfter(int deleteAfter)
    {

        Node1 curr = head;
        Node1 toDelete = null;
        while(curr!=null)
        {
            if(curr.data == deleteAfter && curr.next!=null)
            {
                toDelete = curr.next;
                curr.next = toDelete.next;
                break;
            }
            curr = curr.next;
        }
        return toDelete;
    }

    public  Node1 toDeleteStart()
    {

        Node1 curr = head;
        if(curr == null || curr.next == null){
            head = null;
            return curr;
        }
        else{
            Node1 toDelete = head;
            head = head.next;
            return toDelete;
        }
    }

    public void display()
    {

        Node1 curr = head ;
        while(curr!=null)
        {
            System.out.println("Elements in List"+ curr.data);
            curr= curr.next;
        }
    }
    public static void main (String args[])
    {
      LinkedListImpl linkedList = new LinkedListImpl(new Node1(2));

        linkedList.insertAtStart(3);
        System.out.println("head node and start ");
        linkedList.display();

        linkedList.insertAtAfter(3 , 8);
        linkedList.insertAtAfter(3 , 6);
        System.out.println("Prepare after 6 and 8");
        linkedList.display();
        linkedList.insertAtEnd(9);
        System.out.println("insert At End");
        linkedList.display();
        linkedList.deleteAtEnd() ;
        System.out.println("delete At End");
        linkedList.display();
        linkedList.toDeleteAfter(6);
        System.out.println("delete After 6");
        linkedList.display();
        linkedList.deleteAtStart();
        System.out.println("delete At start");
        linkedList.display();
        System.out.println("***Final Elements ******");
        linkedList.display();

    }


}
