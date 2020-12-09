class DigitsInFactorial {
    public int digitsInFactorial(int N) {
        if (N <= 1)
            return 1;

        double d = 0;
        for (int i = 2; i <= N; i++) {
            d += Math.log10(i);
        }
        return (int) Math.floor(d) + 1;
    }
}
