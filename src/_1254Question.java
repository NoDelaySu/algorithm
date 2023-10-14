public class _1254Question {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
    public static void dfs(int x, int y, int[][] grid, Integer[] value){
        // System.out.println(x +","+ y);
        if(!(x >= 0 && y >= 0 && x < grid.length && y < grid[x].length )){
            value[0] = 0;
            return;
        }
        // TODO 之前放在上面的边界判断中，但是这道题不一样，他要找出1围绕的封闭岛屿，
        // 处理不太一样，上面时判到达边界的情况，这个时判断不能到达边界的情况
        if(grid[x][y] == 1){
            return;
        }

        if(grid[x][y] == 0){
            grid[x][y] = 1;
        }
        dfs(x - 1, y, grid, value);
        dfs(x + 1, y, grid, value);
        dfs(x, y - 1, grid, value);
        dfs(x, y + 1, grid, value);
    }

    public static int closedIsland(int[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    Integer[] value = { 1 };
                    dfs(i, j, grid, value);
                    num+=value[0];
                }

            }
        }
        return num;
    }


}
