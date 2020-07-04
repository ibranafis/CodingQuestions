public class LengthofLPS {
    //Find length of longest palindromic sustring in O(n) time using Manacher's algorithm
    public static void main(String args[])
    {
        String s="abcbaabcbb";
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        s=sb.toString();
        System.out.println(findLength(s));
    }

    private static int findLength(String s) {
        int i, c=0, r=0, maxLen=0;
        int n=s.length();
        int P[]=new int[n];
        for(i=0; i<n; i++)
        {
            int iMirror=(2*c)-i;
            if(i<r)
                P[i]=Math.max(r-i, P[iMirror]);
            int a=i+(1+P[i]);
            int b=i-(1+P[i]);
            while(a<n && b>=0 && s.charAt(a)==s.charAt(b))
            {
                P[i]++;
                a++;
                b--;
            }
            if(i+P[i]>r)
            {
                c=i;
                r=i+P[i];
                if(P[i]>maxLen)
                    maxLen=P[i];
            }
        }
        return maxLen-1;
    }
}
