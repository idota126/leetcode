# leetcode 随笔
leetcode practice

##二叉树 一些特性 
       用二叉树后序比遍历 + stack 可以轻松实现 计算表达式
       ![Image text](https://raw.githubusercontent.com/idota126/leetcode/master/media/mathematical_expression.png)
       
       Also, post-order is widely use in mathematical expression. It is easier to write a program to parse a post-order expression. Here is an example:
       You can easily figure out the original expression using the inorder traversal. However, it is not easy for a program to handle this expression since you have to check the priorities of operations.
       
       If you handle this tree in postorder, you can easily handle the expression using a stack. Each time when you meet a operator, you can just pop 2 elements from the stack, calculate the result and push the result back into the stack.
##ArrayDeque
查看ArrayDeque实现时候发现一段有意思的代码:
       
       private void allocateElements(int numElements) {
               int initialCapacity = MIN_INITIAL_CAPACITY;
               // Find the best power of two to hold elements.
               // Tests "<=" because arrays aren't kept full.
               if (numElements >= initialCapacity) {
                   initialCapacity = numElements;
                   initialCapacity |= (initialCapacity >>>  1);
                   initialCapacity |= (initialCapacity >>>  2);
                   initialCapacity |= (initialCapacity >>>  4);
                   initialCapacity |= (initialCapacity >>>  8);
                   initialCapacity |= (initialCapacity >>> 16);
                   initialCapacity++;
       
                   if (initialCapacity < 0)   // Too many elements, must back off
                       initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
               }
               elements = new Object[initialCapacity];
           }
       

这段代码作用分配数组大小：
传入任意值都会返回通过5次右移和位或操作 得到一个2^k-1 的值，
然后再将此值+1 得到2^k; 
如果传至超过2^30 则返回2^30
(因为ArrayDequed队列容量有特殊要求 必须是2^n);   

###位运算       
       带符号右移：>>  
       带符号左移：<< 
       无符号右移:>>> 
       a>>n等价于a/2^n; 
       a<<1等价于a*2^n;
int a = -1; java 中 int 类型4字节 每个字节8位 所以int 范围 -2^31~2^31-1;
    
    负数最高位符号位1
    a>>1:
    源码:10000000 00000000 00000000 00000001
    反码:11111111 11111111 11111111 11111110
    补码:11111111 11111111 11111111 11111111（在反码的基础上+1）
    a>>1:11111111 11111111 11111111 11111111 (右移动一位 高位在补1)
    反码:11111111 11111111 11111111 11111110(在补码基础上-1)
    源码:10000000 00000000 00000000 00000001 = -1(带上符号) 
    
    
    a<<1:
    源码:10000000 00000000 00000000 00000001
    反码:11111111 11111111 11111111 11111110
    补码:11111111 11111111 11111111 11111111（在反码的基础上+1）
    a<<1:11111111 11111111 11111111 11111110 (左移动一位 低位在0填充)
    反码:11111111 11111111 11111111 11111101 (在补码基础上-1)
    源码:10000000 00000000 00000000 00000010 = -2 (带上符号)
    
    a>>>1: 
    源码: 10000000 00000000 00000000 00000001
    反码: 11111111 11111111 11111111 11111110
    补码: 11111111 11111111 11111111 11111111（在反码的基础上+1）
    a>>>1:0111111 11111111 11111111 11111111 (无符号 系统会当做正数处理) = 2^31-1    
    