class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        all_list=self.full_arrangement([],[],nums)
        return all_list

    def full_arrangement(self,all_list,res_list,nums):
        if len(nums)==0:
            temp=[i for i in res_list]
            all_list.append(temp)
            return all_list
        i=0
        while i<len(nums):
            res_list.append(nums[i])
            temp=[num for num in nums]
            temp.pop(i)
            all_list=self.full_arrangement(all_list,res_list,temp)
            res_list.pop(-1)
            i+=1
        return all_list

s=Solution()
print(s.permute([1,2,3,4]))