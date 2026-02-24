package Lab6;

public class Queue implements QueueADT<E> {
    private int front, rear;
    private E data[];
    public Queue(int size){
        data = new E[size];
        front = rear=-1;
    }
 
    @Override
    public E dequeue(){
        E e;
        if(isEmpty()){
           System.out.println("Queue is empty");
           e = null;
       }else{
            e = data[front];
           if(front == rear){
               front = rear=-1;
           }else{
               front = (front+1) % data.length;
           }
       }
       return e;
    }

    @Override
    public void enqueue(E x) {
        if(full()){
            System.out.println("Queue is full");
            
        }else{
            if (front==-1)
                front=0;
            rear = (rear+1) % data.length;
            data[rear] = x;
        }
   }
    @Override
    public boolean full(){
        return (front == (rear+1) % data.length);
   }

    @Override
    public boolean isEmpty(){
        return (front==-1);
    }
}
 class TestQueue {
    public static void main(String[] args) {
        Queue Q = new Queue(9);
        System.out.println(Q.isEmpty());
        
        for(int i = 1; i < 9; i++){
            E value = new E(i);
            Q.enqueue(value);
            if(i%3==0)
                Q.dequeue();
        }
        while(!Q.isEmpty()){
            System.out.println(Q.dequeue().getValue());
        }
    }
}