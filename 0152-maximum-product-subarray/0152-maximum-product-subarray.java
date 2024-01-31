class Solution {
    public int maxProduct(int[] nums) {
        int[] pre = prefixProduct(nums);
        int[] suffix = suffixProduct(nums);
        int preMax = Integer.MIN_VALUE;
        int suffixMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            preMax = Math.max(preMax, pre[i]);
        }

        for (int i = nums.length-1; i >=0; i--) {
            suffixMax = Math.max(suffixMax, suffix[i]);
        }
        
        return Math.max(preMax, suffixMax);
    }
    public static int[] prefixProduct(int[] arr){
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for (int i=1; i< arr.length; i++){
            if(pre[i-1]==0){
                pre[i] = arr[i];
                continue;
            }
            pre[i] = pre[i-1]*arr[i];
        }
        
        return pre;
    }

    public static int[] suffixProduct(int[] arr){
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--){
            if(suffix[i+1]==0){
                suffix[i] = arr[i];
                continue;
            }
            suffix[i] = suffix[i+1]*arr[i];
        }

        return suffix;
    }
}