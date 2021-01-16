/**
 * Rearrange the elements in O(1) extra space Given an array arr[] of size N
 * where every element is in the range from 0 to n-1. Rearrange the given array
 * so that arr[i] becomes arr[arr[i]].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: N = 2 arr[] = {1,0} Output: 0 1
 * 
 * Explanation: arr[arr[0]] = arr[1] = 0. arr[arr[1]] = arr[0] = 1.
 * 
 * 
 * Example 2:
 * 
 * Input: N = 5 arr[] = {4,0,2,1,3} Output: 3 4 2 0 1
 * 
 * Explanation: arr[arr[0]] = arr[4] = 3. arr[arr[1]] = arr[0] = 4. and so on.
 */

public class Rearrange {
    // Function to rearrange the elements
    // arr: input array
    // n: size of array
    static void arrange(long arr[], int n) {
        for (int i = 0; i < n; i++) {
            /*
             * Mathematical way of storing two numbers in a single one => define the
             * range(limit) of the numbers a,b are two numbers the store res = a%n + n*b now
             * to get a do => res%n; as b is the multiple of b so doing mod will vanish b to
             * get b => res/n ; as a is less than n so a/n =0 and b is multiple of n so
             * n*b/n = b
             * 
             */
            arr[i] += (arr[(int) arr[i]] % n) * n; // this stores both old and new values in the a[i]
        }

        for (int i = 0; i < n; i++) {
            arr[i] /= n; // since we have to get the new(updated) values so we do '/'
            // if we wanted old values(if) then we would be doing '%'
        }
    }
}