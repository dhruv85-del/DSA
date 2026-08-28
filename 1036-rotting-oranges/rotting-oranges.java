class Solution {
    public boolean valid(int i,int j,int n, int m){
        if(i<0 || i>=n || j<0 || j>=m ){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh=0;
        int time=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i,j});
                    grid[i][j]=-2;
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            while(size-- > 0){
                int[] p= q.poll();
                int r=p[0];
                int c=p[1];
                for(int k=0;k<4;k++){
                    int nr=r+dr[k];
                    int nc=c+dc[k];
                    if(valid(nr,nc,n,m) && grid[nr][nc]==1){
                        q.add(new int[]{nr,nc});
                        grid[nr][nc]=-2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh==0) return time;
        return -1;
    }
}