class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] pre = new int[seats.length];
        int[] suff = new int[seats.length];
        
        int lastPreIdx = Integer.MAX_VALUE;
        for(int i=0; i< seats.length; i++){
            if (seats[i]==1){
                lastPreIdx = i;
                pre[i] = 0;
            }else {
                if (lastPreIdx!=Integer.MAX_VALUE){
                    pre[i] = i - lastPreIdx;
                }else {
                    pre[i] = lastPreIdx;
                }
            }
        }
        int lastSuffIdx = Integer.MAX_VALUE;
        for(int i= seats.length-1; i>=0; i--){
            if (seats[i]==1){
                lastSuffIdx = i;
                suff[i] = 0;
            }else {
                if (lastSuffIdx!=Integer.MAX_VALUE){
                    suff[i] = lastSuffIdx - i;
                }else {
                    suff[i] = lastSuffIdx;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        int min;
        for (int i=0; i< seats.length; i++){
            min = Math.min(pre[i], suff[i]);
            ans = Math.max(min, ans);
        }
        
        return ans;
    }
}