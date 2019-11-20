package a007;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

/**
 * 94. Binary Tree Inorder Traversal
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class binaryTreeInorderTraversal_094_important {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//三个遍历 必须掌握;
        TreeMap<Integer,Integer> tree = new TreeMap<>();
    /**
     * 二叉树遍历算法收集(先序 preorder，后序 postorder，中序 inorder） 循环+递归
     * preorder: root-left-right
     * inorder: left-root-right
     * postorder: left-right-root
     */

    public List<Integer> inorderTraversalA(TreeNode root) {//non-recursio
        //这题必须背会,必须超级熟练才行
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !st.isEmpty()) {
            if (temp != null) {//先左走到底
                st.push(temp);
                temp = temp.left;
            }else {
                TreeNode parent = st.pop();
                res.add(parent.val);
                temp = parent.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public List<Integer> preorderTraversalA(TreeNode root) {//non- recursion
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        //TreeNode temp ;

        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            res.add(temp.val);
            if (temp.right != null) st.push(temp.right);//此处顺序是逆序
            if (temp.left != null) st.push(temp.left);
        }
        return res;
    }

    public List<Integer> inorderTraversalLai(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode parent = stack.pop();
                res.add(parent.val);
                root = parent.right;
            }
        }

        return res;
    }



    ////////////////////////////////////////////////////////////////////////
    public List<Integer> postorderTraversalA(TreeNode root) {//non -recursion
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode temp;
        st.push(root);
        //只考虑3个点的树
        while (!st.isEmpty()) {
            temp = st.pop();
            //left -- right??此处注意是左--->  右的顺序,
            if (temp.left != null) {
                st.push(temp.left);
            }

            if (temp.right != null) {
                st.push(temp.right);
            }

            st2.push(temp);//这个永远是加的开头的那个,最后一样就是 右先,
        }

        while (!st2.isEmpty()) {
            res.add(st2.pop().val);
        }

        return res;
    }



    //来offer方法
    public ArrayList<Integer> postorderTraversalI(TreeNode root) {

        ArrayList<Integer> resList = new ArrayList<Integer>();

        if (root == null)
            return resList;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode current = stack.peek();

            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if (prev == null || prev.left == current || prev.right == current) {
                //prev == null is the situation for the root node
                //prev.left == current || prev.right == current  means prev is root
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    resList.add(current.val);
                    stack.pop();
                }

                //go up the tree from left node
                //need to check if there is a right child
                //if yes, push it to stack
                //otherwise, process parent and pop stack
            } else if (current.left == prev) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {//right == null
                    resList.add(current.val);
                    stack.pop();
                }

                //go up the tree from right node
                //after coming back 5from right node, process parent node and pop stack.
            } else {// if(current.right == prev)
                resList.add(current.val);
                stack.pop();
            }

            prev = current;
        }

        return resList;
    }



    //from piazza
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.offerFirst(root);
                root = root.left;
            }
            TreeNode temp = stack.peek();
            if(temp.right == null || temp.right == prev){
                res.add(stack.pollFirst().val);
            }else{
                root = temp.right;
            }
            prev = temp;
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

    private void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
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
