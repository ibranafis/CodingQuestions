public class MaximumSubArray {
    //Find the contiguous subarray with largest sum
    public static void main(String args[])
    {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findMax(arr)); //4,-1,2,1=6
    }

    private static int findMax(int[] arr) {
        int maxSoFar=arr[0];
        int maxEndingHere=arr[0];
        for(int n=1; n<arr.length; n++)
        {
            maxEndingHere=Math.max(maxEndingHere+arr[n], arr[n]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}