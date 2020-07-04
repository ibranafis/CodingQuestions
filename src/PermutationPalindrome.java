import java.util.HashSet;
import java.util.Set;

public class PermutationPalindrome { //Check whether the permutayion of a string is palindrome
    public static void main(String args[])
    {
        String st="maddamk";
        System.out.println(isPalindrome(st));
    }

    private static boolean isPalindrome(String st) {
        Set<Character> s=new HashSet<>();
        for(char ch: st.toCharArray())
        {
            if(s.contains(ch))
                s.remove(ch);
            else
                s.add(ch);
        }
        return s.size()<=1;
    }
}
