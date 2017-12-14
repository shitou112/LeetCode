package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/14.
 */
public class T121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length==0)
            return 0;

        int minIndexValue=prices[0], maxValue=0, value;
        for (int i=1; i < prices.length; ++i){
            if (minIndexValue > prices[i])
                minIndexValue = prices[i];
            else {
                value = prices[i] - minIndexValue;
                if (value > maxValue)
                    maxValue = value;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        T121_BestTimetoBuyandSellStock btbss = new T121_BestTimetoBuyandSellStock();
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(btbss.maxProfit(nums));
    }
}
