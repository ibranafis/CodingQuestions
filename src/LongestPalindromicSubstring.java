public class LongestPalindromicSubstring {
    public static void main(String args[])
    {
        String s="abcbaabcbb";
        System.out.println(findSubstring(s));
    }

    private static String findSubstring(String s) {
        int curr=0, start=-1;
        String ans="";
        for(int i=0; i<s.length(); i++)
        {
            if(isPalindrome(s,i-curr-1,i))
            {
                start=i-curr-1;
                ans=s.substring(start,i+1);
                curr+=2;
            }
            else if(isPalindrome(s, i-curr, i))
            {
                start=i-curr;
                ans=s.substring(start, i+1);
                curr+=1;
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String str, int s, int e)
    {
        if(s<0)
            return false;
        while(s<e)
            if(str.charAt(s++)!=str.charAt(e--))
                return false;
        return true;
    }
}