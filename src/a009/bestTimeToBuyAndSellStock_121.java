package a009;

/**
 * 121. Best Time to Buy and Sell Stock
 * DescriptionHintsSubmissionsDiscussSolution
 * Pick One
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class bestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        int maxpro = 0;
        int minprice = prices[0];

        for(int i = 0; i < prices.length; i++){//这个循环有recursion'的意思
            //对于每一个走过的区间, 每个区间 求出来最大利润, 然后 比较
            //
            minprice = Math.min(minprice, prices[i]);
            maxpro = Math.max(maxpro, prices[i] - minprice);
        }

        return maxpro;
    }

    public static void main(String[] args) {
        bestTimeToBuyAndSellStock_121 t = new bestTimeToBuyAndSellStock_121();
       int[] a = {2, 1};
        System.out.println(t.maxProfit(a));

    }
}
