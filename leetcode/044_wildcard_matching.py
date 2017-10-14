class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        p_list=p.split('*')
        i=0
        j=0
        while i<len(s):
            if p_list[j]:
                i=self.find_with_match(s,p_list[j])
    def find_with_match(self,s,p_one):
        for i in range(len(s)):
            pass
s=Solution()
#s.isMatch('23232323','*34*34*434*')

