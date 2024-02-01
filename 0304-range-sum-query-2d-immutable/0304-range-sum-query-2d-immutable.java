class NumMatrix {
    int[][] pSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        pSum = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(j==0){
                    pSum[i][j] = matrix[i][j];
                    continue;
                }
                pSum[i][j] = pSum[i][j-1]+matrix[i][j];
            }
        }

        for(int col=0; col<cols; col++){
            for(int row=0; row<rows; row++){
                if(row==0){
                    continue;
                }
                pSum[row][col] = pSum[row-1][col]+pSum[row][col];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1>0 && col1>0){
            return (pSum[row2][col2]-pSum[row2][col1-1]-pSum[row1-1][col2]+pSum[row1-1][col1-1]);
        }
        else if(row1==0 && col1==0 && row2==0 && col2==0){
            return pSum[0][0];
        }
        else if(row1==0 && col1==0){
            return pSum[row2][col2];
        }
        else if(row1==0){
            return (pSum[row2][col2]-pSum[row2][col1-1]);
        }else{
            return (pSum[row2][col2]-pSum[row1-1][col2]);
        }
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */