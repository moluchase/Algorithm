class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        len1 = len(haystack)
        len2 = len(needle)
        if len2 == 0: return 0
        if len1 == 0: return -1
        for i in range(len1):
            k = 0
            while k + i < len1 and k < len2 and haystack[k + i] == needle[k]: k += 1
            if k == len2: return i
            if k + i == len1: return -1
            i += 1
        return -1