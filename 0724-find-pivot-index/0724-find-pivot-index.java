class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pSum = new int[n];

        for(int i=0; i<n; i++){
            if(i==0){
                pSum[0] = nums[0];
            }else{
                pSum[i] = pSum[i-1] + nums[i];
            }
        }

        if(pSum[n-1]-nums[0]==0){
            return 0;
        }
        for(int i=1; i<n-1; i++){
            if(pSum[i-1] == (pSum[n-1]-pSum[i])){
                return i;
            }
        }
        if(pSum[n-2]==0){
            return n-1;
        }

        return -1;
    }
}