class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>Seen = new HashSet<>();
        while(n!=1){
            if(Seen.contains(n)) {
                return false;
            }
            Seen.add(n);
            n = getNextNumber(n);
        }
        return true;
    }
    public int getNextNumber (int n) {
        int Sum = 0;
        while(n>0) {
            int digit = n%10;
            Sum += digit*digit;
            n = n / 10;
        }
        return Sum;
    }
}
