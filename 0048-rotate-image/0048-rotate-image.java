class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix);

        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                int temp =  matrix[j][i];
                matrix[j][i] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        } 
        
    }

    public static void transpose(int[][] mat){
        int n = mat.length;
        for(int row=0; row<n-1; row++){
            for(int col = row+1; col<n; col++){
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
            }
        }
    }
}