import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;
//O(logn)
public class findMedian {
    Queue<Integer> minHeap; //big -> ascending order
    Queue<Integer> maxHeap; //small -> descending order
    public findMedian()
    {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }

    public void add(int x)
    {
        if(minHeap.size()==maxHeap.size())
        {
            minHeap.add(x);
            maxHeap.add(minHeap.remove());
        }
        else if(minHeap.size()==maxHeap.size()-1)
        {
            maxHeap.add(x);
            minHeap.add(maxHeap.remove());
        }
    }

    public int findMedian()
    {
        if(maxHeap.size()==0)
            return 0;
        else if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2;
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        findMedian ob=new findMedian();
        ob.add(9);
        ob.add(45);
        ob.add(1);
        ob.add(89);
        System.out.print(ob.findMedian());
    }

}