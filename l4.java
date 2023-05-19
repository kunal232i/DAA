
import java.util.Scanner;

public class l4 {
    public static int iterative(int base, int exponent, int mod) {
        int ans = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                ans = (ans * base) % mod;
                exponent--;
            }
            base = (base * base) % mod;
            exponent = exponent / 2;
        }
        return ans;
    }

    public static int rec(int base, int exponent, int mod) {
        if (exponent == 0) {
            return 1;
        }
        int half = rec(base, exponent / 2, mod);
        int result = (half * half) % mod;
        if (exponent % 2 == 1) {
            result = (result * base) % mod;
        }
        return result;
    }

    public static int iterativeBin(int base, int exponent, int mod) {
        if (mod == 1) {
            return 0;
        }
        int result = 1;
        base %= mod;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            exponent >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int base = scanner.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = scanner.nextInt();
        System.out.print("Enter the Modulus: ");
        int mod = scanner.nextInt();

        System.out.println("Iterative result: " + iterative(base, exponent, mod));
        System.out.println("IterativeBin result: " + iterativeBin(base, exponent, mod));
        System.out.println("Recursive result: " + rec(base, exponent, mod));
    }
}
