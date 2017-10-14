class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2: return len(nums)
        k = 1
        pre = nums[0]
        for ni in nums[1:]:
            if ni != pre:
                nums[k] = ni
                k += 1
                pre = ni
        return k

