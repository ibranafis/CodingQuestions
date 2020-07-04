import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPermutations {
    public static void main(String args[])
    {
        int arr[]={1,2,3,4};
        String st="jep";
        List<List<Character>> ans=new ArrayList<>();
        ans=permute(st.toCharArray());
        System.out.println(ans.size());
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+" ");
    }

    private static List<List<Character>> permute(char[] arr) {
        List<List<Character>> ans=new ArrayList<>();
        Arrays.sort(arr);
        backtrack(ans, new ArrayList<>(), arr);
        return ans;
    }

    private static void backtrack(List<List<Character>> ans, List<Character> temp, char[] arr) {
        if(temp.size()==arr.length)
            ans.add(new ArrayList<>(temp));
        else
        {
            for(int i=0; i<arr.length; i++)
            {
                if(temp.contains(arr[i]))
                    continue;
                temp.add(arr[i]);
                backtrack(ans, temp, arr);
                temp.remove(temp.size()-1);
            }
        }
    }
}
