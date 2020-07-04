public class ValidPickupAndDelivery {
    public static void main(String args[])
    {
        int n=2;
        System.out.println(findValid(n));
    }

    private static int findValid(int n) {
        long modulo=(long)(1e9+7);
        long ans=1;
        for(int i=2; i<=n; i++)
        {
            int spaceNum=(i-1)*2+1;
            ans*=spaceNum*(spaceNum+1)/2;
            ans%=modulo;
        }
        return (int)ans;
    }
}