package lab4;
class Stack implements StackADT<E> {
    private LinkedList list=new LinkedList();
    @Override
    public void push(E x) {
        
         list.addFront((E)x);
    }

    @Override
    public E pop() {
        if(list.empty())
        {
            System.out.println("stack is empty");
            return null;
        }else{
            return (E) list.removeFront();
        }
       
    }

    @Override
    public E top() {
        if (!isEmpty()){
             return (E) list.getHead();
        }else{
            return null;
        }
       
    }

    @Override
    public boolean isEmpty() {
        if(list.getHead() == null){
            return true;
        }else{
            return false;
        }
    }
     
}
