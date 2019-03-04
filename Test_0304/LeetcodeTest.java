package Test_0304;

import java.math.BigInteger;
import java.util.Arrays;

/*
121. 买卖股票的最佳时机 I
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。

示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
          注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
/*
 * 分析：
 * 方法一：
 * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
 * 方法二：
 * 贪心算法
 * 分析[7,1,5,3,6,4]，在第 2天买入，在第 5天卖出，利润最大
 * 而最大利润的计算方法可以如下，每次计算出当天和前一天的股票差，通过累加可以计算出在当天之前最低价格买入，当天天卖出的收益(假设可以为负)，
 * 收益为负时清零，收益大于记录的最大收益时，更新最大收益。
 * 如：第二天与前一天差值为-6，第一天买进，第二天卖出的收益为-6，也就是说亏了，因此将收益清零。
 *    第二天与前一天差值为4， 上一次收益清零，买进应该为第二天，第三天卖出的收益为4，收益大于记录的最大收益，更新最大收益。
 *    第三天与前一天差值为-2， 上一次收益没有清零，买进还是第二天，此时收益累加，第三天卖出的收益为4-2=2。
 *    以此类推。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();	
//		int[] prices = {7,1,5,3,6,4};
//		System.out.println(So.maxProfit1(prices));
//	}
//}
//class Solution {
//	public int maxProfit1(int[] prices) {
//    	int min = Integer.MAX_VALUE;//买入
//    	int max = 0;//利润
//        for(int i=0; i<prices.length; i++){
//        	min = Math.min(min, prices[i]);
//        	max = Math.max(max, prices[i]-min);
//        }
//        return max;
//    }
//    public int maxProfit2(int[] prices) {
//    	int max = 0;//记录最大收益
//    	int b = 0;
//    	for(int i = 0; i<prices.length-1; i++){
//    		int a = prices[i + 1] - prices[i];//后一天与前一天的差值
//    		b += a; //若在第i+1天之前最低价格买入，第i+1天卖出的收益(假设可以为负)    
//    		if (b<0){//收益为负时清零
//    			b = 0;
//    		}
//    		if(b>max){
//    			max = b;
//    		}
//    	}
//    	return max;
//    }
//}
/*
122. 买卖股票的最佳时机 II
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
         随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
        注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
       因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
/*
 * 分析：
 * 参考上述买卖股票的最佳时机 I的方法二，贪心算法后一天收益比前一天收益高就在后一天卖掉。
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();	
//		int[] prices = {7,1,5,3,6,4};
//		System.out.println(So.maxProfit(prices));
//	}
//}
//class Solution {
//    public int maxProfit(int[] prices) {
//    	int max = 0;
//        for(int i=0; i<prices.length-1; i++){
//        	int a =prices[i+1] - prices[i];
//        	if(a > 0){
//        		max += a;
//        	}
//        }
//        return max;
//    }
//}
/*
123. 买卖股票的最佳时机 III
 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
       随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
       注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
       因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:
输入: [7,6,4,3,1] 
输出: 0 
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
/*
 分析：
 四个变量（买减卖增，所以买入时收益为价格的负值，卖出时再加上卖出的价格）：
maxp_fbuy：当天第一次买入的最大收益，当天买入的收益是此次的价格负值;
maxp_fsell：当天第一次卖出的最大收益，当天卖出的收益是此次的价格+第一次买入后的收益;
maxp_sbuy：当天第二次买入的最大收益，当天买入的收益是第一次卖出时的收益-此次的价格;
maxp_ssell：当天第二次卖出的最大收益，当天卖出的收益是此次卖出的价格+第二次买入后的收益;
不断更新这四个变量使他们最大，最后最大收益为maxp_ssell。
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();	
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(So.maxProfit(prices));
	}
}
class Solution {
    public int maxProfit(int[] prices) {
        int maxp_fbuy = Integer.MIN_VALUE;
        int maxp_fsell = 0;
        int maxp_sbuy = Integer.MIN_VALUE;
        int maxp_ssell = 0;
        for(int i=0; i<prices.length; i++){
        	maxp_fbuy = Math.max(maxp_fbuy, -prices[i]);
        	maxp_fsell = Math.max(maxp_fsell, prices[i]+maxp_fbuy);
        	maxp_sbuy = Math.max(maxp_sbuy, maxp_fsell-prices[i]);
        	maxp_ssell = Math.max(maxp_ssell, prices[i]+maxp_sbuy);
        }
        return maxp_ssell;
    }
}