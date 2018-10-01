package a007;

/**
 * 96. Unique Binary Search Trees
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class uniqueBinarySearchtree_096 {
    public int numTrees(int n) {

        //lanziwang  solution
        //意思是左子树的节点从0个到 i-1 个节点, 左子树的个数和右树的个数 乘积就是 总可能性
        //使用两个状态来记录：
        //
        //G(n)：长度为n的序列的所有唯一的二叉树。
        //F(i,n)，1<=i<=n：以i作为根节点的二叉树的数量。
        //G(n)就是我们要求解的答案，G(n)可以由F(i,n)计算而来。
        //G(n)=F(1,n)+F(2,n)+...+F(n,n)                      (1)
        //G(0)=1,G(1)=1
        //对于给定的一个序列1.....n，我们取i作为它的根节点，那么以i作为根节点的二叉树的数量F(i)可以由下面的公式计算而来：
        //F(i,n)=G(i-1)*G(n-i) 1<=i<=n                         (2)
        //综合公式（1）和公式（2），可以看出：
        //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
        //这就是上面这个问题的答案。
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                nums[i] += nums[j] *nums[i-1-j];
            }
        }
        return nums[n];
    }

}
