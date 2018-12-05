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
* 378 & 287: These tew problems are the examples of how to do binary search by range. Note that binary search has two implementations:
  * By index
  * By range
* 222: An idea of binary search implementation based on Tree. Define the mid as the node obtained by left -> right -> right -> last layer. And pay attention to the operand `>>` / `<<`. For example, `1 << 2` equals to `2^2`, but `1 << 2 - 1` equals to `2^(2 - 1)`.
* 209: The basic version is `O(n)`, which uses two pointers. For the follow up, `O(nlogn)`, use binary search on the cumulative array, which is because it must be a ascending array and `a[j] - a[i]` is the sum of the subarray from `i + 1` to `j`.
* 454: It is very easy, and just a trade off between speed and storage. But I don't know why it is in tha binary search tag.
* 108: very easy
* 695: Just use flood method in dfs / bfs
* 105: This is a problem to improve your understanding of preorder and inorder. Remember you can use the number of node in the left in inorder array to compute where is the seperation point in preorder.
  