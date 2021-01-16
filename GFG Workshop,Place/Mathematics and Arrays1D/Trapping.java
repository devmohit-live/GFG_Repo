// public class Trapping {

//     // function to find the trapped water in between buildings
//     // arr: input array
//     // n: size of array
//     static int trappingWater(int arr[], int n) {
//         int leftmax[] = new int[n];
//         int rightmax[] = new int[n];
//         leftmax[0] = arr[0];
//         rightmax[n - 1] = arr[n - 1];

//         for (int i = 1; i < n; i++) {
//             leftmax[i] = Math.max(leftmax[i - 1], arr[i - 1]);
//         }

//         for (int i = n - 2; i >= 0; i--) {
//             rightmax[i] = Math.max(rightmax[i + 1], arr[i + 1]);
//         }
//         int water = 0;
//         for (int i = 0; i < n; i++) {
//             // System.out.println(leftmax[i]+" "+rightmax[i]+" "+arr[i]);
//             // System.out.println(Math.min(leftmax[i],rightmax[i])-arr[i]);
//             int units = Math.min(leftmax[i], rightmax[i]) - arr[i];
//             if (units > 0)
//                 water += units;
//         }
//         return water;
//     }
// }

public class Trapping {

    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) {
        int leftmax[] = new int[n];
        int rightmax[] = new int[n];
        leftmax[0] = arr[0];
        rightmax[n - 1] = arr[n - 1];

        int leftymax = arr[0];
        int rightymax = arr[n - 1];

        // int max = a[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], arr[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], arr[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            leftymax = Math.max(leftymax, arr[i]);
            System.out.print(rightymax + " after");
            rightymax = Math.max(rightymax, arr[n - i - 1]);
            System.out.println(rightymax + " arr" + rightmax[i]);

            // System.out.println(leftmax[i] + " " + leftymax + " " + rightmax[i] + " " +
            // rightymax);
            // System.out.println(Math.min(leftmax[i],rightmax[i])-arr[i]);

            int units = Math.min(leftmax[i], rightmax[i]) - arr[i];
            if (units > 0)
                water += units;
        }
        return water;
    }

    public static void main(String[] args) {
        int n = 7;
        int arr[] = { 8, 8, 2, 4, 5, 5, 1 };
        trappingWater(arr, n);
    }
}
