package leetcode.editor.cn;
//来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮
//料每小时所能提供的强化能量。 
//
// 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获
//得任何强化能量）。 
//
// 返回在接下来的 n 小时内你能获得的 最大 总强化能量。 
//
// 注意 你可以选择从饮用任意一种能量饮料开始。 
//
// 
//
// 示例 1： 
//
// 
// 输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1] 
// 
//
// 输出：5 
//
// 解释： 
//
// 要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。 
//
// 示例 2： 
//
// 
// 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3] 
// 
//
// 输出：7 
//
// 解释： 
//
// 
// 第一个小时饮用能量饮料 A。 
// 切换到能量饮料 B ，在第二个小时无法获得强化能量。 
// 第三个小时饮用能量饮料 B ，并获得强化能量。 
// 
//
// 
//
// 提示： 
//
// 
// n == energyDrinkA.length == energyDrinkB.length 
// 3 <= n <= 10⁵ 
// 1 <= energyDrinkA[i], energyDrinkB[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 3 👎 0


public class P3259_MaximumEnergyBoostFromTwoDrinks {
    public static void main(String[] args) {
        Solution solution =  new P3259_MaximumEnergyBoostFromTwoDrinks().new Solution();
        int[] energyDrinkA = new int[]{4, 1, 1};
        int[] energyDrinkB = new int[]{1, 1, 3};
        long res = solution.maxEnergyBoost(energyDrinkA, energyDrinkB);
        System.out.println(res);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
         int n = energyDrinkA.length;
         long[][] dp = new long[n][2];
         for (int i = 0; i < n; i++) {
             if (i == 0) {
                 dp[i][0] = energyDrinkA[i];
                 dp[i][1] = energyDrinkB[i];
                 continue;
             }
             if (i == 1) {
                 dp[i][0] = energyDrinkA[i] + dp[i-1][0];
                 dp[i][1] = energyDrinkB[i] + dp[i-1][1];
                 continue;
             }
             dp[i][0] = Math.max(dp[i-1][0] + energyDrinkA[i], dp[i-2][1] + energyDrinkA[i]);
             dp[i][1] = Math.max(dp[i-1][1] + energyDrinkB[i], dp[i-2][0] + energyDrinkB[i]);
         }
         return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
