class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        int[] left = new int[n];

        Arrays.fill(right, -1);
        Arrays.fill(left, -1);

        Stack<Integer> stack = new Stack<>();
        int i=0;
        while (i<n){
            if (stack.isEmpty()){
                stack.push(i);
                i++;
            }else {
                if (arr[i]<arr[stack.peek()]){
                    right[stack.peek()] = i;
                    stack.pop();
                }else {
                    stack.push(i);
                    i++;
                }
            }
        }
        stack.clear();

        i=n-1;
        while (i>=0){
            if (stack.isEmpty()){
                stack.push(i);
                i--;
            }else {
                if (arr[i]<arr[stack.peek()]){
                    left[stack.peek()] = i;
                    stack.pop();
                }else {
                    stack.push(i);
                    i--;
                }
            }
        }

        int max_area = Integer.MIN_VALUE;

        for (int j=0; j<n; j++){
            int l = -1;
            int r = n;
            if (right[j]!=-1){
                r = right[j];
            }
            if (left[j]!=-1){
                l = left[j];
            }
            int area = (r-l-1)*arr[j];
            max_area = Math.max(max_area, area);
        }
        
        return max_area;
    }
}