public class ContainerWithMostWater {
    public static void main(String args[])
    {
        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println(finMaxAmtofWater(arr));
    }

    private static int finMaxAmtofWater(int[] arr) {
        int left=0, right=arr.length-1;
        int maxArea=0;
        while(left<right)
        {
            maxArea=Math.max(maxArea, Math.min(arr[left],arr[right])*(right-left));
            if(arr[left]<arr[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}