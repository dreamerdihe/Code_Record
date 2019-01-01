# Leetcode

This repository is for recording my solutions to leetcode problems. And my goal is to solve at least 400 problems with at least 3 problems per day.

## Remarks for Java

### List and Array
* There is no shortcut for converting from int[] to List<Integer> as Arrays.asList does not deal with boxing and will just create a List<int[]> which is not what you want. You have to make a utility method.

### Map to String
`Arrays.toString(map.entrySet().toArray())`

### Array to String
* 1d array: `System.out.println(Arrays.toString(array))`
* 2d array: `System.out.println(Arrays.deepToString(array))`

### int to char
```java
int a = 10;
char aChar = (char)('0' + a);
// return '10'
```

### String骚操作：
 s.startsWith(word)
 ```java
 String s = "111";
 Integer.parseInt(s);
 Integer.parseInt(s, 2);
 // 111
 // 7
 ```

## Remarks

* **For the graph problem solved by flood method**, we can use bfs with queue non-recursivly or dfs recursivly. eg: 286, 130, 200, 364.
* **For the 290**: notice that the condition of `Integer == Integer`:
  ```Java
  Integer a = 128;
  Integer b = 128;
  a == b;

  // result is false, instead use Objects.equals(a,b)
  ```

* **49 Group Anagrams**: It is a problem about desgin a hashcode form some extend.
* **29 Divde without multiplication**: This problem using the thinking of binary search. And convert the int to long to avoid the overflow. And most important, if the long type result is larger than the `Integer.MAX_VALUE` or less than the `Integer.MIN_VALUE` you have to process your answer.
* **141 & 142 & 287**: These two problem is ```cycle detction problem```. Just use the Floyd cycle detection algorithm to determine whether the linklist contain a cycle, what is the length of the cycle, and what is the start point of the cycle. The 287, you should think the array as a linkedlist, where the `nums[i]` is the next node of `i`, i.e. ```nums[i].next = nums[nums[i]]```.
* **69 Sqrt(x)**: be careful to handle the int type. When you compute the `i * i`, it is safer to convert `i` to `long type`.
* **240 & 74 Matrix i & ii**: i is not very difficult, just binary search. But for ii,  this problem is not a typical binary search, but the idea of the solution is also to diminish the possible range of target's location. Remember from the right top.
* **951 Flip Equivalent Binary Trees**: Use recurrsion.
* **378 & 287 Kth Smallest Element in a Sorted Matrix & Find the Duplicate Number**: These tew problems are the examples of how to do binary search by range. Note that binary search has two implementations:
  * By index
  * By range
