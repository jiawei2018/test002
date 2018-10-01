package a009;

/**
 * 122. Best Time to Buy and Sell Stock II
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
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
public class bestTimeToBuyAndSellStock_II_122 {
    public int maxProfit(int[] prices) {
//        分析二：
//  同样对于这个波动曲线，低进高出，每一天间隔划分为相应的收益段，把所有的正的价格差相加起来。
//  实现通过： 把原始价格序列变成差分序列（见下面C++源码）
        //所谓利润最大化就是 每次上升曲线都有,所以这就是答案
        int maxpro = 0;//边界条件没用,不管输入啥,最小都是0

        for(int i = 1; i < prices.length; i++){
            maxpro += Math.max((prices[i ] - prices[i - 1]), 0);
        }
        return maxpro;
    }

}


/**
 * 分析一： 
 * 对于一个股票的价格走势，多次买入卖出使收益最大。目标就是找出这个股市波动曲线中一段段的上升曲线，对于每一个上升曲线，计算其收益，最后受益相加。（详见下面Java源码）
 *
 * 分析二：
 * 同样对于这个波动曲线，低进高出，每一天间隔划分为相应的收益段，把所有的正的价格差相加起来。
 * 实现通过： 把原始价格序列变成差分序列（见下面C++源码）
 *分析一：Java源代码
 *
 * public static int maxProfit(int[] prices) {
 * if (prices.length == 0)
 *      return 0;
 * int i = 0;
 * int profit = 0;
 * int begMin = prices[0];
     * for (i = 1; i < prices.length; ++i) {
             * if (prices[i] < prices[i - 1]) {
                 * profit += prices[i - 1] - begMin;
                 * begMin = prices[i];
             * }else if (i == prices.length-1){
             *      profit += prices[i] - begMin;
     *          }
     *      begMin = Math.min(begMin, prices[i]);
     *  }
 *      return profit;
 * }
 *
 * 分析二： C++源代码
 *
 *     int maxProfit(vector<int> &prices) {        int sum=0;        for(int i=1; i<prices.size(); i++){            int diff = prices[i]-prices[i-1];            if( diff>0 )                sum += diff;        }        return sum;    }
 *
 *
 */
