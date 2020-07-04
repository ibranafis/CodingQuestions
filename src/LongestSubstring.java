import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    //Find length of longest substring without repeating characters
    public static void main(String args[])
    {
        String s="abcabcbb";
        System.out.println(findLength(s));
    }

    private static int findLength(String s) {
        Set<Character> set=new HashSet<>();
        int i=0, j=0, ans=0, len=s.length();
        while(i<len && j<len)
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j++));
                ans=Math.max(ans, j-i);
            }
            else
                set.remove(s.charAt(i++));
        }
        return ans;
    }
}