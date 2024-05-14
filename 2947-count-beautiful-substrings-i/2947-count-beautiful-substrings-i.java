class Solution {
    public int beautifulSubstrings(String s, int k) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int v = 0;
            int c = 0;
            for(int j=i; j<s.length(); j++){
                if(isVowel(s.charAt(j))){
                    v++;
                }else c++;

                if(v==c && (v*c)%k==0){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isVowel(char c){
        return(c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}