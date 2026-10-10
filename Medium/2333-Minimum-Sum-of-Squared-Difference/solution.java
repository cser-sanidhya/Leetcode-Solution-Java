class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2; 
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums1[i] - nums2[i]));
        }
        
        if (maxDiff == 0) {
            return 0;
        }
        
        long[] count = new long[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
        }
        
        for (int d = maxDiff; d > 0; d--) {
            if (count[d] == 0) continue;
            if (k >= count[d]) {
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                count[d - 1] += k;
                count[d] -= k;
                k = 0; 
                break;
            }
        }
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                minSumSquare += count[d] * (long) d * d;
            }
        }
        return minSumSquare;
    }
}
