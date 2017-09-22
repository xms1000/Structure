import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by xms on 2017/9/20.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        int max = 0;
        for (int k = 1; k <=n; k++) {
            int x =t+a[k]-1;
            int[][] dp = new int[n+1][x+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= x; j++) {
                    if (a[i] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i]] + a[i]);
                    } else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            if(max<dp[n][x]){
                max=dp[n][x];
            }
        }
        System.out.println(max);
    }
}