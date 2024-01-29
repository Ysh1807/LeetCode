class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int[] suffMax = new int[n];
        int ans = 0;

        preMax[0] = height[0];
        suffMax[n-1] = height[n-1];

        for(int i=1; i<n; i++){
            preMax[i] = Math.max(preMax[i-1], height[i]);
        }

        for(int j=n-2; j>=0; j--){
            suffMax[j] = Math.max(suffMax[j+1], height[j]);
        }

        for(int k=1; k<n-1; k++){
            int min = Math.min(preMax[k], suffMax[k]);
            if(height[k]<min){
                ans+=(min-height[k]);
            }
        }

        return ans;
        
    }
}