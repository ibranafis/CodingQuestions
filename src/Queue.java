import java.util.Iterator;
import java.util.Stack;

public class Queue {
    //Implement Queue using Stack
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    public Queue()
    {
        s1=new Stack<>();
        s2=new Stack<>();
        front=0;
    }
    public void insert(int x)
    {
        if(s1.isEmpty())
            front=x;
        s1.push(x);
    }
    public int remove()
    {
        if(s2.isEmpty())
        {
            while(!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    public int peek()
    {
        if(!s2.isEmpty())
            return s2.peek();
        return front;
    }
    public void display()
    {
        Iterator<Integer> it=s2.iterator();
        while(it.hasNext())
            System.out.print(it.next()+" ");
    }
    public static void main(String args[])
    {
        Queue ob=new Queue();
        ob.insert(2);
        ob.insert(5);
        ob.insert(23);
        System.out.println(ob.remove());
        System.out.println(ob.peek());
        ob.display();
    }
}