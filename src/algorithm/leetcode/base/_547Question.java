/**
 * @ClassName: _547Question
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/08/30 9:57
 * @Version: 1.0
 */
public class _547Question {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int res = 0;
        int[] visited = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(visited[i] == 0){
                dfs(isConnected, visited, i);
                res += 1;
            }
        }
        return res;
    }

    private static void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for(int j = 0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && visited[j] == 0){
                dfs(isConnected, visited, j);
            }
        }

    }


//    public static void dfs(int i, int j, int[][] isConnected){
//        if(!(i >= 0 && j >= 0 && i < isConnected.length && j < isConnected[i].length && isConnected[i][j] == 1)){
//            return;
//        }
//        if(isConnected[i][j] == 1){
//            isConnected[i][j] = isConnected[j][i] = 0;
//            for(int k = 0; k < isConnected[i].length; k++){
//                if( isConnected[j][k] == 1 ){
//                    dfs(j, k, isConnected);
//                }
//            }
//        }
//
//
//    }
//
//
//    public static int findCircleNum(int[][] isConnected) {
//        int res = 0;
//        for(int i = 0; i < isConnected.length; i++){
//            for(int j = 0; j < isConnected[i].length; j++){
//                if(isConnected[i][j] == 1){
//                    dfs(i, j, isConnected);
//                    res+=1;
//                }
//            }
//        }
//        return res;
//    }
}
