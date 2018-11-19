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