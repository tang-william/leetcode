package leetcode.editor.cn;
// [70]爬楼梯

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


class ClimbingStairs {
    public int climbStairs(int n) {
        int a1 = 1, a2 = 2;
        if (n == 1) {
            return  1;
        } else if (n == 2) {
            return  2;
        }
        for (int i=3; i <= n; i++) {
            int tmp = a1 + a2;
            a1 = a2;
            a2 = tmp;
        }
        return a2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
f(n) = f(n-1) + f(n-2)
 */