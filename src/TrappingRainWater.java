public class TrappingRainWater {
    public static void main(String args[])
    {
        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(finMaxAmt(arr));
    }

    private static int finMaxAmt(int[] arr) {
        if(arr.length<3)
            return 0;
        int l=0, r=arr.length-1, ans=0;
        while(l<r && arr[l]<=arr[l+1])
            l++;
        while(l<r && arr[r]<=arr[r-1])
            r--;
        while(l<r)
        {
            int left=arr[l];
            int right=arr[r];
            if(left<=right)
                while(l<r && left>=arr[++l])
                    ans+=left-arr[l];
            else
                while(l<r && right>=arr[--r])
                    ans+=right-arr[r];
        }
        return ans;
    }
}