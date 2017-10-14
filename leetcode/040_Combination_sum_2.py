class Solution(object):

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        res=[]
        out=0
        index=-1
        candidates=sorted(candidates)
        #print(candidates)
        result,res,out=self.digui(0,res,out,target,candidates,result)
        i=0
        while i<len(result):
            j=i+1;
            while j<len(result):
                if result[i]==result[j]:
                    result.pop(j)
                else:j+=1
            i+=1
        print(result)

    def digui(self,i,res,out,target,candidates,result):
        while i<len(candidates):
            if out+candidates[i]>=target:
                if out+candidates[i]==target:
                    temp = [k for k in res]
                    temp.append(candidates[i])
                    result.append(temp)
                if len(res)>0:
                    out -= res[-1]
                    res.pop(-1)
                return result,res,out
            else:
                out+=candidates[i]
                res.append(candidates[i])
                result,res,out=self.digui(i+1,res,out,target,candidates,result)
                i+=1
        if len(res)>0:
            out -= res[-1]
            res.pop(-1)
        return result,res,out
s=Solution()
s.combinationSum([3,1,3,5,1,1],8)
