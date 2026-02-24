package lab4;
public interface StackADT<E>{
    void push(E x);
    E pop();
    E top();
    boolean isEmpty();
}
