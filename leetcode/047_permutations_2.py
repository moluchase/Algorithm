class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums=sorted(nums)
        all_set=set()
        all_set=self.full_arrangement(all_set,[],nums)
        all_list=[]
        #print(all_list)
        for i in all_set:
            temp=i.split('#')
            temp=[int(j) for j in temp]
            all_list.append(temp)
        return all_list

    def full_arrangement(self,all_list,res_list,nums):
        if len(nums)==0:
            temp=[str(num) for num in res_list]
            temp="#".join(temp)
            all_list.add(temp)
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
print(s.permute([-1,2,-1,2,1,-1,2,1]))