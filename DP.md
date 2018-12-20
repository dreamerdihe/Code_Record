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
 








