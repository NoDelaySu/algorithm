package xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2
//1:0,0:1
/**
 * @ClassName: Main02
 * @Package: xiaomi
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/23 15:47
 * @Version: 1.0
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String dependencies = scanner.nextLine();

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        String[] dependencyArr = dependencies.split(",");
        for (String dependency : dependencyArr) {

            String[] dependencyParts = dependency.split(":");
            int a = Integer.parseInt(dependencyParts[0]);
            int b = Integer.parseInt(dependencyParts[1]);
            adjacencyList.get(a).add(b);

        }

        if(isFeasible(adjacencyList)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    private static boolean isFeasible(List<List<Integer>> adjacencyList) {
        int n = adjacencyList.size();

        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if(visited[i] == 0 && !dfs(adjacencyList, visited, i)){
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> adjacencyList, int[] visited, int curr) {
        visited[curr] = 1;
        for (Integer next : adjacencyList.get(curr)) {
            if(visited[next] == 1){
                return false;
            }else if(visited[next] == 0 && !dfs(adjacencyList, visited, next)){
                return false;
            }
        }
        visited[curr] = 2;
        return true;

    }
}
