class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        i=len(num2)-1
        sum=''
        zerostr=''
        while i>=0:
            temp=self.calcul_num1_multi_x(num1,num2[i])
            temp=temp+zerostr
            sum=self.calcul_sum_add_temp(sum,temp)
            zerostr+='0'
            i-=1
        return sum


    def calcul_num1_multi_x(self,num1,x):
        num1=list(num1)
        i=len(num1)-1
        pre=0
        while i>=0:
            temp=int(num1[i])*int(x)+pre
            num1[i]=str(temp%10)
            pre=int(temp/10)
            i-=1
        if pre!=0:
            num1="".join(num1)
            num1=str(pre)+num1
            num1=list(num1)
        num1="".join(num1)
        return num1

    def calcul_sum_add_temp(self,sum,numx):
        sum=list(sum)
        numx=list(numx)
        length1=len(sum)
        length2=len(numx)
        result1=numx
        result2=sum
        if length1>length2:
            result1=sum
            result2=numx
        i=0
        pre=0
        while i<len(result2):
            temp=int(result1[-i-1])+int(result2[-i-1])+pre
            result1[-i-1]=str(temp%10)
            pre=int(temp/10)
            i+=1
        i=len(result1)-len(result2)-1
        while pre!=0:
            if i>=0:
                temp=int(result1[i])+pre
                result1[i]=str(temp%10)
                pre=int(temp/10)
            else:
                result1="".join(result1)
                result1=str(pre)+result1
                result1=list(result1)
                pre=0
            i-=1
        result1="".join(result1)
        return result1

s=Solution()
print(s.multiply('100','100'))
#print(s.calcul_sum_add_temp('9234','3456'))