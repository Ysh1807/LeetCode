class NumArray {
    int[] psum;
    public NumArray(int[] nums) {
        psum = new int[nums.length];
        psum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            psum[i] = psum[i-1] + nums[i];
        }

    }
    public int sumRange(int left, int right) {
        if(left==0){
            return psum[right];
        }else{
            return psum[right] - psum[left-1];
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */