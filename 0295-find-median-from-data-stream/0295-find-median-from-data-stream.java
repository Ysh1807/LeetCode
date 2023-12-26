class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> right = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }

    public void addNum(int num) {
        if (left.size()==right.size()){
            right.add(num);
            int temp = right.remove();
            left.add(temp);
        }else {
            left.add(num);
            int temp = left.remove();
            right.add(temp);
        }
    }

    public double findMedian() {
        if (left.isEmpty()){
            return 0;
        }
        if (left.size()==right.size()){
            return (left.peek()+ right.peek())/2.0;
        }else {
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */