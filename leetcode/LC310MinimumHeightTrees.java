import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/12 上午9:16
 */

/*
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]
 */

/*
图的问题，参考https://leetcode.com/problems/minimum-height-trees/discuss/76055
基本思路就是，首先一棵树的最小高度节点最多只可能有两个
然后每一次循环就将当前的叶子节点去掉，最后当节点总是小于等于2的时候返回
 */
public class LC310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<HashSet<Integer>>list=new ArrayList<>();
        if(n==1){List<Integer>list1=new ArrayList<>();list1.add(0);return list1;}
        for(int i=0;i<n;i++)list.add(new HashSet<>());
        for(int[] edg:edges){list.get(edg[0]).add(edg[1]);list.get(edg[1]).add(edg[0]);}
        List<Integer> levels=new ArrayList<>();
        for(int i=0;i<n;i++)if(list.get(i).size()==1)levels.add(i);
        while (n>2){
            n-=levels.size();
            List<Integer> newLevels=new ArrayList<>();
            for(int i:levels){
                int temp=list.get(i).iterator().next();
                list.get(temp).remove(i);
                if(list.get(temp).size()==1)newLevels.add(temp);
            }
            levels=newLevels;
        }
        return levels;
    }
}
