class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #正负分开
        nums=list(set(nums))
        j=len(nums)-1
        i=0
        while i<=j:
            if nums[i]<=0:
                temp=nums[j]
                nums[j]=nums[i]
                nums[i]=temp
                j-=1
            else:i+=1
        print(i)
        print(nums)
        j=0
        while j<i:
            if nums[j]==j+1:
                j+=1
            elif 0<=nums[j]-1<len(nums):
                temp = nums[nums[j] - 1]
                nums[nums[j] - 1] = nums[j]
                nums[j] = temp
            else:j+=1
        print(nums)

        j=0
        while j<i:
            if nums[j]!=j+1:
                return j+1
                break
            j+=1
        return j+1
s=Solution()
s.firstMissingPositive([1,1])
