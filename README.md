# Leetcode

This repository is for recording my solutions to leetcode problems. And my goal is to solve at least 400 problems with at least 3 problems per day.

## Remarks

* For the graph problem solved by flood method, we can use bfs with queue non-recursivly or dfs recursivly. eg: 286, 130, 200, 364.
* For the 290: notice that the condition of `Integer == Integer`:
  ```Java
  Integer a = 128;
  Integer b = 128;
  a == b;

  // result is false, instead use Objects.equals(a,b)
  ```

  * 49: It is a problem about desgin a hashcode form some extend.
  * 29 Divde without multiplication: This problem using the thinking of binary search. And convert the int to long to avoid the overflow. And most important, if the long type result is larger than the `Integer.MAX_VALUE` or less than the `Integer.MIN_VALUE` you have to process your answer.
  * 141 & 142 & 287: These two problem is ```cycle detction problem```. Just use the Floyd cycle detection algorithm to determine whether the linklist contain a cycle, what is the length of the cycle, and what is the start point of the cycle. The 287, you should think the array as a linkedlist, where the `nums[i]` is the next node of `i`, i.e. ```nums[i].next = nums[nums[i]]```.
  * 69: Sqrt(x): be careful to handle the int type. When you compute the `i * i`, it is safer to convert `i` to `long type`.
  * 240 & 74 Matrix i & ii: i is not very difficult, just binary search. But for ii,  this problem is not a typical binary search, but the idea of the solution is also to diminish the possible range of target's location. Remember from the right top.
  * 951 Flip Equivalent Binary Trees: Use recurrsion.
  