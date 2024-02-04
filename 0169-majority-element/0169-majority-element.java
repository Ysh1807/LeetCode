class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int freq = 1;
        for (int i=1; i<nums.length; i++){
            if (freq==0){
                ele = nums[i];
                freq++;
                continue;
            }
            if (nums[i]==ele){
                freq++;
            }
            else {
                freq--;
            }
        }

        return ele;
    }
}