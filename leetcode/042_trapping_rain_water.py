class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height)<=2:return 0
        front_list=[]
        behind_list=[]
        maxheight=0
        front_list.append(maxheight)
        i=1
        while i<len(height):
            if height[i-1]>maxheight:
                maxheight=height[i-1]

            front_list.append(maxheight)
            i+=1
        maxheight=0
        behind_list.append(maxheight)
        i=len(height)-2
        while i>=0:
            if height[i+1]>maxheight:
                maxheight=height[i+1]
            behind_list.append(maxheight)
            i-=1
        sum=0
        for i in range(len(height)):
            if front_list[i]>behind_list[-i-1]:
                minheight=behind_list[-i-1]
            else:minheight=front_list[i]
            if minheight>height[i]:
                sum+=minheight-height[i]
        #print(sum)
        return sum

s=Solution()
s.trap([0,1,0,2,1,0,1,3,2,1,2,1])