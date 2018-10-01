package classof6205;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class topview {

    // Class for a tree node
    class TreeNode {
        int key;
        TreeNode left, right;
        public TreeNode(int key)
        {
            this.key = key;
            left = right = null;
        }
    }

    class QItem {
        TreeNode node;
        int hd;
        public QItem(TreeNode n, int h)
        {
            node = n;
            hd = h;
        }
    }

    class Tree {
        TreeNode root;

        public Tree() { root = null; }
        public Tree(TreeNode n) { root = n; }

        public void printTopView()
        {
            if (root == null) {
                return;
            }

            HashSet<Integer> set = new HashSet<>();

            Queue<QItem> Q = new LinkedList<QItem>();
            Q.add(new QItem(root, 0));

            while (!Q.isEmpty()) {
                QItem qi = Q.remove();
                int hd = qi.hd;
                TreeNode n = qi.node;

                if (!set.contains(hd)) {
                    set.add(hd);
                    System.out.print(n.key + " ");
                }

                if (n.left != null)
                    Q.add(new QItem(n.left, hd - 1));
                if (n.right != null)
                    Q.add(new QItem(n.right, hd + 1));
            }
        }
    }
}
