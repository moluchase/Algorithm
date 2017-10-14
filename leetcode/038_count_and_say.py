class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        nstr="1"
        for i in range(n):
            if i==0:
                nstr="1"
            else:
                restr = ""
                #for j in range(len(nstr)):
                j=0
                while j<len(nstr):
                    prec = nstr[j]
                    num = 1
                    while j + 1 < len(nstr) and nstr[j + 1] == nstr[j]:
                        j += 1
                        num += 1
                    #print("i=",i,"restr=",restr,"j=",j)
                    restr = restr + str(num) + str(nstr[j])
                    #print("@","i=", i, "restr=", restr, "j=", j)
                    j+=1
                nstr = restr
                print(nstr)
        return nstr


s=Solution()
#s.countAndSay(9)


for i in range(9):
    i=i+2
    print(i)

