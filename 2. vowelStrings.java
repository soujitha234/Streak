/*Question: Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

Example 2:
Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].
*/    

/*
here there are 2 appraoches to follow:
1. bruteforce
    to use 2 nested for loops, 1 for queries and other for words
    but as the queries[i] difference increases, it becomes expensive to calcualate also it becomes repetative
2. PrefixSum gives the efficient solution by,
    calculating the sum of ideal words upto that index by which calculation redundancy is minimized
*/
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
