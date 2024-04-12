class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> hm;
        ArrayList<Integer> list;

        public RandomizedCollection() {
            hm = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!hm.containsKey(val)){
                HashSet<Integer> hs = new HashSet<>();
                hs.add(list.size());
                hm.put(val, hs);
                list.add(val);
                return true;
            }else {
                hm.get(val).add(list.size());
                list.add(val);
                return false;
            }
        }

        public boolean remove(int val) {
            
            if (hm.containsKey(val)){
                int i=0;
                for (int ele:hm.get(val)){
                    i = ele;
                    break;
                }
                if(hm.get(val).size()==1){
                    hm.remove(val);
                }else {
                    hm.get(val).remove(i);
                }
                boolean swapped = false;
                if(i!=list.size()-1){
                    Collections.swap(list, i, list.size()-1);
                    swapped = true;
                }
                list.remove(list.size()-1);
                if (!list.isEmpty() && swapped){
                    hm.get(list.get(i)).add(i);
                    hm.get(list.get(i)).remove(list.size());
                }
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
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */