package grandfinale;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem7 {
    public static BigInteger num = BigInteger.valueOf(10);
    public static BigInteger product, e;
    public static int r;
    
    public static void schonhageStrassenMultiplication(BigInteger x, BigInteger y, int n, int m)
    {
        BigInteger linearConvolution[] = new BigInteger[n+m-1]; //declare linear convolution array with size as sum of sizes of 2 big integers -1
        for(int i=0; i<(n+m-1); i++)
            linearConvolution[i] = BigInteger.ZERO; //initialize the array with 0
        BigInteger p=x; 
        for(int i=0; i<m; i++)
        {
            x = p;
            for(int j=0; j<n; j++)
            {
                e = x.remainder(num).multiply(y.remainder(num)); //initialize the variable e as remainder of 1st integer divided by 10 multiplied by remainder of 2nd integer divided by 10
                linearConvolution[i+j] = linearConvolution[i+j].add(e); //add the value of e to linear convolution array
                x = x.divide(num); 
            }
            y = y.divide(num);
        }
        product = BigInteger.ZERO;
        int nextCarry=0, base=1;
        BigInteger nC = BigInteger.valueOf(nextCarry);
        BigInteger v;
        BigInteger base1 = BigInteger.valueOf(base);
        
        for(int i=0; i<n+m-1; i++)
        {
            linearConvolution[i] = linearConvolution[i].add(nC); //add the next carry to linear convolution
            v = base1.multiply(linearConvolution[i].remainder(num)); 
            product = product.add(v); 
            nC = linearConvolution[i].divide(num);
            base1 = base1.multiply(num); 
        }
        System.out.println("The Product of the numbers is: " + product);
        
    }
    public static void main(String args[])
    {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the numbers:");
            BigInteger a = input.nextBigInteger(); //input 1st big number
            BigInteger b = input.nextBigInteger(); //input 2nd big number
            int n = a.bitCount(); //calculate length of 1st big integer
            int m = b.bitCount(); //calculate length of 2nd big integer
            schonhageStrassenMultiplication(a, b, n, m);
        }
    }
}
