package lab4;


 class Node<E> {
    
    E data;
    Node<E> next;
    public Node(E data){
        this.data = data;
        next = null;
    }
    
    @Override
    public String toString(){
        return data+ " ";
    }
}
