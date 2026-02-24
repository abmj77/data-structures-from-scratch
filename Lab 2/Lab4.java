public class Lab4{
    
    private Node head;
    private Node tail;
    private class Node{

        int data;
        Node next;
        Node previous;

        public Node(int data){
            
            this.data = data;
            next = null;
            previous = null;
        }
    }
    
    public Lab4(){
        
        head = null;        
    }
    public void displayList(){
        
       Node temp = head;
       do{
           System.out.print(temp.data);
           temp = temp.next;
       }while(temp != head);
       
       System.out.println("\n");
    }
    
    public void addElementFront(int element){
        Node node = new Node(element);
        node.next = head;
        node.previous = null;
        if(head == null){
            
            tail = node;
        }
        else{
            head.previous = node;
        }
        head = node;
    }
    
    public void addElementBetween(int letter, int newElement){
        
        Node Fnode = new Node(newElement);
        Node temp = head;

        while (temp.next != head && temp.data != letter){
            
            temp = temp.next;
        }
        
        if (temp == head){
            
            return;
        }
        
        else{
            
            Fnode.next = temp.next;
            Fnode.previous = temp;
            temp.next = Fnode;
            Fnode.next.previous = Fnode;

        }
    }
    
    public void addElementEnd(int element){
        
        Node node = new Node(element);
     
        if(head == null){
            
           head=tail=node;
            return;
        }
        tail.next = node;
        node.previous = tail;
        
        tail = node;
    }
    
    public void deleteElement(int letter){
        
        Node temp = head;

        while (temp != head && temp.data != letter){
            
            temp = temp.next;
        }
        
        if (temp == null){
            
            return;
        }
        
        else{
            
            temp.previous.next = temp.next;
            temp.next.previous = temp.previous;
        }
    }

    public static void main(String[] args){
        
        Lab4 l = new Lab4();
        //Adding elements to the list
        l.addElementFront(1);//Suppose that A = 1
        l.addElementEnd(2);//Suppose that B = 2
        l.addElementEnd(3);//Suppose that C = 3
        l.addElementEnd(4);//Suppose that D = 4
        l.addElementEnd(5);//Suppose that E = 5
        
        //Add the element F after the element C
        l.addElementBetween(3, 6);//Suppose that F = 6
        
        //Delete the element E
        l.deleteElement(5);
        
        //Implement the function display
        l.displayList();
    }
}