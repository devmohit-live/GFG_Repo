import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Binary
 */
public class Binary {

    static int binarySearchIterative(int arr[], int x) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) / 2);
            if (arr[mid] > x) {
                j = mid - 1;
            } else if (arr[mid] < x) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int x, int l, int r) {

        if (l <= r) {
            int mid = l + ((r - l) / 2);
            if (x == arr[mid]) {
                return mid;
            } else if (arr[mid] > x) {
                return binarySearch(arr, x, l, mid - 1);
            } else {
                return binarySearch(arr, x, mid + 1, r);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11 };
        System.out.println(binarySearchIterative(arr, 6));
        System.out.println(binarySearchIterative(arr, 11));
        System.out.println(binarySearch(arr, 6, 0, arr.length - 1));
        System.out.println(binarySearch(arr, 11, 0, arr.length - 1));

    }
}