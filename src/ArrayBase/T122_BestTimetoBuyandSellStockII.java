package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/14.
 */
public class T122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int result = 0;
        for (int i=1; i < prices.length; ++i){
            if (prices[i] - prices[i-1] > 0)
                result += prices[i] - prices[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        T122_BestTimetoBuyandSellStockII btbss = new T122_BestTimetoBuyandSellStockII();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(btbss.maxProfit(nums));
    }
}
