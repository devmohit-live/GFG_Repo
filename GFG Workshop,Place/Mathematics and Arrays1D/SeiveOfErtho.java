import java.util.*;

public class SeiveOfErtho {
    public static void main(String[] args) {
        System.out.println("Enter n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Prime number within range is ");
        boolean[] primes = primeInRange(n);
        primes[0] = false;
        ;
        primes[1] = false;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i])
                System.out.print(i + " ");
        }
    }

    public static boolean[] primeInRange(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
