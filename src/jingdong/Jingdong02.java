package jingdong;

import java.util.Arrays;
import java.util.Scanner;
//3 4 4
//3 5 7
//1 2 2
//1 2 3 3

/**
 * 3 4 4
 * 3 5 7
 * 1 2 2
 * 1 2 3 3
 *
 * 1
 */
public class Jingdong02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int H = in.nextInt();

        int[] h = new int[n];
        int[] p = new int[n];
        int[] s = new int[m];

        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            s[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(h));
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < n; i++) {
            h[i] += s[p[i] - 1];
        }
        System.out.println(Arrays.toString(h));

        int[] Hs = new int[m];
        for (int i = 0; i < m; i++) {
            Hs[i] = H + s[i];
        }
        System.out.println(Arrays.toString(Hs));

        Arrays.sort(h);
        Arrays.sort(Hs);
        int ans = 0;
        int max = Hs[Hs.length - 1];
        for (int i = 0; i < h.length; i++) {
            if(max <= h[i]){
                break;
            }else{
                ans++;
            }
        }

//        for (int i = 0; i < Hs.length; i++) {
//            int temp = 0;
//            if(Hs[i] <= h[0]){
//                continue;
//            }
//            for (int j = 0; j < h.length; j++) {
//                if(Hs[i] <= h[j]){
//                    break;
//                }else{
//                    temp++;
//                }
//            }
//            ans = Math.max(ans, temp);
//
//        }
        System.out.println(ans);

    }


}
