import java.util.*;

public class FirstRepeating {

    // My approach => O(N) space = O(N) => k pairs Hashmap O(N)
    // desired => O(NlogN) space= O(N)
    static class Pair {
        int count = 0;
        int idx;

        Pair(int count, int index) {
            this.count = count;
            this.idx = index;
        }

    }

    public static int firstRepeated(int[] arr) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Pair pair = map.getOrDefault(arr[i], new Pair(0, -1));
            int count = pair.count + 1;
            int k = pair.idx == -1 ? i : pair.idx;
            map.put(arr[i], new Pair(count, k));
        }

        for (int i = 0; i < arr.length; i++) {
            Pair p = map.get(arr[i]);
            if (p.count >= 2) {
                System.out.print("First repeating element is " + arr[p.idx] + " at index ");
                return p.idx;
            }
        }

        // for(int i=0;i<arr.length;i++){
        // Pair p=map.get(arr[i]);
        // System.out.println(arr[i]+" "+p.count+" "+p.idx);
        // }

        return -1;
    }

    // approcah 2 using set
    static void printFirstRepeating(int arr[]) {
        // Initialize index of first repeating element
        int min = -1;

        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;

            else // Else add element to hash set
                set.add(arr[i]);
        }

        // Print the result
        if (min != -1)
            System.out.println("The first repeating element is " + arr[min] + "at index " + min);
        else
            System.out.println("There are no repeating elements");
    }

    // Driver method to test above method
    public static void main(String[] args) throws java.lang.Exception {
        int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
        printFirstRepeating(arr);
        System.out.println(firstRepeated(arr));

    }
}