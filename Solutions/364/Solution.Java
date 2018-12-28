/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList.size() < 1 || nestedList == null) {
            return 0;
        }
        
        int height = getHeight(nestedList);
        int result = getSum(nestedList, height - 1);
        return result;
    }
    
    private int getSum(List<NestedInteger> nestedList, int height) {
        int result = 0;
        for(NestedInteger nest : nestedList) {
            if(nest.isInteger()) {
                result += height * nest.getInteger();
            } else {
                result += getSum(nest.getList(), height - 1);
            }
        }
        return result;
    }
    
    private int getHeight(List<NestedInteger> nestedList) {
        if(nestedList.size() == 0) {
            return 1;
        }
        int height = 0;
        for(NestedInteger nest : nestedList) {
            int h = getHeight(nest.getList());
            if(h > height) height = h;
        } 
        
        return height + 1;
    }
}




