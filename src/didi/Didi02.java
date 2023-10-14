package didi;

import java.util.*;

class Node1 {
    int x, y, distance;

    public Node1(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance; // 代表经过1的个数
    }
}
class Solution02{
    public void dfs(int[][] grid, boolean[][] visited, int x, int y, Node1 node){
        if(x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || visited[x][y] == true){
            return;
        }
        visited[x][y] = true;
        if(grid[x][y] == 1){
            node.distance += 1;
        }
    }

    public int getMinDistance(int[][] grid, int n, int m){
        int distance = Integer.MAX_VALUE;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // 上下左右
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        for(int x = 0; x < n; x++){
            for(int y = 0 ; y < m; y++){
                for(int[] direction: directions){
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    Node1 node = new Node1(newX, newY, 0);
                    if(newY >= 0 && newY < grid.length && !visited[newX][newY]){
                        dfs(grid, visited, newY, newY, node);
                        visited[newY][newY] = false;
                    }
                    distance = Math.min(distance, node.distance);

                }

            }
        }
        return distance;
    }

    public int getMinDistance2(int[][] grid, int n, int m){
        int distance = Integer.MAX_VALUE;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // 上下左右
        boolean[][] visited = new boolean[n][m];
        Queue<Node1> queue = new LinkedList<>();

        queue.offer(new Node1(0, 0, 0));
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Node1 currentNode = queue.poll();
            if(currentNode.x == n - 1 && currentNode.y == m - 1){
                //distance = currentNode.distance;
                //System.out.println(currentNode.distance);
                distance = Math.min(distance, currentNode.distance);
            }
            for(int[] direction: directions){
                int newX = currentNode.x + direction[0];
                int newY = currentNode.y + direction[1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m
                        && !visited[newX][newY]){
                    if(grid[newX][newY] == 1){
                        queue.offer(new Node1(newX, newY, currentNode.distance + 1));
                    }else{
                        queue.offer(new Node1(newX, newY, currentNode.distance));
                    }

                    visited[newX][newY] = true;
                }
            }
        }

        return distance;
    }
}

class Didi02{
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int [][] grid = new int[n][m];
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++){
//                grid[i][j] = sc.nextInt();
//            }
//        }
        int n = 5;
        int m = 3;
        int[][] grid = {{0,1,0},{0,1,1},{0,1,0},{1,0,0},{1,0,0}};
        Solution02 solution = new Solution02();
        System.out.println(solution.getMinDistance(grid, n, m));
    }
}