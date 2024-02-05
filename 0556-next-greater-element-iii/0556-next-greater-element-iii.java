class Solution {
    public int nextGreaterElement(int n) {
        int digits = 0;
        int num = n;
        boolean swapped = false;
        while(num!=0){
            num/=10;
            digits++;
        }

        int[] arr = new int[digits];
        for(int i=digits-1; i>=0; i--){
            arr[i] = n%10;
            n/=10;
        }
        int idx = 0;
        for(int i=digits-1; i>=0; i--){
            if(i==0){
                break;
            }
            if(arr[i]>arr[i-1]){
                swapped = true;
                idx = i-1;
                break;
            }
        }
        long ans = 0;
        if (swapped){
            int greater = Integer.MAX_VALUE;
            int swap_idx = 0;
            for (int i=digits-1; i>=idx; i--){
                if (arr[i]>arr[idx] && arr[i]<greater){
                    greater = arr[i];
                    swap_idx = i;
                }
            }
            int temp = arr[idx];
            arr[idx] = arr[swap_idx];
            arr[swap_idx] = temp;
            reverse(arr, idx+1);
            for(int i=0; i<digits; i++){
                ans = (ans*10)+arr[i];
                if(ans>Integer.MAX_VALUE){
                    return -1;
                }
            }
        }
        else{
            return -1;
        }
        return (int)ans;
    }

    public static void reverse(int[] arr, int sp){
        int ep = arr.length-1;
        while(sp<ep){
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;
            sp++;
            ep--;
        }
    }
}