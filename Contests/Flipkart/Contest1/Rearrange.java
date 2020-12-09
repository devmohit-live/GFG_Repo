class Rearrange {
    public String smallestnum(String N) {

        int[] a = new int[15];
        int i;
        for (i = 0; i < 15; i++) {
            a[i] = 0;
        }
        int n = N.length();
        for (i = 0; i < n; i++) {
            int tmp = N.charAt(i) - '0';
            a[tmp]++;
        }

        i = 1;
        while (a[i] == 0)
            i++;

        String fans = "";

        fans += String.valueOf(i);

        a[i]--;
        for (i = 0; i < 10; i++) {
            if (a[i] > 0) {
                while (a[i] > 0) {

                    fans += String.valueOf(i);
                    a[i]--;
                }
            }
        }
        return fans;

    }
}