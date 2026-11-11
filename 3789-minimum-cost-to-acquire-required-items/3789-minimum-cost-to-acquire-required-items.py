
class Solution(object):
    def minimumCost(self, cost1, cost2, costBoth, need1, need2):
        both = min(need1, need2) * costBoth

        remaining1 = max(0, need1 - need2)
        remaining2 = max(0, need2 - need1)

        separate = remaining1 * cost1 + remaining2 * cost2

        option1 = both + separate

        option2 = max(need1, need2) * costBoth

        option3 = need1 * cost1 + need2 * cost2

        return min(option1, option2, option3)
        