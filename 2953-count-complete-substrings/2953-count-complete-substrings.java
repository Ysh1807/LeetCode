class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int ans = 0;
        int last = 0;
        for (int i=1; i<word.length(); i++){
            if (Math.abs(word.charAt(i)-word.charAt(i-1))>2){
                ans+=count(word, last, i-1, k);
                last = i;
            }
        }
        ans+=count(word, last, word.length()-1, k);
        return ans;
    }

    public int count(String s, int st, int e, int k){
        int n = e-st+1;
        int ct = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=1; i<=26 && i*k<=n; i++){
            int good = 0;
            for (int j=0; j<i*k; j++){
                char c = s.charAt(st+j);
                hm.put(c, hm.getOrDefault(c, 0)+1);
                if (hm.get(c)==k){
                    good++;
                }
                if (hm.get(c)==k+1){
                    good--;
                }
            }
            if (good == i){
                ct++;
            }
            int sp = st;
            int ep = st + i*k;
            while (ep<=e){
                hm.put(s.charAt(sp), hm.get(s.charAt(sp))-1);
                if (hm.get(s.charAt(sp))==k-1){
                    good--;
                }
                if (hm.get(s.charAt(sp))==k){
                    good++;
                }
                sp++;
                hm.put(s.charAt(ep), hm.getOrDefault(s.charAt(ep), 0)+1);
                if (hm.get(s.charAt(ep))==k){
                    good++;
                }
                if (hm.get(s.charAt(ep))==k+1){
                    good--;
                }
                ep++;
                if (good == i){
                    ct++;
                }
            }
            hm.clear();
        }
        return ct;
    }
}