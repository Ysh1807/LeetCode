class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int[] pre = new int[n];
        for (int i=0; i<n; i++){
            if (i==0){
                pre[i] = nums[0];
            }else {
                pre[i] = pre[i-1]+nums[i];
            }
            if (hm.containsKey(pre[i]-k)){
                ans+=hm.get(pre[i]-k);
            }
            hm.put(pre[i], hm.getOrDefault(pre[i],0)+1);

        }
        return ans;
    }

}