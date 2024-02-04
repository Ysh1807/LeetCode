class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ele1 = nums[0];
        int freq = 1;
        int ele2 = nums[0];
        int freq2 = 0;

        for (int i=1; i< nums.length; i++){
            if (nums[i]!=ele1 && nums[i]!=ele2){
                if (freq>0 && freq2>0){
                    freq--;
                    freq2--;
                }
                else {
                    if (freq==0){
                        ele1 = nums[i];
                        freq++;
                    }else {
                        ele2=nums[i];
                        freq2++;
                    }
                }
            }else {
                if (nums[i]==ele1){
                    freq++;
                }else {
                    freq2++;
                }
            }

        }
        
        freq = 0;
        freq2 = 0;
        for (int num:nums){
            if (ele1==num){
                freq++;
            }
            if (ele2==num){
                freq2++;
            }
        }
        if (freq>nums.length/3){
            ans.add(ele1);
        }
        if (freq2>nums.length/3 && ele1!=ele2){
            ans.add(ele2);
        }

        return ans;
    }
}