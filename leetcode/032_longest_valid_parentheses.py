class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack=[]
        length=0
        maxlength=0
        maxindex=0
        maxpre=0
        index_list=[]
        i=-1
        for j in range(len(s)):
            index_list.append(0)
            if s[j]=='(':
                i+=1
                stack.append(s[j])
                index_list[i]=j
            else:
                if i>=0 and stack[i]=='(':
                    length+=2
                    i-=1
                else:
                    stack=[]
                    i=-1
                    if length>maxlength:
                        maxlength=length
                        maxpre=maxlength
                        maxindex=j
                        print(j)
                    length=0
            j+=1
            print(length,j)
        print('index',maxindex)
        if maxlength<length:
            maxlength=length
            maxindex=len(s)
        print('maxlength',maxlength)
        print(index_list)
        print('i',i)
        if i>=0 and maxlength!=0 and index_list[i]<maxindex:
            index_list[i+1]=len(s)
            print(index_list)
            for j in range(i+1):
                length=index_list[j+1]-index_list[j]-1
                index_list[j]=length
            length=0
            sum=0
            print(index_list)

            for j in range(i+1):
                sum+=index_list[j]
                if index_list[j]>length:
                    length=index_list[j]
            print('sum', sum)
            print('length',length)

            maxlength=maxlength-sum if maxlength-sum>length else length
        return max(maxlength,maxpre)


#s=Solution()
#print(s.longestValidParentheses("))(()()))(((((()()())()())(((()))()(((()(())(((()()((()))))))))))())))()(((((()))(())))(((()))(()()()(()(((()))()))((()())(((())(((((()(()()(()())(())(((()()(()(())())(((()()))())()(()()())"))
st=[]
print(not st)