package Lab3;


public class LinkedList implements List<E>
{
    private Node<E> head;
    
    public LinkedList() 
    {
        head = null;
    }
    
    //Add Element at the beginning of the list
    public void addFront(E x) 
    {
         Node<E> node = new Node<>(x);
         node.next = head;
         head = node;
    }
    
    //Add Element at the end of the list
    public void addEnd(E x) 
    {
        if (head == null)
            addFront(x);
        else 
        {
            Node<E> node = new Node<>(x);
            Node<E> p = head;
            while (p.next != null) 
            {
                p = p.next;
            }
            p.next = node;
        }
    }
    
    //Add Element after the value val in the list
    public void addMid(E val, E x) 
    {
        if (empty())
            System.out.println("empty list!!!");
        else 
        {
            Node<E> p = head;
            while (p.data != val && p.next != null) 
            {
                p = p.next;
            }
            if (p.data != val) 
            {
                System.out.println("The list don’t contain the value " + val);
            } 
            else 
            {
                Node<E> node = new Node<>(x);
                node.next = p.next;
                p.next = node;
            }
        }
    }
    
    // Print all the elements in the list
    public void print() 
    {
        Node<E> temp = head;
        
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
         System.out.println("");
    }
    
    // Return true if the list is empty
    public boolean empty() 
    {
        if(head == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    // Remove the last element in the list
    public void removeEnd()
    {
        if(empty())
        {
            System.out.println("empty list!!!");
        }
        else
        {
            Node<E> temp = head;
            Node<E> previous = null;
            while(temp.next != null)
            {
                previous = temp;
                temp = temp.next;
            }
            previous.next = null;
            System.out.println("The last node " + temp.data + " has been deleted");
        }
    }
    
    // Remove the first element in the list
    public void removeFront() 
    {
        if(empty())
        {
            System.out.println("empty list!!!");
        }
        else
        {
            Node<E> temp = head;
            head = head.next;
            temp.next = null;
            System.out.println("The first node " + temp.data + " has been deleted");
        }
    }
    
    // Remove the element x from the list
    public void remove(E x) 
    {
        boolean flag = false;
        if (empty())
        {
            System.out.println("empty list!!!");
        }
        else if(head.data == x)
        {
            head = head.next;
            flag = true;
        }
        else
        {
            Node<E> temp = head;
            Node<E> previous = null;
            while(temp != null)
            {
                previous = temp;
                temp = temp.next;
                if(temp.data == x)
                {
                    flag = true;
                    previous.next = temp.next;
                    temp.next = null;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("The index " + x + " has been deleted");
            }
            else
            {
                System.out.println("There is not"  + x + "in this list");
            }
        }
    }
    
    // Remove all elements in the list
    public void removeAll() 
    {
        if(empty())
        {
            System.out.println("empty list!!!");
        }
        else
        {
            Node<E> temp = null;
            while (head != null) 
            {
                temp = head.next;
                head = null;
                head = temp;
            }
        }
    }
    
    // Check if the element x is in the list
    public boolean exist(E x) 
    {
        Node<E> p = head;
        while(p != null)
        {
            if(p.data == x)
            {
                return true;
            }
            p = p.next;
        }
        return false;
    } 
}