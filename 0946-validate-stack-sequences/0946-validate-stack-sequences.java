class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=1;
        int j=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);

        while (i!=pushed.length || j!=popped.length){
            if (!stack.empty() && popped[j]==stack.peek()){
                stack.pop();
                j++;
                continue;
            }

            if (i!=pushed.length){
                stack.push(pushed[i]);
                i++;
            }else{
                break;
            }
        }

        return stack.empty();
        
    }
}