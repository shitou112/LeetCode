package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/14.
 */
public class T123_BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i = 0; i < prices.length; i++){
            //在该价格点卖出第二笔股票后手里剩的钱，等于上一轮买入第二笔股票后手里剩的钱加上卖出当前股票价格的钱，或者上一轮卖出第二笔股票后手里剩的钱两者中较大的
            release2 = Math.max(release2, hold2 + prices[i]);
            //在该价格点买入第二笔股票后手里剩的钱，等于上一轮卖出第一笔股票后手里剩的钱减去买入当前股票价格的钱，或者上一轮买入第二笔股票后手里剩的钱两者中较大的
            hold2 = Math.max(hold2, release1 - prices[i]);
            //在该价格点卖出第一笔股票后手里剩的钱，等于上一轮买入第一笔股票后手里剩的钱加上卖出当前股票价格的钱，或者上一轮卖出第一笔股票后手里剩的钱两者中较大的
            release1 = Math.max(release1, hold1 + prices[i]);
            //在该价格点买入第一笔股票后手里剩的钱，等于初始资金减去买入当前股票价格的钱或者初始资金（不买）中较大的
            hold1 = Math.max(hold1, -prices[i]);
            System.out.println(prices[i]+":  "+hold1+"  "+release1+"  "+ hold2+"   "+ release2);
        }
        return release2;
    }

    public static void main(String[] args) {
        T123_BestTimetoBuyandSellStockIII btbss = new T123_BestTimetoBuyandSellStockIII();
        int[] nums = { 3,    1,    2,    8 ,   3 ,   4 ,   9  ,  6, 1, 100};
        System.out.println(btbss.maxProfit(nums));
    }
}
