# Remarks for DP problems

* 5 Longest Palindromic Substring: Simple, the main idea is to gradually increse the length of the palindrome. Note, `isPalindrome(s[i:j]) = s[i] == s[j] && isPalindrome(s[i-1: j+1])`
* 53 Maximum Subarray: 这道题需要维护一个状态：到i时的最大子序列的值max，而维护这个值 需要两个值 1. 以i结尾的最大子序列的值ending 2. 最大子序列的值。 这样 
```java
ending = max(ending + nums[i + 1], nums[i + 1])
max = max(ending, max);
```
* 70 Climbing Stairs: easy DP: `A[i] = A[i-1] + A[i-2]` 其中`A[i]` 表示爬到第i层时有多少种可能性
* 198 House Robber: easy DP: `A[i] = max(A[i-1], A[i-2] + nums[i])` 其中`A[i]`表示n=i时最多能偷多少钱。所以只偷前i间房的最大收益 = 偷了前i-1间房的收益 与 偷了前i-2间房的收益加上偷第i件的收益合 之间的最大值
* 338 Counting Bits:  `A[2^k + i] = 1 + A[i]`
```
| num        | binary      | range  |
|------------|-------------|--------|
| 0          | 0           | [0, 1) |
 ------------------------------------
| 1          | 1           | [1, 2) |
 ------------------------------------
| 2          | 10          | [2, 4) |
| 3          | 11          | [2, 4) |
 ------------------------------------
| 4          | 100         | [4, 8) |
| 5          | 101         | [4, 8) |
| 6          | 110         | [4, 8) |
| 7          | 111         | [4, 8) |
```
* 139 Word Break: 
    * 一种是记忆化
    *  dp
  
  这道题的brute force解法是直接用backtracking。但是问题在会有重复运算。比如 已经用`a`验证过[aa]这样的start是false的， 下一次 还会用`aa`在进行一遍。所以利用记忆化来储存之前失败的start。而dp的考虑方式是`dp[i] = (dp[j] && s[j,i] in wordDict) for j < i`本质上是记忆化了成功的start.
