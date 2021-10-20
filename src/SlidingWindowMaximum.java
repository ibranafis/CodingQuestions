class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxleft[]=new int[nums.length];
        int maxright[]=new int[nums.length];
        maxleft[0]=nums[0];
        maxright[nums.length-1]=nums[nums.length-1];
        
        for(int i=1; i<nums.length; i++)
        {
            maxleft[i]= (i%k==0) ? nums[i] : Math.max(maxleft[i-1], nums[i]);
            int j=nums.length-i-1;
            maxright[j]= (j%k==0) ? nums[j] :Math.max(maxright[j+1], nums[j]);
        }
        
        int slidingmax[]=new int[nums.length-k+1];
        for(int i=0, j=0; i<=nums.length-k; i++)
        {
            slidingmax[j++]=Math.max(maxright[i],maxleft[i+k-1]);
        }
        return slidingmax;
    }
}