package laioffer_final;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class p02 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isCusin(TreeNode root, TreeNode one ,TreeNode  two){
        //bfs it;
        if(root.left == null && root.right == null){
            return  false;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> parent = new HashSet<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode tmp = q.poll();
                if(tmp.left != null ){
                    if(tmp.left == one || tmp.left == two){
                        parent.add(tmp);
                    }
                    q.offer(tmp.left);
                }

                if(tmp.right != null ){
                    if(tmp.right == one || tmp.right == two){
                        if(parent.size() > 0 && parent.add(tmp)){
                            return true;
                        }else if (parent.size() > 0 && !parent.add(tmp)){
                            return false;
                        }
                    }
                    q.offer(tmp.right);
                }
            }
            parent.clear();
        }


        return false;
    }
}
