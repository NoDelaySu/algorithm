public class _200Question {
    public static void main(String[] args) {
        //int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        char[][] grid = {{'1','1','0'},{'0','1','0'},{'0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int dfs(int x, int y, char[][] grid){
        // System.out.println(x +","+ y);
        if(!(x >= 0 && y >= 0 && x < grid.length && y < grid[x].length && grid[x][y] != '0')){
            return 0;
        }
        if(grid[x][y] == '1'){
            grid[x][y] = '0';
        }
        return 1+ dfs(x - 1, y, grid)
                + dfs(x + 1, y, grid)
                + dfs(x, y - 1, grid)
                + dfs(x, y + 1, grid);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != '0'){
                    int currArea = 0;
                    currArea = dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }


}
