class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0;
        int j=0;
        int rSteps = matrix.length-1;
        int cSteps = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();

        while(cSteps>=1 && rSteps>=1){
            for(int k=0; k<cSteps; k++){
                ans.add(matrix[i][j]);
                j++;
            }
            for(int k=0; k<rSteps; k++){
                ans.add(matrix[i][j]);
                i++;
            }
            for(int k=0; k<cSteps; k++){
                ans.add(matrix[i][j]);
                j--;
            }
            for(int k=0; k<rSteps; k++){
                ans.add(matrix[i][j]);
                i--;
            }
            cSteps-=2;
            rSteps-=2;
            i++;
            j++;
        }

        if(rSteps==0){
            for(int k=0; k<cSteps+1; k++){
                ans.add(matrix[i][j]);
                j++;
            }
        } else if(cSteps==0){
            for(int k=0; k<rSteps+1; k++){
                ans.add(matrix[i][j]);
                i++;
            }
        }

        return ans;
        
    }
}