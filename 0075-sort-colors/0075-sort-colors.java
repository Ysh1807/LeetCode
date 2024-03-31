class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int k = 0;

        while(k<=j){
            if(nums[k]==0){
                swap(nums, i, k);
                i++;
                k++;
            }else if(nums[k]==2){
                swap(nums, j, k);
                j--;
            }else{
                k++;
            }
        }
        
    }

    public void swap(int[] arr, int i, int k){
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}