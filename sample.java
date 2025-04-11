class Solution {
    public int brokenCalc(int startValue, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startValue);
        int lvl=0;
        int curr = target;
        while(curr > startValue) {
            if (curr%2 == 0) {
                curr = curr/2;
            } else {
                curr = curr +1;
            }
            lvl++;
        }
        return lvl + (startValue-curr);
    }
}
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
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int total =0;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) {
            return 0;
        }
        int lvl=1;
        for (NestedInteger nestel: nestedList) {
            dfs(nestel, lvl);
        }
        return total;
    }
    private void dfs(NestedInteger nestel, int depth) {
        if(nestel.isInteger()) {
            total = total + depth*nestel.getInteger();
        } else {
            for (NestedInteger el: nestel.getList()) {
                dfs(el, depth+1);
            }
        }
    }
}
