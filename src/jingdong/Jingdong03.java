package jingdong;
//2
//5 3
//1 2
//1 3
//2 4
//2 5
//5 2
//1 2
//1 3
//2 4
//2 5

//win
//lose

import java.util.*;

/**
 * @ClassName: Jingdong03
 * 2
 * 5 3
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 5 2
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * win
 * lose
 */
public class Jingdong03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int x = in.nextInt();
            int[] tree = new int[n + 1];
            for (int j = 1; j < n; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                tree[v] = u;
            }
            System.out.println(Arrays.toString(tree));
            HashMap<Integer, List<Integer>> map = new HashMap();
            for (int j = 1; j < tree.length; j++) {
                if(tree[j] != 0){
                    List<Integer> childList = map.get(tree[j]);
                    if(childList == null){
                        childList = new ArrayList();
                    }
                    childList.add(j);
                    map.put(tree[j], childList);
                }

            }
            System.out.println(map);
            if(map.get(x) == null){
                System.out.println("win");
            }else{
                System.out.println("lose");
            }
        }
    }
}
