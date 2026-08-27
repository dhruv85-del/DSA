class Solution {
    public boolean valid(int i,int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m ){
            return false;
        }
        return true;
    }
    public void dfs(char[][] grid, int  n, int m, int row, int col, boolean[][] vis){
        vis[row][col] = true;
        //4 possible directions
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};

        for(int k=0;k<4;k++){
            int newRow= row+dx[k];
            int newCol= col+dy[k];
            if(valid(newRow,newCol,n,m) && grid[newRow][newCol]=='1' && !vis[newRow][newCol]){
                dfs(grid,n,m,newRow,newCol,vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        boolean[][] vis= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,n,m,i,j,vis);
                    res++;
                }
            }
        }
        return res;
        }
}