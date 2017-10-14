class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        length=len(nums)
        if length>1:
            i = length - 1
            nex = nums[i]
            index2=i
            i = i - 1
            flag = 0
            while i >= 0:
                if nums[i] < nex:
                    flag = 1
                    index=i
                    break
                nex=nums[i]
                i = i - 1
            if flag == 0:
                for i in range(int(len(nums) / 2)):
                    temp = nums[i]
                    nums[i] = nums[length - i - 1]
                    nums[length - i - 1] = temp
            else:
                print(nums)
                print("index=%s,index2=%s"%(index,index2))
                if length-1==index+1:
                    temp=nums[length-1]
                    nums[length-1]=nums[index]
                    nums[index]=temp
                else:
                    flag=0
                    for i in range(len(nums[index + 1:])):
                        if nums[index + 1 + i] <= nums[index]:
                            temp = nums[index]
                            nums[index] = nums[index + i]
                            nums[index + i] = temp
                            flag=1
                            break
                    if flag==0:
                        temp=nums[index]
                        nums[index]=nums[length-1]
                        nums[length-1]=temp
                    print(int((index2 - index) / 2))
                    print(nums)

                    for i in range(int((index2 - index) / 2)):
                        temp = nums[index + 1 + i]
                        nums[index + 1 + i] = nums[index2 - i]
                        nums[index2 - i] = temp


s=Solution()
s.nextPermutation([1,2,4,3])



