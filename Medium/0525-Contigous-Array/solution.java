class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<>();
        map.put(0, -1);
        int Sum = 0;
        int maxLength = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                Sum --;
            }
            else {
                Sum ++;
            }
            if(map.containsKey(Sum)) {
                int length = i - map.get(Sum);
                maxLength = Math.max(maxLength, length);
            }
            else {
                map.put(Sum, i);
            }
        }
        return maxLength;
    }
}
