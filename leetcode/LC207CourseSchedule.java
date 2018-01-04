import java.util.*;

/**
 * @author pengsong
 * @date 17/12/22 上午9:17
 */
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
/*
原来是图啊，得好好总结一下，按照下面的
https://www.hrwhisper.me/leetcode-graph/
下面这个代码是我写的，主要是为了熟悉拓扑排序，不过其中使用栈不太好，应该使用队列
 */
public class LC207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] number=new int[numCourses];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][0]))map.put(prerequisites[i][0],new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            number[prerequisites[i][0]]++;
        }
        for(int i=0;i<numCourses;i++)if(number[i]==0)stack.push(i);
        while (!stack.isEmpty()){
            int temp=stack.pop();
            for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
                if(entry.getValue().contains(temp)){
                    entry.getValue().remove(new Integer(temp));
                    number[entry.getKey()]--;
                    if(number[entry.getKey()]==0)stack.push(entry.getKey());
                }
            }
        }
        for(int i=0;i<numCourses;i++)if(number[i]!=0)return false;
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(100);
        list.add(20);
        list.add(30);
        list.remove(new Integer(100));
    }
}
