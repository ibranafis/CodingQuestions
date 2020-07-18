/*      Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
        The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

        Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

        Find and return the required subarray.

        NOTE:

        If there is a tie, then compare with segments length and return segment which has maximum length.
        If there is still a tie, then return the segment with minimum starting index.


        Problem Constraints
        1 <= N <= 105
        -109 <= A[i] <= 109*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {
    public static void main(String args[])
    {
        List<Integer> A= Arrays.asList(1,2,5,-7,2,3);
        List<Integer> ans=MaxSubarray(A);
        System.out.print(ans);
    }

    private static List<Integer> MaxSubarray(List<Integer> A) {
        int start=-1, end=-1, tempStart=0, tempEnd=0;
        int sum=Integer.MIN_VALUE, tempSum=0;
        for(int i=0; i<A.size(); i++)
        {
            if(A.get(i)<0)
            {
                tempStart=i+1;
                tempEnd=i+1;
                tempSum=0;
            }
            else {
                tempSum += A.get(i);
                if (tempSum > sum) {
                    start = tempStart;
                    end = i;
                    sum = tempSum;
                } else if (tempSum == sum && ((tempEnd - tempStart) > (end - start))) {
                    start = tempStart;
                    end = i;
                    sum = tempSum;
                }
                tempEnd++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        if(start<0)
            return ans;
        for(int i=start; i<=end; i++)
            ans.add(A.get(i));
        return ans;
    }
}
