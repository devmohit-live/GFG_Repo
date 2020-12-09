class MixJury {
    static int micsandjury(int N, int M, int[] teams) {
        int l = 1, r = 1000000000;
        int fans = 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int groups = 0;
            int i;

            for (i = 0; i < M; i++) {
                if (teams[i] % mid != 0)
                    groups += teams[i] / mid + 1;
                else
                    groups += teams[i] / mid;
            }
            if (groups > N) {
                l = mid + 1;
            } else {

                fans = mid;
                r = mid - 1;
            }
        }
        return fans;
    }

}