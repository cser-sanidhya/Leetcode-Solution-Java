class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow;
        ListNode prev = null;
        ListNode current = secondHalf;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode first = head;
        ListNode second = prev;
        while(second != null) {
            if(first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
