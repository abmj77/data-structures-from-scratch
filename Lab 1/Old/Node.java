package Lab3;

class Node<E>
{
    E data;
    Node<E> next;
    public Node(E data)
    {
        this.data = data;
        next = null;
    }
    public String toString()
    {
        return data + " ";
    }
 }