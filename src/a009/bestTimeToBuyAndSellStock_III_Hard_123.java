package a009;

/**
 * 123. Best Time to Buy and Sell Stock III
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class bestTimeToBuyAndSellStock_III_Hard_123 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int tradeTimes = 2;
        int[][] globe = new int[prices.length ][tradeTimes + 1];
        int[][] local = new int[prices.length ][tradeTimes + 1];

        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i - 1];
            for(int t = 1; t <= tradeTimes; t++){
                local[i][t] = Math.max(globe[i - 1][t - 1] + Math.max(diff, 0) , local[i - 1][t] + diff );
                //也就是看两个量，第一个是全局到 i-1 天进行 j-1 次交易，
                // 然后加上今天的交易，如果今天是赚钱的话
                // （也就是前面只要j-1次交易，最后一次交易取当前天），
                // 第二个量则是取local第  i-1 天  j次交易，
                //  然后加上今天的差值（这里因为 local[i-1][j] 比如包含第 i-1 天卖出的交易，
                // 所以现在变成第 i 天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，
                //  因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。



                globe[i][t] = Math.max(globe[i - 1][t], local[i][t]);
                //   也就是取当前局部最好的，和过往全局最好的中大的那个
                // （因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。
            }

        }

        return globe[prices.length - 1][tradeTimes];

    }

    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        bestTimeToBuyAndSellStock_III_Hard_123 t = new bestTimeToBuyAndSellStock_III_Hard_123();
        System.out.println(t.maxProfit(a));


    }


    /**
     *  public int maxProfit(int[] prices) {
     *         int n = prices.length;
     *         if(n == 0) return 0;
     *
     *         int[][] maxProfit = new int[3][n];
     *
     *         for(int i = 1; i <= 2; i++) {//means 1st time of buy ,2 == 2nd time of buy
     *
     *             int balance = -prices[0];//余额
     *                 // int thismin = prices[0];
     *
     *             for(int j = 1; j < n; j++) {
     *                 maxProfit[i][j] = Math.max(maxProfit[i][j - 1], balance + prices[j]);
     *
     *                 //maxProfit[i][j] = Math.max(maxProfit[i][j - 1],  prices[j] - thismin);
     *                 //  balance + prices[j]  ==>  prices[j] - prives[i]; also means maxProfit
     *                 //对于第一次购买来说, 其实 balance 就是 那个 min ,因为负数越大 余额接近 0 ;
     *                 //上面的其实就翻译成  Math.max(maxProfit[i][j - 1], prices[j] - min);
     *                 //下面这个找最小值的过程,翻译过来就是Math.min(min, prices[j]);
     *                 //因为对于第一次,第零次显然就都是0;
     *                 //********************************************************************
     *
     *
     *                 balance = Math.max(balance, maxProfit[i - 1][j - 1] - prices[j]);
     *                 //thismin = Math.min(thismin,  prices[j] - maxProfit[i - 1][j - 1]);
     *             }
     *         }
     *
     *         return maxProfit[2][n - 1];
     *     }
     *
     */


    /**
     * 这道题是Best Time to Buy and Sell Stock的扩展，
     * 现在我们最多可以进行两次交易。我们仍然使用动态规划来完成，
     * 事实上可以解决非常通用的情况，也就是最多进行k次交易的情况。
     * 这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。
     * 我们还是使用“局部最优和全局最优解法”。我们维护两种量，
     * 一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
     * 另一个是当前到达第i天，最多可进行j次交易，
     * 并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
     * 下面我们来看递推式，全局的比较简单，
     *
     * global[i][j]=max(local[i][j],global[i-1][j])，
     *
     * 也就是去当前局部最好的，和过往全局最好的中大的那个
     * （因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。
     * 对于局部变量的维护，递推式是
     *
     * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
     *
     * 也就是看两个量，第一个是全局到 i-1 天进行 j-1 次交易，
     * 然后加上今天的交易，如果今天是赚钱的话
     * （也就是前面只要j-1次交易，最后一次交易取当前天），
     *
     * 第二个量则是取local第  i-1 天  j次交易，
     * 然后加上今天的差值（这里因为 local[i-1][j] 比如包含第 i-1 天卖出的交易，
     * 所以现在变成第 i 天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，
     * 因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
     * 上面的算法中对于天数需要一次扫描，而每次要对交易次数进行递推式求解，
     * 所以时间复杂度是O(n*k)，如果是最多进行两次交易，那么复杂度还是O(n)。
     * 空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)。
     * 代码如下：
     *
     *  public int maxProfit(int[] prices) {
         * if(prices==null || prices.length==0)
             *  return 0;
         * int[] local = new int[3];
         * int[] global = new int[3];
     *
         * for(int i=0;i<prices.length-1;i++)    {
             * int diff = prices[i+1]-prices[i];
             * for(int j=2;j>=1;j--) {
                 * local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                 * global[j] = Math.max(local[j],global[j]);
             * }
         * }
         * return global[2];
     * }
     * 可以看到，这里的模型是比较复杂的，
     * 主要是在递推式中，local和global是交替求解的。不过理清思路之后，
     * 代码是非常简练的，不禁感叹算法真是牛逼哈，这么个复杂生活问题几行代码就解决了。
     *



     */


    /**
     * 这道题求进行一次交易能得到的最大利润。如果用brute force的解法就是对每组交易都看一下利润，
     * 取其中最大的，总用有n*(n-1)/2个可能交易，所以复杂度是O(n^2)。
     * 很容易感觉出来这是动态规划的题目，其实跟Maximum
     *  Subarray非常类似，用“局部最优和全局最优解法”。
     *  思路是维护两个变量，一个是到目前为止最好的交易，
     *  另一个是在当前一天卖出的最佳交易（也就是局部最优）。
     *  递推式是
     *  local[i+1]=max(local[i]+prices[i+1]-price[i],0),
     *  global[i+1]=max(local[i+1],global[i])。
     *  这样一次扫描就可以得到结果，时间复杂度是O(n)。
     *  而空间只需要两个变量，即O(1)。代码如下：
     *   public int maxProfit(int[] prices) {
         *  if(prices==null || prices.length==0)
         *  return 0;
         *  int local = 0;
         *  int global = 0;
         *  for(int i=0;i<prices.length-1;i++)    {
             *  local = Math.max(local+prices[i+1]-prices[i],0);
             *  global = Math.max(local, global);
         *  }
         *  return global;
     *  }
     *  这种题目的解法非常经典，不过是比较简单的动态规划。这道题目还有两个变体，Best
     *  Time to Buy and Sell Stock II和Best
     *  Time to Buy and Sell Stock III，虽然题目要求比较像，但是思路却变化比较大，
     *  Best
     *  Time to Buy and Sell Stock II可以交易无穷多次，
     *  思路还是比较不一样，
     *  而Best
     *  Time to Buy and Sell Stock III则限定这道题交易两次，
     *  其实还可以general到限定交易k次，会在这道题目中仔细讲解，
     *  有兴趣的朋友可以看看哈。
     *
     * ---------------------
     *
     * 本文来自 Code_Ganker 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/linhuanmars/article/details/23162793?utm_source=copy
     */
















}
