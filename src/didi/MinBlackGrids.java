//package didi;
//
//import java.util.ArrayDeque;
//import java.util.Deque;
//class Node{
//    int x, y, count;
//    public Node(int x, int y, int count){
//        this.x = x;
//        this.y = y;
//        this.count = count;
//    }
//}
//public class MinBlackGrids {
//    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 1, 0},
//                {0, 1, 1},
//                {0, 1, 0},
//                {1, 0, 0},
//                {1, 0, 0}
//        };
//        int minBlackGrids = findMinBlackGrids(grid);
//        System.out.println("最少需要经过的黑色网格数：" + minBlackGrids);
//    }
//
//    public static int findMinBlackGrids(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向
//
//        Deque<Node1> deque = new ArrayDeque<>();
//        boolean[][] visited = new boolean[n][m];
//        int[][] dist = new int[n][m];
//
//        deque.offerFirst(new Node1(0, 0, 0)); // 开始位置
//        visited[0][0] = true;
//
//        while (!deque.isEmpty()) {
//            Node1 current = deque.pollFirst();
//            int x = current.x;
//            int y = current.y;
//
//            for (int[] dir : directions) {
//                int newX = x + dir[0];
//                int newY = y + dir[1];
//
//                if (newX == n - 1 && newY == m - 1) {
//                    // 到达目标位置
//                    return current.count;
//                }
//
//                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
//                    if (grid[newX][newY] == 0) {
//                        deque.offerFirst(new Node1(0, 0, current.count));
//                    } else {
//                        deque.offerLast(new Node1(0, 0, current.count + 1));
//                    }
//                    visited[newX][newY] = true;
//                }
//            }
//        }
//
//        return -1; // 如果无法到达目标位置
//    }
//}
//
