class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int count = 1;
        int max = Integer.MIN_VALUE;

        int[] suffMin = new int[n];
        suffMin[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            suffMin[i] = Math.min(suffMin[i+1], arr[i]);
        }

        for(int i=0; i<n-1; i++){
            max = Math.max(max, arr[i]);
            if(max<=suffMin[i+1]){
                count++;
            }
        }

        return count;
        
    }
}