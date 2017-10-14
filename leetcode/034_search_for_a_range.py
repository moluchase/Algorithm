class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        begin,end=0,len(nums)-1
        tb,te=0,0
        while begin<=end:
            mid=begin+int((end-begin)/2)
            if target>nums[mid]:
                begin=mid+1
            elif target<nums[mid]:
                end=mid-1
            else:
                i=mid
                while nums[i]==nums[mid] and i>=0:i-=1
                tb=i+1
                i=mid
                while nums[i]==nums[mid] and i<len(nums):i+=1
                te=i-1
                return [tb,te]
        return [-1,-1]

