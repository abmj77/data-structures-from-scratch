package Lab3;

interface List<E>
{
    void addFront(E x); //Add Element at the beginning of the list
    void addEnd(E x); //Add Element at the end of the list
    void addMid(E val , E x); //Add Element after the value val in the list
    void print();// print all the elements in the list
    boolean empty();// return true if the list is empty 
    void removeEnd();// remove the last element in the list
    void removeFront();// remove the first element in the list
    void remove(E x);// remove the element x from the list
    void removeAll();// remove all elements in the list
    boolean exist(E x);// check if the element x is in the list
}