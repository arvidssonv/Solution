import java.util.*;

public class Solution implements SolutionInterface {
    int[] result;
    public Solution() {
        // You can initiate and calculate things here
        int numOfDays = API.getNumDays();
        int[] price = new int[numOfDays];
        for (int i = 0; i < price.length; i++) {
            price[i] = API.getPriceOnDay(i);
        }
        //System.out.println(Arrays.toString(price));
        int[] diff = new int[numOfDays];
        diff[0] = 0;
        for (int i = 1; i < diff.length; i++) {
            diff[i] = price[i] - price[i-1];    
        }
        //System.out.println(Arrays.toString(diff));
        this.result = max(diff);
    }

    public static int[] max(int[] diff) {
        // find the sequence of numbers in the diff array that gives the highest value, even if its a negative number
        // return is an array of the days to buy and sell, result[0] = buy, result[1] = sell
        int[] result = new int[2];
        int maxBuy = 0;
        int maxSell = 1;
        int buy = 0;
        int maxProfit = diff[maxSell];
        int currentProfit = 0;
        for (int i = 1; i < diff.length; i++) {
            currentProfit += diff[i];
            //System.out.println(currentProfit);
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxSell = i;
                maxBuy = buy;
            }
            if (currentProfit < 0) {
                currentProfit = 0;
                buy = i;
            }
        }
        //System.out.println(maxProfit);
        result[0] = maxBuy;
        result[1] = maxSell;
        return result;
    }

    /**
     * Return the day which you buy gold. The first day has number zero. This method is
     * called first, and only once.
     */
    public int getBuyDay() {
        // Write your code here
        return result[0];
    }

    /**
     * Return the day to sell gold on. This day has to be after (greater than) the buy
     * day. The first day has number zero (although this is not a valid sell day). This
     * method is called second, and only once.
     */
    public int getSellDay() {
        // Write your code here
        return result[1];
    }
}