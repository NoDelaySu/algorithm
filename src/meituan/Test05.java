package meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Test05
 * @Package: meituan
 * @Description: TODO
 * @Author: 苏佳欣
 * @CreateDate: 2023/09/16 18:52
 * @Version: 1.0
 */

class Edge implements Comparable<Edge>{
    int u,v,w,p;

    public Edge(int u, int v, int w, int p) {
        this.u = u;
        this.v = v;
        this.w = w;
        this.p = p;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}
public class Test05 {

    private static int[] parent;
    private static int[] rank;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            int p = in.nextInt();
            edges.add(new Edge(u,v,w,p));

        }

        Collections.sort(edges);

        int totalCost = 0;
        List<Edge> selectedEdges = new ArrayList<>();
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        boolean hasMandatoryPlan = false;
        for (Edge edge : edges) {
            if(edge.p == 1){
                selectedEdges.add(edge);
                totalCost += edge.w;
                union(edge.u, edge.w);
                hasMandatoryPlan = true;
            }
        }

        if(!hasMandatoryPlan){
            System.out.println(-1);
            return;
        }

        int countEdges = selectedEdges.size();

        for (Edge edge : edges) {
            if(countEdges == n-1){
                break;
            }

            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if(find(u) != find(v)){
                selectedEdges.add(edge);
                totalCost +=w;
                union(u, v);
                countEdges++;
            }
        }

        if(countEdges < n-1){
            System.out.println(-1);
            return;
        }

        System.out.println(totalCost);

        List<Integer> selectedPlans = getSelectedPlans(selectedEdges, n);
        for (Integer plan : selectedPlans) {
            System.out.println(plan + " ");
        }
    }

    private static List<Integer> getSelectedPlans(List<Edge> selectedEdges, int n) {
        return new ArrayList<>();
    }

    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }

        if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }else if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }else{
            parent[rootX] = rootY;
            rank[rootY] += 1;
        }
    }
}
