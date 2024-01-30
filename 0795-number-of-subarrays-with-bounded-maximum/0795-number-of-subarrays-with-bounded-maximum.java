class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int lgei = 0;
        int lastValidCount = 0;
        int ans = 0;


        for (int i=0; i<n; i++){
            if (nums[i]>right){
                lgei = i+1;
                lastValidCount=0;
            } else if (nums[i]<=right && nums[i]>=left) {
                lastValidCount = i-lgei+1;
                ans+=(i-lgei+1);
            }
            else {
                ans+=lastValidCount;
            }
        }
        return ans;
    }
}