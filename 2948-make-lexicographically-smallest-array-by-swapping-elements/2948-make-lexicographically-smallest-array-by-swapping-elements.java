class Pair{
    int ele;
    int idx;
    Pair(int ele , int idx){
        this.ele = ele;
        this.idx = idx;
    }
}

class Solution {
    public void helper(int[] ans, Pair[] arr , ArrayList<Integer>index, int j){
        Collections.sort(index);
        for(int k = 0; k<index.size(); k++){
            int id = index.get(k);
            ans[id] = arr[j++].ele;
        }
        index.clear();
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i<n; i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr , (a,b) -> a.ele-b.ele);
        int[] ans = new int[n];
        int j = 0;
        ArrayList<Integer> index = new ArrayList<>();
        index.add(arr[0].idx);
        for(int i = 1; i<n; i++){
            if(arr[i].ele - arr[i-1].ele>limit){
                helper(ans,arr,index,j);
                j = i;
                index.add(arr[i].idx);
            } else {
                index.add(arr[i].idx);
            }

        }
        helper(ans,arr,index,j);
        return ans;
    }
}   


    