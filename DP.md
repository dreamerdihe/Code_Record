# Remarks for DP problems

* 5. Longest Palindromic Substring: Simple, the main idea is to gradually increse the length of the palindrome. Note, `isPalindrome(s[i:j]) = s[i] == s[j] && isPalindrome(s[i-1: j+1])`
* 53. Maximum Subarray: 这道题需要维护一个状态：到i时的最大子序列的值max，而维护这个值 需要两个值 1. 以i结尾的最大子序列的值ending 2. 最大子序列的值。 这样 
```java
ending = max(ending + nums[i + 1], nums[i + 1])
max = max(ending, max);
```
* 

