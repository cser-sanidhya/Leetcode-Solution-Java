class Solution {
    public long countCommas(long n) {
        return count(n);
    }

    private long count(long n) {
        if (n < 1000) {
            return 0;
        }

        long ans = 0;

        ans += n - 999;

        if (n >= 1_000_000) {
            ans += n - 999_999;
        }

        if (n >= 1_000_000_000L) {
            ans += n - 999_999_999L;
        }


        return ans;
    }

    public long countCommasInRange(int left, int right) {
        return count(right) - count(left - 1);
        
    }
}
