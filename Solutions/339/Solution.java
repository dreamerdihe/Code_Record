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
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) {
            return 0;
        }
        int result = 0;
        for(NestedInteger nest : nestedList) {
            result += levelSum(nest, 1);
        }
        
        return result;
        
    }
    
    private int levelSum(NestedInteger nests, int level) {
        if(nests.isInteger()) {
            return nests.getInteger() * level;
        }
        
        int result = 0;
        
        List<NestedInteger> list = nests.getList();
        for(NestedInteger nest : list) {
            result += levelSum(nest, level + 1);
        }
        
        return result;
    }
}