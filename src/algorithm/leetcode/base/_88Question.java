import java.math.BigDecimal;
import java.util.Arrays;

public class _88Question {

    public static void main(String[] args) {
//        int [] array = new int[0];
        int [] nums1 = {4,5,6,0,0,0};
        int [] nums2 = {1,2,3};
        merge(nums1,3,nums2,3);
        String s = Arrays.toString(nums1);
        System.out.println(s);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] oldNums1 = new int[m];
        int [] newNums2 = nums2;
        double min = -1e10;
        for(int i = 0; i < m; i++){
            oldNums1[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        while(k < m + n){
            if(i < m && j < n){
                if(oldNums1[i] < newNums2[j]){
                    nums1[k++] = oldNums1[i++];
                }else{
                    nums1[k++] = newNums2[j++];
                }
            }else if(i == m){
                for(int l = j; l < n;){
                    nums1[k++] = newNums2[l++];
                }
            }else{
                for(int l = i; l < m;){
                    nums1[k++] = oldNums1[l++];
                }
            }

        }
    }
}
