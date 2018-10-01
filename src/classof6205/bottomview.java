package classof6205;

import java.util.*;

public class bottomview {



        public static TreeMap<Integer, Integer> ht = new TreeMap<>();;
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    class QueuePack {
        int level;
        Node tnode;

        public QueuePack(int level, Node tnode) {
            this.level = level;
            this.tnode = tnode;
        }

    }
        public  void bottomView(Node root, int level) {
            if (root == null)
                return;
            Queue<QueuePack> queue = new LinkedList<>();
            queue.add(new QueuePack(level, root));
            while (!queue.isEmpty()) {
                QueuePack q = queue.remove();
                Node tnode = q.tnode;
                int lvl = q.level;
                ht.put(lvl, tnode.data);

                if (tnode.left != null) {
                    queue.add(new QueuePack(lvl - 1, tnode.left));
                }
                if (tnode.right != null) {
                    queue.add(new QueuePack(lvl + 1, tnode.right));
                }
            }

        }

        public static void display() { // print the bottom view.
            Set<Integer> keys = ht.keySet();
            for (Integer key : keys) {
                System.out.print(ht.get(key) + " ");
            }

        }
    public void PrintBottomView(Node root){
        HashMap<Integer, Node> dict = new HashMap<>();
        PrintBottomView(root, dict, 0);
        for(int c : dict.keySet()){
            System.out.println(dict.get(c).data);
        }

    }
       private void PrintBottomView(Node node, HashMap<Integer, Node> map, int cursor){
        if(node != null){

            if(map.containsKey(cursor)){
                map.replace(cursor, node);
            }
            else{
                map.put(cursor, node);
            }
            PrintBottomView(node.left, map, cursor -1);
            PrintBottomView(node.right, map, cursor +1 );
        }
    }

//    private void printTop(Node root, int dist, int lvl, HashMap<Integer, HashMap<Node, Integer>> map){
//        if(root == null) return;
//        if(map.containsKey(dist)   || lvl < map.get(dist).){
//            map.replace(dist, lvl);
//        }
//        printTop(root.left, dist - 1, lvl + 1, map);
//        printTop(root.right, dist + 1, lvl + 1, map);
//
//    }

    private void top_view(Node root)
    {
        Stack<Node> p = new Stack<Node>();
        Node current = root;
        while (current != null)
        {
            p.push(current);
            current = current.left;
        }

        while (p.peek() != root)
        {
            System.out.print(p.pop().data + " ");
        }

        current = root;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }










    private int height(Node node)
    {
        if (node == null)
            return 0;
        else
        {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }

    private int getMaxWidth(Node node)
    {
        int maxWidth = 0;
        int width;
        int h = height(node);
        int i;

        for (i = 1; i <= h; i++)        {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    int getWidth(Node node, int level)
    {
        if (node == null)
            return 0;

        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1)
                    + getWidth(node.right, level - 1);
        return 0;
    }



















}


