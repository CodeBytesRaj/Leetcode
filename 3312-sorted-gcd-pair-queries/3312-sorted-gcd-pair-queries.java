class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each value
        long[] freq = new long[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // cnt[d] = number of elements divisible by d
        long[] cnt = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                cnt[d] += freq[multiple];
            }
        }

        // exact[d] = number of pairs whose gcd is exactly d
        long[] exact = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            long pairs = cnt[d] * (cnt[d] - 1) / 2;

            for (int multiple = d * 2; multiple <= max; multiple += d) {
                pairs -= exact[multiple];
            }

            exact[d] = pairs;
        }

        // Prefix sums of pair counts
        ArrayList<Long> prefix = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        long sum = 0;
        for (int d = 1; d <= max; d++) {
            if (exact[d] > 0) {
                sum += exact[d];
                prefix.add(sum);
                values.add(d);
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;
            int idx = lowerBound(prefix, target);
            ans[i] = values.get(idx);
        }

        return ans;
    }

    private int lowerBound(ArrayList<Long> arr, long target) {
        int left = 0, right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}