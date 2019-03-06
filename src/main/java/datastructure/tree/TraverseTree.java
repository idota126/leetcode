package datastructure.tree;

import java.util.*;
/**
 * Created by idota126 on 2019-03-03.
 */
public class TraverseTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }



    public List<Integer> preOrder(TreeNode root){
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> resultList = new LinkedList<>();
        resultList.add(root.val);
        if(preOrder(root.left).size()>0){
            resultList.addAll(preOrder(root.left));
        }
        if(preOrder(root.right).size()>0){
            resultList.addAll(preOrder(root.right));
        }
        return resultList;
    }


    public List<Integer> inorderTraversal(TreeNode root ){
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> resultList = new LinkedList<>();
        if(inorderTraversal(root.left).size()>0){
            resultList.addAll(inorderTraversal(root.left));
        }
        resultList.add(root.val);
        if(inorderTraversal(root.right).size()>0){
            resultList.addAll(inorderTraversal(root.right));
        }
        return resultList;
    }

    public List<Integer> postorderTraversal(TreeNode root ){
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> resultList = new LinkedList<>();
        if(postorderTraversal(root.left).size()>0){
            resultList.addAll(postorderTraversal(root.left));
        }
        if(postorderTraversal(root.right).size()>0){
            resultList.addAll(postorderTraversal(root.right));
        }
        resultList.add(root.val);

        return resultList;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> integerList = new TraverseTree().preOrder(root);
        System.out.println(integerList);
    }
}
