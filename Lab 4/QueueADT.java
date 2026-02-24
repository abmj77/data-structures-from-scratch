package Lab6;

   public interface QueueADT <E> {
        E dequeue();
        void enqueue(E x);
        boolean full();
        boolean isEmpty();
    }