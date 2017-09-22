import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by xms on 2017/9/21.
 */
public class TopK {
    static int temp=0;
    public static void main(String[] args) {
        int[] a=new int[10000];
        for (int i = 0; i < a.length; i++) {
            Random random = new Random(i+System.currentTimeMillis());
            a[i]=random.nextInt(10000);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findTopK(a,1024,0,a.length-1));
        System.out.println(temp);
    }
    private static  int findTopK(int[] a,int k,int low,int high){
        int i = low;
        int j = high;
        int key=a[low];
        while (i<j){
            while (i<j&&a[j]>=key) {
                j--;
                temp++;
            }
            a[i]=a[j];
            while (i<j&&a[i]<=key) {
                i++;
                temp++;
            }
            a[j]=a[i];
        }
        a[i]=key;
        if(i==k-1){
            return a[i];
        }else if(i<k-1){
            return findTopK(a,k,i+1,high);
        }else {
            return findTopK(a,k,low,i-1);
        }
    }
}
