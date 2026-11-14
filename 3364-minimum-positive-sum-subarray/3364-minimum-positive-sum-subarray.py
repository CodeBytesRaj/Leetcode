
from sortedcontainers import SortedList

class Solution(object):
    def minimumSumSubarray(self, nums, l, r):
        n = len(nums)

        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        window = SortedList()
        ans = float('inf')

        for i in range(l, n + 1):
            window.add(prefix[i - l])

            if i - r - 1 >= 0:
                window.remove(prefix[i - r - 1])

            idx = window.bisect_left(prefix[i]) - 1

            if idx >= 0:
                curr = prefix[i] - window[idx]
                ans = min(ans, curr)

        return ans if ans != float('inf') else -1
