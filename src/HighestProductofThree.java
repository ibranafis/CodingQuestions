public class HighestProductofThree {
    public static void main(String args[])
    {
        int arr[]={1,-10, -11,9,8,6,3,7};
        System.out.println(maxProduct(arr)); //504
    }

    private static int maxProduct(int[] arr) {
        //In each iteration, keep track of maxProduct of 3, of 2, minProduct of 2, max, min
        int maxProdof3=arr[0]*arr[1]*arr[2];
        int maxProdof2=arr[0]*arr[1];
        int minProdof2=maxProdof2;
        int max=Math.max(arr[0],arr[1]);
        int min=Math.min(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++)
        {
            int curr=arr[i];
            maxProdof3=Math.max(maxProdof3, Math.max(maxProdof2*curr, minProdof2*curr));
            maxProdof2=Math.max(maxProdof2, Math.max(max*curr, min*curr));
            minProdof2=Math.min(minProdof2, Math.min(min*curr, max*curr));
            max=Math.max(max, curr);
            min=Math.min(min, curr);
        }
        return maxProdof3;
    }
}
