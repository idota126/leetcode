package leetcode;

/**
 * @Description: https://leetcode.com/problems/path-sum/
 * @Author idota
 * @Date 2019/3/6
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return isValid(root, 0, sum);
    }

    private boolean isValid(TreeNode child, int pretotal, int sum) {
        if (child == null) {
            return false;
        }
        //叶子节点 左右子节点都为空！！！
        if(child.left==null&&child.right==null){
            if(child.val+pretotal == sum ){
                return true;
            }else{
                return false;
            }
        }
        return isValid(child.left, child.val + pretotal, sum)
                || isValid(child.right, child.val + pretotal,sum);
    }

}
