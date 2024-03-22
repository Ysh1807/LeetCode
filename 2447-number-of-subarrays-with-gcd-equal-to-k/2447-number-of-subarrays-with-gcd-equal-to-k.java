class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int ans = 0;
            for(int j=i; j<nums.length; j++){
                ans = gcd(ans, nums[j]);
                if(ans<k){
                    break;
                }
                if(ans==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
}