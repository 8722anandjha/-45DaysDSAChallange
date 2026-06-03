// Problem: Best Time to Buy and Sell Stock
// Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
Approach:
- Maintain the minimum buying price while traversing the array.
- For each day, calculate the possible profit:
  current price - minimum buying price.
- Update the maximum profit whenever a larger profit is found.
- If a smaller buying price is found, update the minimum price.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int i=0;
        for(int j=1;j<prices.length;j++){
            if(prices[j] < prices[i]) i=j;
            else if(profit < (prices[j] - prices[i])){
                profit= prices[j] - prices[i];
            }
        }
        return profit;
    }
}