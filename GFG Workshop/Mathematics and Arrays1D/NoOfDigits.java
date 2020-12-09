/**
 * NoOfDigits
 */
public class NoOfDigits {
    public static void main(String[] args) {
        int N = 123456789; 
        int digits = (int) Math.floor(Math.log10(N)) + 1;
        System.out.println(digits);
    }
}