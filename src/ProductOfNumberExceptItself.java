public class ProductOfNumberExceptItself {
    public static void main(String args[])
    {
        int arr[]={7,3,1,4};
        arr=productOfArray(arr);
        for(int a: arr)
            System.out.print(a+" ");
    }

    private static int[] productOfArray(int[] arr) {
        int productExcept[]=new int[arr.length];
        productExcept[0]=1;
        for(int i=1; i<arr.length; i++)
            productExcept[i]=arr[i-1]*productExcept[i-1];
        int prodSoFar=1;
        for(int i=arr.length-1; i>=0; i--)
        {
            productExcept[i]*=prodSoFar;
            prodSoFar*=arr[i];
        }
        return productExcept;

    }
}
