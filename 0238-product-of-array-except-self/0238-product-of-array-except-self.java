class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int suffix = 1;

        prefixProduct[0] = nums[0];
        for(int i=1; i<n; i++){
            prefixProduct[i] = prefixProduct[i-1]*nums[i];
        }

        for(int i=n-1; i>=0; i--){
            if(i==0){
                prefixProduct[0] = suffix;
            }
            else{
                prefixProduct[i] = prefixProduct[i-1]*suffix;
                suffix*=nums[i];
            }
        }
        
        return prefixProduct;
    }
}