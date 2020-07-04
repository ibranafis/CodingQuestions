import java.util.Arrays;

public class CheapestFlights {
    /* There are n cities connected y m flights. Each flight starts from u and arrives at v with a price w.
    Find cheapest flight from src to dst with upto k stops
     */
    public static void main(String args[]) {
        int arr[][] = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3, src = 0, dst = 2, k = 1;
        System.out.println(finCheapestAmt(n, arr, src, dst, k));
    }

    private static int finCheapestAmt(int n, int[][] graph, int src, int dst, int k) {
        int prices[] = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int temp[] = Arrays.copyOf(prices, n);
            for (int f[] : graph) {
                int curr = f[0], next = f[1], price = f[2];
                if (prices[curr] == Integer.MAX_VALUE)
                    continue;
                temp[next] = Math.min(temp[next], prices[curr] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}