import java.util.ArrayList;
import java.util.List;

public class L5 {

    static int rec(int arr[], int n, int ind, int prev_index) {

        // base condition
        if (ind == n)
            return 0;

        // not take
        int len = rec(arr, n, ind + 1, prev_index);

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            // take
            len = Math.max(len, 1 + rec(arr, n, ind + 1, ind));
        }

        return len;
    }

    static int longestIncreasingSubsequence(int arr[], int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            } else {
                int ind = binarySearch(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }
        return temp.size();
    }

    public static int binarySearch(List<Integer> temp, int key) {
        int low = 0;
        int high = temp.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (temp.get(mid) > key) {
                return mid;
            } else if (temp.get(mid) < key) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        int arr[] = { 1, 2, 5, 4, -1, 9 };
        int n = arr.length;
        System.out.println("Binary Search " + longestIncreasingSubsequence(arr, n));
        System.out.println("Recursion " + rec(arr, n, 0, -1));

    }
}
