/*695. Max Area of Island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int output = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int area = 0;
                if(grid[i][j] == 1){
                    area = helper(i, j, grid);
                    if(area > output)
                        output = area;
                }
            }
        }
        return output;
    }
    public static int helper(int i, int j, int[][] grid){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)
            return 0;
        grid[i][j] = 0;
        return 1+helper(i-1,j,grid)+helper(i,j-1,grid)+helper(i+1,j,grid)+helper(i,j+1,grid);
    }
}