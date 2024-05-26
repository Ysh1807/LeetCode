class Solution {
    class Triplet{
        int len;
        int i;
        int j;

        Triplet(int len, int i, int j){
            this.len = len;
            this.i = i;
            this.j = j;
        }
    }

    public String minWindow(String s, String t) {
        if (t.length()>s.length()){
            return "";
        }
        Triplet minAns = new Triplet(Integer.MAX_VALUE, 0, 0);
        HashMap<Character, Integer> hm1, hm2;
        hm1 = new HashMap<>();
        hm2 = new HashMap<>();

        for (int i=0; i<t.length(); i++){
            hm1.put(t.charAt(i), hm1.getOrDefault(t.charAt(i), 0)+1);
        }
        int match = 0;
        int sp = 0;
        int ep = 0;

        while (ep<s.length() || match==t.length()){
            if (match<t.length()){
                hm2.put(s.charAt(ep), hm2.getOrDefault(s.charAt(ep), 0)+1);
                if (hm2.get(s.charAt(ep))<=hm1.getOrDefault(s.charAt(ep), 0)){
                    match++;
                }
                ep++;
            }else {
                hm2.put(s.charAt(sp), hm2.get(s.charAt(sp))-1);
                if (hm2.get(s.charAt(sp))<hm1.getOrDefault(s.charAt(sp), 0)){
                    match--;
                }
                sp++;
            }

            if (match==t.length()){
                if ((ep-sp) < minAns.len){
                    minAns = new Triplet(ep-sp, sp, ep-1);
                }
            }
        }
        if (minAns.len!=Integer.MAX_VALUE){
            return s.substring(minAns.i, minAns.j+1);
        }else {
            return "";
        }
    }
}