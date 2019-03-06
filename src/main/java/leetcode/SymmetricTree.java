package leetcode;

/**
 * @Description: https://leetcode.com/problems/symmetric-tree/
 * @Author idota
 * @Date 2019/3/6
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricLeftRight(root.left, root.right);
    }

    private boolean isSymmetricLeftRight(TreeNode left, TreeNode right) {
        boolean result = true;
        if (left == null && right == null) {
            return true;
        }
        if (left !=null && right!=null  && left.val == right.val ) {
            result = result && isSymmetricLeftRight(left.left, right.right);
            result = result && isSymmetricLeftRight(left.right, right.left);
            return result;
        }
        return false;

    }

}
