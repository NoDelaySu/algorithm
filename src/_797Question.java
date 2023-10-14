import java.util.ArrayList;
import java.util.List;
public class _797Question {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static void dfs(int x, int[][] graph, List<Integer> path, List<List<Integer>> result){
        if(x == graph.length - 1){
            result.add(deepCopy(path));
            System.out.println(path);
            return;
        }
        for(int i = 0; i < graph[x].length; i++){
            path.add(graph[x][i]);
            dfs(graph[x][i], graph, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static List<Integer> deepCopy(List<Integer> original){
        List<Integer> target = new ArrayList<>();
        for(int i = 0; i < original.size(); i++){
            target.add(original.get(i));
        }
        return target;
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, result);
        return result;
    }

}
