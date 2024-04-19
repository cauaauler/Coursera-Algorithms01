import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {

        int[] n = {-40, -20, 30, -10, 40, 0, 10, 5};
        Arrays.sort(n);

        for (int i = 0; i < n.length - 2; i++) {
            for (int j = i + 1; j < n.length - 1; j++) {
                int target = -(n[i] + n[j]);
                int k = BinarySearch.indexOf(n, target);
                if (k > j) {
                    System.out.printf("%d + %d + %d = 0 %n", n[i], n[j], n[k]);
                }
            }
        }
    }
}
