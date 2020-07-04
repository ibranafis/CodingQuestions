import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    //Implement stack using Queue
    Queue<Integer> q;
    public Stack()
    {
        q=new LinkedList<>();
    }
    public void push(int x)
    {
        q.add(x);
        int size=q.size();
        while(size>1)
        {
            q.add(q.remove());
            size--;
        }
    }
    public int pop()
    {
        int top=q.peek();
        q.remove();
        return top;
    }
    public int top()
    {
        return q.peek();
    }
    public void display()
    {
        Iterator<Integer> itr=q.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }
    public static void main(String args[])
    {
        Stack ob=new Stack();
        ob.push(1);
        ob.push(9);
        ob.push(23);
        System.out.println(ob.top());
        System.out.println(ob.pop());
        System.out.println(ob.top());
        ob.display();
    }
}
