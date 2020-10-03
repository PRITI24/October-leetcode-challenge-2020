
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();   //To Store unique pairs
        for (int c : nums) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);     //Counting number of occurrences of numbers
        }
        int res = 0;                            //Storing result
        for (int x : cnt.keySet()) {            //iterating over all numbers
            if ((k > 0 && cnt.containsKey(x + k)) || (k == 0 && cnt.get(x) > 1)) {   //if difference bet 2 number is k and k>0 then result increment or else if k is 0 then next number should be atleast greater than 1
                res++;
            }
        }
        return res;
    } 
    
    
}
