class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #nums=list(set(nums))
        i=0
        while i<len(nums):
            if nums[i]==i:
                i+=1
            elif nums[i]<len(nums):
                temp = nums[nums[i]]
                nums[nums[i]] = nums[i]
                nums[i] = temp
            else:i+=1
        for i in range(len(nums)):
            if i!=nums[i]:return i
        return i+1

s=Solution()
print(s.missingNumber([3,2,0]))