class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        HashSet<Character> hs = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int[] prefixSum = new int[words.length];
        int c=0;
        for(int i=0; i<words.length;i++){
            if(hs.contains(words[i].charAt(0)) && hs.contains(words[i].charAt(words[i].length()-1))){
                c++;
            }
            prefixSum[i] = c;
        }

        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==0){
                ans[i] = prefixSum[queries[i][1]];
            }else{
                ans[i] = prefixSum[queries[i][1]]-prefixSum[queries[i][0]-1];
            }
        }
        return ans;
    }
}
