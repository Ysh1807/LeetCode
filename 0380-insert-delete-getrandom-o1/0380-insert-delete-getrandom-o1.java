class RandomizedSet {
        HashMap<Integer, Integer> hm;
        ArrayList<Integer> list;
        int idx = 0;

        public RandomizedSet() {
             hm = new HashMap<>();
             list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!hm.containsKey(val)){
                hm.put(val, idx);
                list.add(idx, val);
                idx++;
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (hm.containsKey(val)){
                int i = hm.get(val);
                hm.remove(val);
                boolean swapped = false;
                if(i!=list.size()-1){
                    Collections.swap(list, i, list.size()-1);
                    swapped = true;
                }
                list.remove(list.size()-1);
                if (!list.isEmpty() && swapped){
                    hm.put(list.get(i), i);
                }
                idx = list.size();
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random r = new Random();
            int i = r.nextInt(list.size());
            return list.get(i);
        }
    }
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */