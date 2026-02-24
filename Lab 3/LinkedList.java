package lab4;
public class LinkedList  implements List<E>{
    private Node<E> head;
    
    
    public E getHead()
    {
        if(!empty())
            return head.data;
         return null;
    }
    
    public LinkedList() {
         head = null;
    }
    @Override
    public void addFront(E x) {
         Node<E> node = new Node<>(x);
         node.next = head;
         head = node;
         
    }
    
    @Override
    public boolean empty() {
     if(head == null){
            return true;
        }else{
            return false;
        }
    }

    
    @Override
    public E removeFront() {
         if(empty()){
            System.out.println("list is empty");
            return null;
        }else{
            Node<E> temp = head;
            head = head.next;
            temp.next = null;
            return temp.data;
           
         }
    } 
    
}
