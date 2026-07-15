class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for (int battery : batteryPercentages) {
            if (battery - count > 0) {
                count++;
            }
        }

        return count;
    }
}