class FreqStack {
    HashMap<Integer, Stack<Integer>> freq;
    HashMap<Integer, Integer> hm;
    int maxFreq = 0;
    public FreqStack() {
        freq = new HashMap<>();
        hm = new HashMap<>();
    }

    public void push(int val) {
        hm.put(val, hm.getOrDefault(val, 0)+1);
        if (hm.get(val)>maxFreq){
            maxFreq++;
        }
        if (!freq.containsKey(hm.get(val))){
            freq.put(hm.get(val), new Stack<>());
        }
        freq.get(hm.get(val)).push(val);
    }

    public int pop() {
        int ele = freq.get(maxFreq).pop();
        hm.put(ele, hm.get(ele)-1);
        if (freq.get(maxFreq).isEmpty()){
            freq.remove(maxFreq);
            maxFreq--;
        }
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */