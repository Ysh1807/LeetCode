class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++){
            int count = 0;
            for(int j=0; j<nums.length; j++){
                if(checkBit(nums[j],i)){
                    count++;
                }
            }

            if(count%3==1){
                ans+=(1<<i);
            }
        }

        return ans;
        
    }

    public static boolean checkBit(int n, int k)
    {
        return (n & (1 << k)) != 0;
    }
}