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