* **222 Count Complete Tree Nodes**: An idea of binary search implementation based on Tree. Define the mid as the node obtained by left -> right -> right -> last layer. And pay attention to the operand `>>` / `<<`. For example, `1 << 2` equals to `2^2`, but `1 << 2 - 1` equals to `2^(2 - 1)`.
* **209 Minimum Size Subarray Sum**: The basic version is `O(n)`, which uses two pointers. For the follow up, `O(nlogn)`, use binary search on the cumulative array, which is because it must be a ascending array and `a[j] - a[i]` is the sum of the subarray from `i + 1` to `j`.
* **454 4Sum II**: It is very easy, and just a trade off between speed and storage. But I don't know why it is in tha binary search tag.
* **108 Convert Sorted Array to Binary Search Tree**: very easy
* **695 Max Area of Island**: Just use flood method in dfs / bfs
* **105 & 106 Construct Binary Tree from Preorder/Postorder and Inorder Traversal**: This is a problem to improve your understanding of preorder/postorder and inorder. Remember you can use the number of node in the left in inorder array to compute where is the seperation point in preorder.
* **394 Decode String**: Two solutions: recursion and stack. I only write a recursion verion. Pay attention to detecting the right place of the left and right brackets. Also, pay attention to that the repeat number is not a digit, it may be `100`. 
* **109 Convert Sorted List to Binary Search Tree**: it is very similiar with 108. Remember you have to consider when the mid point is the head of the linklist. Also don't forget to set the mid point's next to null.
* **690 Employee Importance**: Just dfs
* **743 Network Delay Time**: use Dijkstra algorithm. Use a graph to represent the graph is lower than use matrix. `reminder for the matrix representation`
* **542 01 Matrix**: use bfs. `reminder for the dp solution`
* **332 Reconstruct Itinerary**: DFS, 1. the exit consition 2. bottom to top // top to bottom
* **417 Pacific Atlantic Water Flow**: The excellent practice for flood method. Flood the Pacific and Atlantic boolean array from the four edge seperatly. Note, do not check every entry of the matrix whether it is a desired entry.
* **733 Flood Fill**: very easy, just use flood method
* **513 Find Bottom Left Tree Value**: easy BFS/DFS. But seems dfs is faster than bfs
* **529 Minesweeper**: Note write a function to check the number of the mines in position's 8 neighbor. If the neighbors contain mines, return.
* **957 Prison Cells After N Days**: Time Machine problem. Since there are only `2 ^ 6`  possible conditions, so if `N > 2 ^ 6 = 64` there must exist a loop.
* **958 Check Completeness of a Binary Tree**: First get the height of the tree. Seconde use bfs and at the last layer, you have to consider the situation that when root.left is null, there still some node after it. Look the code.
* **698 Partition to K Equal Sum Subsets**: backtracking. Use a visited array when you want to avoid the element access time in array without using set. And use a index start to backtracking
* **173 Binary Search Tree Iterator**: use stack
* **669 Trim a Binary Search Tree**: Recursion. consider 3 cases: 
```
            root.val < L
            root.val > R 
            L <= root.val <= R
```
* **654 Maximum Binary Tree**: Recursion. Easy
* **99 Recover Binary Search Tree**: Use dfs to compare the prev node with the current node during inorder traverse. If prev > current, then recorde prev and current. Fianlly, the two mistaked nodes are the first and the last recored nodes.
* **543 Diameter of Binary Tree**: Calculate the max diameter with calculate the height, since the diameter the is the maximal left height + right height.
* **437 Path Sum III**: This problem is very good!! 
    * simply recursion: 
    ```
    pathSum(root, sum) = pathFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
    pathFrom(root, sum) = whether there exists a path from root satisfing the sum condition.
    ```
    
    * [memorization(very tricky)](https://leetcode.com/problems/path-sum-iii/discuss/141424/Python-step-by-step-walk-through.-Easy-to-understand.-Two-solutions-comparison.-%3A-)
* **538 Convert BST to Greater Tree**: maintain the sum during the dfs with the right-root-left order.
* **687 [Longest Univalue Path](https://leetcode.com/articles/longest-univalue-path/)**: This is a very good problem. You have to deal with the problem during the dfs.
* **637 Average of Levels in Binary Tree**: This problem could be solved by bfs and dfs. bfs is travial. For dfs, you have to record the height, and maintain a result array to record the sum of the nodes' value in each heigth.
* **606 Construct String from Binary Tree**: Easy. Just a preorder traverse with some operation.
* **652 Find Duplicate Subtrees**: This problem  also depends on dfs. we record the serialization of the subtree in a HashMap and its count. So, whenever the count equals to 2, we put it into the result. And this process is bottom-up. 
* **449 Serialize and Deserialize BST**: just recursion
* **156 Binary Tree Upside Down**: Use DFS recursion, everytime record previous node, let `node.left = prev; node.right = prev.right`. But remember! After assigning node, assign null to the `prev.left`and `prev.right`
* **285 Inorder Successor in BST**: Use recursion and the property of BST. we record the minimal node which is larger than target. So, if `node.val < targe.val`, the successor must exsits in `node.right`. If `node.val >= targe.val`, the successor could be the `node` or exists in `node.left`. If result doesn't exists in `node.left`, it must be the `node`.
* **872 Leaf-Similar Trees**: Find the leaves by DFS, and compare them
* **501 Find Mode in Binary Search Tree**: Use inorder traverse, so if there exists duplicate elements, they must be together. So we record the previous TreeNode, the max count, and the count of current node during dfs. If the current node has the same value as the previous node, we plus the count with 1, otherwise set count to 1. And if count == max count, we put the current node to the result. If count > max count, we clear our result and put the current node to it.
* **450 Delete Node in a BST**: Implementation of the node deletion in BST. Using recursion, when root.val < key, delete root.right, if root.val > key, delete root.left. `The most important part is when root.val == key, we have to find the min element in root.right, and delete that min element with replace root with it. `
* **814 Binary Tree Pruning**: Just recursion
* **947 Most Stones Removed with Same Row or Column**: **Remember to use Union Find solve this problem**
* **475 Heaters**:
    * Use binary search O(n * logm) where n is the number of houses, m is the number of heaters. Get the houses's insert position in heaters array, the result is the largest distanc eamong all the min distance between the left heater and right heater.
    * Use two pointer O(max(nlogn, mlogm)). You have to sort the two array. [Refer to this solution](https://leetcode.com/problems/heaters/discuss/95881/Simple-Java-Solution-with-2-Pointers)













    








