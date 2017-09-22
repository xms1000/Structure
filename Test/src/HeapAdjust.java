import java.util.Arrays;

/**
 * Created by xms on 2017/9/11.
 */
public class HeapAdjust {
    public static void main(String[] args) {
        int[] a = {41, 32, 45, 82, 1, 32, 44, 42, 23, 4, 32, 15, 29};
        createHeap(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            heapAdjust(a, 0, i - 1);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void createHeap(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, a.length - 1);
        }
    }

    private static void heapAdjust(int[] a, int i, int n) {
        while (i <= n / 2) {
            if (2 * i + 2 <= n) {
                if (a[i] > a[2 * i + 1] || a[i] > a[2 * i + 2]) {
                    int k = a[2 * i + 1] < a[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
                    swap(a, i, k);
                    i = k;
                } else {
                    break;
                }
            } else if (2 * i + 1 <= n) {
                if (a[i] > a[2 * i + 1]) {
                    swap(a, i, 2 * i + 1);
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
