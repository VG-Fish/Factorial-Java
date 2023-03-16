import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Factorial{
    public static void main(String[] args) {
        HashMap<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();
        cache.put(BigInteger.ZERO, BigInteger.ZERO);
        cache.put(BigInteger.ONE, BigInteger.ONE);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter a positive number or enter -1 to quit: ");
            BigInteger input = sc.nextBigInteger();
            System.out.println();
            if(input.equals(new BigInteger("-1"))){
                System.out.println("Exiting...");
                sc.close();
                break;
            } else if(input.signum() == -1){
                System.out.println("Enter a positive number.");
                continue;
            }
            System.out.println(factorial(input, cache));
        }
    }
    public static BigInteger factorial(BigInteger n, HashMap<BigInteger, BigInteger> cache) {
        if(cache.containsKey(n)){
            return (BigInteger) cache.get(n);
        } 
        BigInteger temp = n.multiply(factorial(n.subtract(BigInteger.ONE), cache));
        cache.put(n, temp);
        return temp;
    }
}
