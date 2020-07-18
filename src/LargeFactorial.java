public class LargeFactorial {
    public static void main(String args[])
    {
        System.out.println(factorial(89));

    }

    private static String factorial(int n) {
        int ans[]=new int[500];
        ans[0]=1;
        int size=1;
        int carry, prod, i;
        String result="";
        for(i=2; i<=n; i++)
        {
            carry=0;
            for(int a=0; a<size; a++)
            {
                prod=ans[a]*i+carry;
                ans[a]=prod%10;
                carry=prod/10;
            }
            while(carry!=0)
            {
                ans[size]=carry%10;
                carry/=10;
                size++;
            }
        }
        for(i=size-1; i>=0; i--)
            result+=ans[i];
        return result;
    }
}
