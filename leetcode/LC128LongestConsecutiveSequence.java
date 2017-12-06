import java.util.HashMap;

/**
 * @author pengsong
 * @date 17/11/29 上午9:25
 */

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */

/*
像这样的题，要求时间复杂度为O(n)，那么就一定是要牺牲空间复杂度
参考：https://discuss.leetcode.com/topic/6148/my-really-simple-java-o-n-solution-accepted
讲解一下这个代码：需要put三个值，一个连续序列的边界值（两个），当前值（这个主要是避免后续还有相同的值）
还有一种比较好理解的解答，当然我不觉得这个时间复杂度是O(n)
https://www.cnblogs.com/grandyang/p/4276225.html中的第一个解法
 */
public class LC128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int res=0;
        for(int i:nums){
            if(!hashMap.containsKey(i)){
                int left=hashMap.containsKey(i-1)?hashMap.get(i-1):0;
                int right=hashMap.containsKey(i+1)?hashMap.get(i+1):0;
                int sum=left+right+1;
                hashMap.put(i,sum);
                res=Math.max(res,sum);
                hashMap.put(i-left,sum);
                hashMap.put(i+right,sum);
            }
        }
        return res;
    }
}
