class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        flag = 0
        if divisor == 0: return -1
        num = 0
        if (divisor > 0 and dividend > 0) or (divisor<0 and dividend<0): flag = 0
        else:flag=1
        dividend=abs(dividend)
        divisor=abs(divisor)
        while dividend >= divisor:
            ni=1
            temp=divisor
            while temp<=dividend:
                temp=temp<<1
                if temp<=dividend:ni=ni<<1
            dividend=dividend-(temp>>1)
            num += ni
        if flag == 1: return -num
        return num

s=Solution()
print(s.divide(12,-4))
