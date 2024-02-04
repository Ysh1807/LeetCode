class Solution {
    public static int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++){
            while (nums[i]!=i+1){
                if (nums[i]>0 && nums.length>=nums[i]){
                    if (nums[nums[i]-1] == nums[i]){
                        break;
                    }
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
                else {
                    break;
                }
            }
        }

        for (int i=0; i<nums.length; i++){
            if (nums[i]!=i+1){
                return (i+1);
            }

        }

        return nums.length+1;
    }
}