# leetcode
leetcode practice 

二叉树 一些特性 
       用二叉树后序比遍历 + stack 可以轻松实现 计算表达式
       ![Image text](https://raw.githubusercontent.com/idota126/leetcode/master/media/mathematical_expression.png)
       
       Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression. Here is an example:
       You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations.
       
       If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.
