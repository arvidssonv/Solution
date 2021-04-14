import java.util.*;

public class Solution implements SolutionInterface {
    int[] buyAndSellDay;
    public Solution() {
        // You can initiate and calculate things here
        int numOfDays = API.getNumDays();
        int maxBuy = 0;
        int maxSell = 1;
        int buyDay = 0;
        int maxProfit = Integer.MIN_VALUE;
        int currentProfit = 0;
        int previousDaysPrice = API.getPriceOnDay(0);

        for (int i = 1; i < numOfDays; i++) {            
            int todaysPrice = API.getPriceOnDay(i);
            currentProfit += (todaysPrice - previousDaysPrice);
            previousDaysPrice = todaysPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxSell = i;
                maxBuy = buyDay;
            }
            if (currentProfit < 0) {
                currentProfit = 0;
                buyDay = i;
            }
        }
        
        int[] result = new int[2];
        result[0] = maxBuy;
        result[1] = maxSell;
        this.buyAndSellDay = result;
    }

    /**
     * Return the day which you buy gold. The first day has number zero. This method is
     * called first, and only once.
     */
    public int getBuyDay() {
        // Write your code here
        return buyAndSellDay[0];
    }

    /**
     * Return the day to sell gold on. This day has to be after (greater than) the buy
     * day. The first day has number zero (although this is not a valid sell day). This
     * method is called second, and only once.
     */
    public int getSellDay() {
        // Write your code here
        return buyAndSellDay[1];
    }
}