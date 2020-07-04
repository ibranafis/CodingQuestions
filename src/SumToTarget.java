import java.util.HashMap;
import java.util.Map;

public class SumToTarget {
//Given an array return indices of two numbers such that they add up to a target
    public static void main(String args[])
    {
        int arr[]={0,3,4,8,2,9};
        int target=5;
        int ans[]=findIndex(arr, target);
        for(int a: ans)
            System.out.print(a+" ");
    }

    private static int[] findIndex(int[] arr, int target) {
        Map<Integer, Integer> m=new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            int j=target-arr[i];
            if(m.containsKey(j))
                return new int[]{m.get(j),i};
            m.put(arr[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
