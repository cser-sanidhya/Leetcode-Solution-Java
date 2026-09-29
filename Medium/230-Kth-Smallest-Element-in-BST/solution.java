class Solution {
    int k;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        solve(root);
        return answer;
    }
    private void solve(TreeNode root) {
        if(root == null) return;
        solve(root.left);
        k--;
        if(k==0) {
            answer = root.val;
            return;
        }
        solve(root.right);
    }
}
