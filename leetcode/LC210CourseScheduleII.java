import java.util.*;

/**
 * @author pengsong
 * @date 17/12/23 上午10:49
 */
/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class LC210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] number=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        int[] res=new int[numCourses];
        int k=0;
        for(int i=0;i<prerequisites.length;i++){
            if(!map.containsKey(prerequisites[i][0]))map.put(prerequisites[i][0],new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            number[prerequisites[i][0]]++;
        }
        for(int i=0;i<numCourses;i++)if(number[i]==0)queue.add(i);
        while (!queue.isEmpty()){
            int temp=queue.poll();
            res[k++]=temp;
            for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
                if(entry.getValue().contains(temp)){
                    entry.getValue().remove(new Integer(temp));
                    number[entry.getKey()]--;
                    if(number[entry.getKey()]==0)queue.add(entry.getKey());
                }
            }
        }
        if(k==numCourses)return res;
        //for(int i=0;i<k;i++)res[i]=0;
        return new int[0];
    }
}
