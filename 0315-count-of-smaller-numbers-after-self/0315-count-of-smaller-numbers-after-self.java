class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        Pair[] arr = new Pair[n];

        for (int i=0; i<n; i++){
            arr[i] = new Pair(nums[i], i);
        }
        mergeSort(arr, 0, n-1, count);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(count[i]);
        }
        return list;
    }

    public static void merge(Pair[] arr, int s, int m, int e, int[] count){
        Pair[] ans = new Pair[e-s+1];
        int i = s;
        int j = m+1;
        for (int k=0; k<e-s+1; k++){
            if (i<=m && j<=e){
                if (arr[i].num>arr[j].num){
                    count[arr[i].idx] += (e-j+1);
                    ans[k] = arr[i];
                    i++;
                }else {
                    ans[k] = arr[j];
                    j++;
                }
            }else {
                if (i>m){
                    ans[k] = arr[j];
                    j++;
                }else {
                    ans[k] = arr[i];
                    i++;
                }
            }
        }
        int idx = 0;
        for(int l=s; l<=e; l++){
            arr[l] = ans[idx];
            idx++;
        }
    }
    public static void mergeSort(Pair[] arr, int l, int r, int[] count){
        if(l==r){
            return;
        }
        int mid = (l+r)/2;

        mergeSort(arr, l, mid, count);
        mergeSort(arr, mid+1, r, count);

        merge(arr, l, mid, r, count);
    }

}