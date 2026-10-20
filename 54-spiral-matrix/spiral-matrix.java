class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> res = new ArrayList<>();

        int sr = 0;
        int sc = 0;
        int er = matrix.length - 1;
        int ec = matrix[0].length - 1;
        while(sr<=er && sc<=ec){
            //Right
            for(int j=sc;j<=ec;j++){
                res.add(matrix[sr][j]);
            }
                sr++;
            //Down
            for(int j=sr;j<=er;j++){
                res.add(matrix[j][ec]);
            }
                ec--;
            //Left
            if(sr<=er){
                for(int j=ec;j>=sc;j--){
                    res.add(matrix[er][j]);
                }
                    er--;
            }
            //UP
            if(sc<=ec){
                for(int j=er;j>=sr;j--){
                    res.add(matrix[j][sc]);
                }
                    sc++;
            }

        }
        return res;
    }
}