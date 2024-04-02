class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int maxlen = 0;
        for(int num : nums){
            if(!hm.containsKey(num)){
                int sp = num;
                int ep = num;
                if(hm.containsKey(num-1)) sp = sp - hm.get(num-1);

                if(hm.containsKey(num+1)) ep = ep + hm.get(num+1);

                int l = ep-sp+1;
                hm.put(sp, l);
                hm.put(ep, l);
                if(sp != num && ep != num) hm.put(num , 1);
                maxlen = Math.max(maxlen , l);


            }
        }

        return maxlen;
    }
}