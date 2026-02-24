package Lab3;

public class Lab3_new 
{
    private Node head;
    private class Node
    {
        private int data;
        private Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public Node newList()
    {
        Node new_node = null;
        return new_node;
    }      

    public int sizeList() 
    {
        Node temp = head; 
        int counter = 0;
        while (temp != null) 
        { 
            counter++;
            temp = temp.next;
        }
            return counter;
    }
        
    public void displayList()
    {
       Node temp = head;

       while(temp != null)
       {
           System.out.print(temp.data+" ");
           temp = temp.next;
       }
        System.out.println("\n");
    }
    public void addNodeHead(int Node_head)
    {

       Node new_node = new Node(Node_head);
       new_node.next = head;
       head = new_node;
       System.out.println("The node " +Node_head+ " added successfully into the head.");
    }  
    
    public void addNodeQueue(int Node_queue )
    {
        Node N_node = new Node(Node_queue);
        if(head == null)
        {
            head = N_node;
            return;
        }
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = N_node;
        System.out.println("The node " +Node_queue+ " added successfully into the list.");

    }
    
    public void delNodeHead()
    {
       if(head == null)
       {
           return ;
       }
       Node temp = head;
       head = head.next;
       temp.next = null;
       System.out.println("The value "+temp.data+" has been removed successfully");
   }

    public void delNodeQueue ()
    {
        Node temp = head;
        Node previous = null;
        while(temp.next != null)
        {
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
        System.out.println("The value "+temp.data+" has been removed successfully");
    }

    public void insertNodePos(int Node_pos, int position) 
    {

        Node node = new Node(Node_pos);

       if(position == 0)
       {
            node.next = head;
            head = node;
       }
        else
       {
            Node current = head;
            for(int i=0; i < position - 1; i++)
            {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;

        }
       System.out.println("The value "+Node_pos+" has been added successfully");
    }
    public void delNodePos(int del_position)
    {

       if (head == null)
           return;

       Node temp = head;

       if (del_position == 0) 
       {
           head = temp.next; 
           return;
       }

       for (int i = 0; temp != null && i < del_position - 1;i++)
           temp = temp.next;

       if (temp == null || temp.next == null)
           return;

       Node next = temp.next.next;

       temp.next  = next; 
       System.out.println("The data of position "+del_position+" has been removed successfully");
    }



   public static void main(String[] args) 
   {
       Lab3_new list = new Lab3_new();

       list.addNodeHead(13);
       list.addNodeHead(10);
       list.addNodeHead(9);
       list.addNodeHead(7);
       list.displayList();
       
       list.addNodeQueue(25);
       list.addNodeQueue(27);
       list.addNodeQueue(22);
       list.addNodeQueue(6);
       list.displayList();
       
       list.delNodeHead();
       list.displayList();
       
       list.delNodeQueue();
       list.displayList();

       list.insertNodePos(24, 2);
       list.displayList();

       list.delNodePos(2);
       list.displayList();
       
       System.out.println("The size of the list:"+list.sizeList());
    }   
}
