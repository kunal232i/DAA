import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class l3 {

    public static int rec(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int x = rec(n - 1, k);
        int y = (x + k) % n;
        return y;
    }

    public static int Q(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int count = 0;
        while (q.size() > 1) {
            int curr = q.poll();
            count++;
            if (count % k == 0) {
                continue;
            }
            q.add(curr);
        }
        return q.poll();
    }

    public static int arr(int n, int k) {
        k--;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        int cnt = 0, cut = 0, num = 1;
        while (cnt < (n - 1)) {
            while (num <= k) {
                cut++;
                cut = cut % n;
                if (arr[cut] == 1) {
                    num++;
                }
            }
            num = 1;
            arr[cut] = 0;
            cnt++;
            cut++;
            cut = cut % n;
            while (arr[cut] == 0) {
                cut++;
                cut = cut % n;
            }
        }
        return cut;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N ");
        int n = sc.nextInt();
        System.out.println("Enter the value of K ");
        int k = sc.nextInt();

        System.out.println("Enter your choice : \n1. Recursion \n2. Queue \n3. Array");
        int c = sc.nextInt();
        if (c == 1) {
            System.out.println("The person who is going to survive is " + rec(n, k));
        }
        if (c == 2) {
            System.out.println("The person who is going to survive is " + Q(n, k));
        }
        if (c == 3) {

            System.out.println("The person who is going to survive is " + arr(n, k));

        }
    }
}
