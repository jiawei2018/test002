package a007;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class binaryTreeInorderTraversal_094_important {
      private class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      }
//三个遍历 必须掌握;

    /**
     * 二叉树遍历算法收集(先序 preorder，后序 postorder，中序 inorder） 循环+递归
     * preorder: root-left-right
     * inorder: left-root-right
     * postorder: left-right-root
     */

    public List<Integer> inorderTraversalA(TreeNode root) {//non-recursio
        //这题必须背会,必须超级熟练才行
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root ;
        while(temp != null || !st.isEmpty()){
            while(temp != null){//先左走到底
                st.push(temp);
                temp = temp.left;
            }
            temp = st.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }


        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) return res;
            inorder(root, res);
            return res;
        }
        private void inorder(TreeNode node, List<Integer> res){
          if(node == null) return;
          inorder(node.left, res);
          res.add(node.val);
          inorder(node.right, res);
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public List<Integer> preorderTraversalA(TreeNode root) {//non- recursion
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        //TreeNode temp ;

        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            res.add(temp.val);
            if(temp.right != null) st.push(temp.right);//此处顺序是逆序
            if(temp.left != null) st.push(temp.left);
        }
        return res;
    }



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return res;
    }
    private void preorder(TreeNode node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        inorder(node.left, res);
        inorder(node.right, res);
    }

////////////////////////////////////////////////////////////////////////
public List<Integer> postorderTraversalA(TreeNode root) {//non -recursion
    List<Integer> res = new ArrayList<>();
    if(root == null) return res;
    Stack<TreeNode> st = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();
    TreeNode temp ;
    st.push(root);
    //只考虑3个点的树
    while(!st.isEmpty()){
        temp = st.pop();
        //left -- right??此处注意是左--->  右的顺序,
        if(temp.left != null){
            st.push(temp.left);
        }

        if(temp.right != null){
            st.push(temp.right);
        }

        st2.push(temp);//这个永远是加的开头的那个,最后一样就是 右先,
    }

    while(!st2.isEmpty()){
        res.add(st2.pop().val);
    }

    return res;
}

    //对该方法仔细研究，就会发现stack2里面存储的就是后续遍历输出的整个顺序。
    //后序遍历就是【左右根】的形式输出。
    //所以stack1中先入根然后pop出来，然后入左和右。这样stack1先pop根，然后pop右，接着pop左；
    //正好，stack2先入根，然后入右，接着入左。
    //故，stack2 循环pop的时候就是【左右根】的顺序


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return res;
    }
    private void postorder(TreeNode node, List<Integer> res){
        if(node == null) return;
        inorder(node.left, res);
        inorder(node.right, res);
        res.add(node.val);
    }


    /**
     * 其实，仔细想想，先序输出的时候是【根左右】，后序输出是【左右根】，
     * 所以只需要按照先序遍历非递归的方法，输出的时候改改顺序即可。
     *

    public List<Integer> postorderTraversal5(TreeNode root) {
     *LinkedList<Integer> list = new LinkedList<>();
     *if (root == null) {
        *return list;
     *}
     *Stack<TreeNode> stack = new Stack<>();
     *TreeNode tempNode = root;
     *while (!stack.isEmpty() || tempNode != null) {
        *if (tempNode != null) {
             *stack.push(tempNode);
             *list.addFirst(tempNode.val);
             *tempNode = tempNode.right;
        *} else {
             *tempNode = stack.pop().left;
        *}
     *}
     *
     *return list;
     *}
             *该方法使用LinkedList
    每次都调用addFirst()方法，将结点添加到头部。
            *所以顺序就是【左】【右】【根】。
     */

}
