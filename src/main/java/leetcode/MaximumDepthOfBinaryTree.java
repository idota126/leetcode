package leetcode;

/**
 * @Description: https://leetcode.com/problems/maximum-depth-of-binary-datastructure.tree/
 * @Author idota
 * @Date 2019/3/1
 */
public class MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * @Author idota
     *
     * @Description //递归
     *
     * @Date  下午3:38 2019/3/1
     * @Param [root]
     * @return int
     **/
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null)return maxDepth(root.right) + 1;
        if(root.right == null) return maxDepth(root.left) + 1;
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }



}

