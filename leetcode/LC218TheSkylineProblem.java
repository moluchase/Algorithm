import java.util.*;

/**
 * @author pengsong
 * @date 17/12/29 上午8:47
 */
/*
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height.
 Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 */
/*
懒得看了，头疼，没睡好
171230 再看此题
Runtime Error:[[0,2147483647,2147483647]]
leetcode总是搞些边界的test，真烦，还不让用数组了，又得改。。。

Memory Limit Exceeded
我靠，简直了，重写。。。
改天在写吧，需要用三个指针，一个指向当前下标，一个指向前一个下标，一个指向后一个下标，判断满足条件的点【当前点只可能出现在边界点】
 */
public class LC218TheSkylineProblem {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list=new ArrayList<>();
        if(buildings.length==0)return list;
        int minNum,maxNum;
        minNum=Integer.MAX_VALUE;
        maxNum=Integer.MIN_VALUE;
        for(int i=0;i<buildings.length;i++){
            if(buildings[i][0]<minNum)minNum=buildings[i][0];
            if(buildings[i][1]>maxNum)maxNum=buildings[i][1];
        }
        int[] nums=new int[maxNum-minNum];
        for(int i=0;i<buildings.length;i++){
            for(int j=buildings[i][0];j<buildings[i][1];j++){
                if(nums[j-minNum]<buildings[i][2])nums[j-minNum]=buildings[i][2];
            }
        }
        /*
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }*/
        list.add(new int[]{minNum,nums[0]});
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]!=nums[i-1]&&nums[i]==nums[i+1])list.add(new int[]{minNum+i,nums[i]});
        }
        list.add(new int[]{minNum+nums.length,0});
        /*
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0]+","+list.get(i)[1]);
        }*/
        return list;
    }

    public static void main(String[] args) {
        getSkyline(new int[][]{{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}});
    }
}
