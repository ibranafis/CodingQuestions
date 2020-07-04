import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public static void main(String args[])
    {
        int arr[]={0,1,1,2,2,2,3,4,4,4};
        int target=3;
        int ans[]=topK(arr, target);
        for(int a: ans)
            System.out.print(a+" "); //2,4,1
    }

    private static int[] topK(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int a: arr)
            map.put(a, map.getOrDefault(a,0)+1);
        Queue<Integer> heap=new PriorityQueue<>(
                (num1, num2)->(map.get(num1)-map.get(num2)));
        for(int n: map.keySet())
        {
            heap.add(n);
            if(heap.size()>k)
                heap.poll();
        }
        int ans[]=new int[k];
        for(int i=k-1; i>=0; i--)
            ans[i]=heap.poll();
        return ans;
    }
}