* 152 Maximum Product Subarray: 这道题 要维护三个状态量 `max`、 `min` 、 `result`. `max`最后一个元素是当前元素的子数组相乘结果的最大值，`min`最后一个元素是当前元素的子数组相乘结果的最小值。循环数组nums，每次有`result = max(result, max)`。 而状态转移关系式为`max = max(max * num[i], min * num[i], num[i])` 与 `min = min(max * num[i], min * num[i], num[i])`
* 96 Unique Binary Search Trees: 这道题`dp[i`]表示 1 ~ i 有多少个不同的bft。 考虑`dp[i]`: 每次取第j个元素作为root 则root左边是 1 ~ j - 1的情况，root右边是 j + 1 ~ i 的情况。 则 `dp[i] = sum(dp[j-1] * dp[i-j])`
* 95 Unique Binary Search Trees II: 这道题与上一道题一样，但是注意要写一个以j为offset的clone函数，使从1～i的排列变为 1 + offset ～ i + offset的排列 
* 279 Perfect Squares: `d[i]` 表示这道题n = i的结果。则`dp[i] = min(dp[i - j]) j = 1,4,9....,sqrt(i)^2`
* 64 Minimum Path Sum: 属于虽短路径型问题 `O(m * n)`的时间复杂度 `O(m * n)`的空间复杂度。`dp[i][j]`表示走到`(i, j)`的最短路径的sum.状态转移方程 `dp[i][j] = gird[i][j] + min(dp[i-1][j], dp[i][j-1])`
* 62 Unique Paths: 同64. dp[i][j]表示有多少条路径到达(i, j). 则状态转移方程为 `dp[i][j] = dp[i-1][j] + dp[i][j-1]`
* 303 Range Sum Query - Immutable: 太简单。
* 647 Palindromic Substrings: 这道题使用extend方法。具体操作是：考虑所有以`s[i]`为或`s[i:i+1]`中心的palindrome.这道题关键之处了如果`s[i:j]`不是palindrome了，`s[i-1:j+1]`也一定不会是palindrome。而我一开始使用的方法，即考虑以`s[i]`为开头的所有子字符串是不是palindrom就没有利用到上述的这个性质。所以palindrome的最核心点左右关于palindrom的判断都是是从中心开始的。
* 413 Arithmetic Slices: 这道题我用了公式，没有用dp
* 91 Decode Ways: 注意出现0的情况。 比如“0”， “101”这样的情况。 dp[i]表示前i个元素有多少种decode的方式。然后`dp[i] = dp[i-1](s[i] != 0) + dp[i - 2](s[i-1:i] < 27)`
* 322 Coin Change: 注意处理dp[i] = -1时的情况。 dp[i]表示amount = i时最少换多少硬币。 另外 初始值设为amount + 1在之后dp操作中回简单点
* 357 Count Numbers with Unique Digits: 不算是一个好题。就是最简单的排列组合
* 309 Best Time to Buy and Sell Stock with Cooldown: 这道题太巧妙，需要重新做一遍。思考：关于dp，有一个的定义。状态(state): 在这题中，状态就是`buy, sell, rest(包含cooldown)`. 这就类似一个状态机一样的东西。所以要维护3个状态的dp数组。但是这道题可以通过证明 表示只维护两个就行。`sell[i]`表示在第i天时最后操作的是sell的情况下的profit, `buy[i]`表示在第i天时最后操作是buy的情况下的profit。那么:
```java
                        buy[i] = max(buy[i - 1], sell[i - 2] - price) 
                        sell[i] = max(buy[i - 1] + price, sell[i - 1])
```
* 264 Ugly Number II: 这道题很强: 
```
(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
```
利用类似于merge sort的思想去做这道题。 但是注意fact每次用的是dp[fact2]里的值。即：k x 2中的k只能是ugly unmber因而一定在dp中。
* 300 Longest Increasing Subsequence: 这题也很强。这题只想出来了`O(n^2)`的dp方法。其方法就是利用一个dp数组, `dp[i]`表示`nums[0:i]`中的最长子序列的长度。考虑`dp[i+1]`: 对于`nums[i+1]`, 如果他大于`nums[k](k < i+1)` 那么我们就可以把`nums[i+1]`拼在`dp[k]`之后扩展这个最长子序列.但是我们想要最长的子序列，那我们就把另`dp[i+1]`为上述方法拓展出来的最长子序列的长度。
* 343 Integer Break: 这道题最快的方法使用math的方法。但必须知道如果a想有其加数的乘积的最大值，则令其乘数尽量为2或者3; 而对于dp来说，`O(n^2)` 我们利用dp[i]储存n=i的结果，从而`dp[i] = max(dp[i], max(j, dp[j]) * max(dp[i-j], i-j))`
* 221 Maximal Square: 这道题是`O(n^2)`的。维持一个`dp[m][n]`的数组, 用来记录下由`(0, 0)`和`(i, j)`生成的矩形中以`(i, j)`为右下顶点的`‘1’`方阵变长。从而`dp[i][j] = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])`
* 375 Guess Number Higher or Lower II: 这道题很强。关键点在于dp数组如何计算。列出矩阵，发现想计算`dp[1][j]`必须要先计算`dp[1][i]`与`dp[i][j]`.而`dp[i][j]`要有`dp[i][k]`到`dp[k][j]`所以要从dp[j][j] -> dp[i][k]这样计算。可能写的不太对 一定要自己画个矩阵比划比划。
* 516 Longest Palindromic Subsequence: 这道题，是要记录一个dp[i][j]表示string[i][j]之中的最多含有几个palindorme.如果string[i] == string[j] 那么 dp[i][j] = 2 + dp[i+1][j-1] 否则则有：dp[i][j] = max(dp[i+1][j], dp[i][j-1])







 








