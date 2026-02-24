package Lab6;

class Stack implements StackADT<E> {
    private Node <E> head;
    
    @Override
    public void push(E x) {
       
         Node <E> node = new Node <>(x);
         node.next = head;
         head = node;
    }
    @Override
    public E pop() {
        if(isEmpty()){
            System.out.println("empty stack!!!");
            return null;
            
        }else{
            Node <E> temp = head;
            head = head.next;
            temp.next = null;
            return temp.data;
        }
    }
    @Override
    public E top(){
        return getHead();
    }

    @Override
    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }
    public E getHead()
    {
        if(!isEmpty())
            return head.data;
        return null;
    }
}
public class Reverse {
    public static void main(String[] args){
        Queue queue = new Queue(9);
        Stack stack = new Stack();
        for(int i = 1; i <= 9; i++){
               E value = new E(i);
               queue.enqueue(value);
        }
        while (!queue.isEmpty()){
            stack.push(queue.dequeue());  
        }
        while (!stack.isEmpty()){
            queue.enqueue((E) stack.top());
            stack.pop();
        }
        while (!queue.isEmpty()){
            System.out.print(queue.dequeue().getValue()+ ", ");
           
        }
    }
}