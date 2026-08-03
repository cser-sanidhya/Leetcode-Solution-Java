class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxSequence = 1;

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int currentSequence = 1;

            while (true) {

                boolean found = false;

                for (int j = 0; j < nums.length; j++) {

                    if (nums[j] == current + 1) {
                        current = nums[j];
                        currentSequence++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    break;
                }
            }

            if (currentSequence > maxSequence) {
                maxSequence = currentSequence;
            }
        }

        return maxSequence;

        
    }
}
