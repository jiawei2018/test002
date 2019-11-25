package tree;


import java.util.*;

public class inOrder {
    public List<Integer> inorder(TreeNode root) {
        if(root == null ) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        firstNode(stack, root);

        while(!stack.isEmpty()){
            //we want top node in stack is inorder traverse one


            TreeNode cur = stack.pop();
            res.add(cur.val);
            //1.cur.right == null; then parent
            //2.right != null then goto right-subtree
            firstNode(stack, cur.right);
        }

        return res;
    }

    private void firstNode(Deque<TreeNode> stack, TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v){
        val = v;
    }
}
/*
*            1
*          /   \
*         2     5
*        /  \
*       3    4
*
*   left-root-right
*
* */
