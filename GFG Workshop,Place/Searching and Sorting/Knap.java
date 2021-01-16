import java.util.*;

public class Knap {
    static class Item implements Comparable<Item> {
        int value, weight;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int compareTo(Item o) {
            double a = (this.value * 1.0) / this.weight;
            double b = (o.value * 1.0) / o.weight;
            if (a > b)
                return -1; // descending
            if (b > a)
                return 1;
            else
                return 0;
        }
    }

    public static double fractionalKnapsack(int W, Item[] arr, int n) {
        Arrays.sort(arr);
        double val = 0;
        for (int i = 0; i < arr.length; i++) {
            if (W == 0)
                break;

            if (W - arr[i].weight >= 0) {
                val += arr[i].value;
                W -= arr[i].weight;
            } else {
                val += W * (arr[i].value * 1.0 / arr[i].weight);
                break;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        int N1 = 3, W1 = 50;
        int values1[] = { 60, 100, 120 };
        int weight1[] = { 10, 20, 30 };

        // int N = 2, W = 50;
        // int values[] = { 60, 100 };
        // int weight[] = { 10, 20 };
        int N = 84, W = 87;
        int weight[] = { 16, 36, 43, 22, 28, 10, 27, 27, 37, 19, 30, 31, 24, 36, 3, 9, 18, 7, 43, 24, 20, 38, 25, 21,
                27, 31, 24, 21, 32, 26, 28, 6, 30, 8, 46, 46, 18, 15, 1, 9, 29, 35, 2, 50, 11, 19, 13, 37, 40, 21, 29,
                2, 3, 43, 7, 31, 42, 40, 20, 30, 18, 22, 26, 28, 7, 4, 16, 34, 25, 22, 30, 20, 19, 16, 50, 24, 46, 2, 6,
                39, 29, 1, 1, 15 };
        int[] values = { 78, 94, 87, 50, 63, 91, 64, 41, 73, 12, 68, 83, 63, 68, 30, 23, 70, 94, 12, 30, 22, 85, 99, 16,
                14, 92, 57, 63, 97, 6, 85, 37, 47, 14, 25, 83, 15, 35, 44, 88, 77, 89, 4, 55, 33, 77, 40, 27, 95, 96,
                35, 68, 98, 18, 53, 2, 87, 66, 45, 41, 32, 98, 82, 10, 68, 98, 87, 7, 20, 29, 33, 4, 71, 9, 41, 97, 19,
                47, 22, 80, 65, 42, 94, 35 };

        Item item1[] = new Item[N1];
        Item item[] = new Item[N];

        for (int i = 0; i < N1; i++) {
            item1[i] = new Item(weight1[i], values1[i]);
        }
        for (int i = 0; i < N; i++) {
            item[i] = new Item(weight[i], values[i]);
        }

        System.out.println(fractionalKnapsack(W1, item1, N1));
        System.out.println(fractionalKnapsack(W, item, N));
    }
    // 78 16 94 36 87 43 50 22 63 28 91 10 64 27 41 27 73 37 12 19 68 30 83 31 63 24
    // 68 36 30 3 23 9 70 18 94 7 12 43 30 24 22 20 85 38 99 25 16 21 14 27 92 31 57
    // 24 63 21 97 32 6 26 85 28 37 6 47 30 14 8 25 46 83 46 15 18 35 15 44 1 88 9
    // 77 29 89 35 4 2 55 50 33 11 77 19 40 13 27 37 95 40 96 21 35 29 68 2 98 3 18
    // 43 53 7 2 31 87 42 66 40 45 20 41 30 32 18 98 22 82 26 10 28 68 7 98 4 87 16
    // 7 34 20 25 29 22 33 30 4 20 71 19 9 16 41 50 97 24 19 46 47 2 22 6 80 39 65
    // 29 42 1 94 1 35 15
}
/*
 * class ItemComp implements Comparator<Item> { public int compare(Item t,Item
 * o) { double a = (t.value * 1.0) / t.weight; double b = (o.value * 1.0) /
 * o.weight; if (a > b) return -1; // descending if (b > a) return 1; else
 * return 0; } }
 * 
 * class solve{ double fractionalKnapsack(int W, Item arr[], int n) {
 * Arrays.sort(arr,new ItemComp()); double val = 0; for (int i = 0; i <
 * arr.length; i++) { if (W == 0) break;
 * 
 * if (W - arr[i].weight >= 0) { val += arr[i].value; W -= arr[i].weight; } else
 * { val += W * (arr[i].value * 1.0 / arr[i].weight); break; } } return val; } }
 */