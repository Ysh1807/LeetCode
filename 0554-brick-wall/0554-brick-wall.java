class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (List<Integer> row : wall){
            int[] pre = prefix(row);
            for (int i=0; i<pre.length-1; i++){
                hm.put(pre[i], hm.getOrDefault(pre[i],0)+1);
            }
        }
        int ans = 0;
        for (int key : hm.keySet()){
            if (hm.get(key)>ans){
                ans = hm.get(key);
            }
        }
        return wall.size()-ans;
    }

    public int[] prefix(List<Integer> list){

        int n = list.size();
        int[] pre = new int[n];
        pre[0] = list.get(0);
        for (int i=1; i<n; i++){
            pre[i] = pre[i-1]+ list.get(i);
        }
        return pre;
    }
}