/**
 * NoOfDigits
 */
public class NoOfDigits {
    public static void main(String[] args) {
        int N = 123456789;
        double digits = Math.log10(N);
        System.out.println((int) Math.floor(digits) + 1);
    }
}