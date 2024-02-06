class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int k = n-1;
        int ans = Integer.MIN_VALUE;
        while(i<k){
            int water = Math.min(height[i], height[k])*(k-i);
            ans = Math.max(ans, water);
            if(height[i]>height[k]){
                k--;
            }else{
                i++;
            }
        }
        return ans;
        
    }
}