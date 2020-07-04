import java.util.Arrays;

public class NetworkDelayTime {

    /*Given times: a list of directed edge times[i]=(u,v,w) where w- time for a signal to travel from u to v. Now
    we send a signal from a node k. How long will it take for all nodes to receive this signal?
     */

    public static void main(String args[]) {
        int arr[][] = {{2,1,1}, {2, 3, 1}, {3,4,1}};
        int n = 4, k = 2;
        System.out.println(finLeastTime(n, arr, k));
    }

    private static int finLeastTime(int n, int[][] arr, int k) {
        double time[] = new double[n];
        Arrays.fill(time, Double.POSITIVE_INFINITY);
        time[k - 1] = 0;
        for (int i = 0; i < n; i++)
        {
            double temp[]=Arrays.copyOf(time, n);
            for (int t[]: arr)
            {
                int u=t[0]-1, v=t[1]-1, w=t[2];
                temp[v]=Math.min(temp[v], time[u]+w);
            }
            time=temp;
        }
        double ans=Double.MIN_VALUE;
        for(double a: time)
            ans=Math.max(a, ans);
        return ans==Double.POSITIVE_INFINITY?-1:(int)ans;
    }
}
