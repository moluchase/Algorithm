package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 18/4/2 下午7:28
 */
public class Mr01 {
    static int maxValue=Integer.MIN_VALUE;
    public static void dfs(int[]values,Map<Integer,ArrayList<Integer>>map,int parent,int cur){
        ArrayList<Integer> child=map.get(parent);
        if(child.size()==0){
            if(maxValue<cur*values[parent-1])maxValue=cur*values[parent-1];
        }
        else if(child.size()==1)dfs(values,map,child.get(0),cur*values[parent-1]);
        else{
            dfs(values,map,child.get(0),cur*values[parent-1]);
            dfs(values,map,child.get(1),cur*values[parent-1]);
        }
    }

    public static int calculateMaxScore(int numNodes,int rootNode,int[]values,int[][]edgs){
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=1;i<=numNodes;i++)map.put(i,new ArrayList<>());
        for(int i=0;i<edgs.length;i++)map.get(edgs[i][0]).add(edgs[i][1]);
        dfs(values,map,rootNode,1);
        return maxValue;
    }

    public static void main(String[] args) {
        calculateMaxScore(4,1,new int[]{-1,2,3,2},new int[][]{{1,2},{1,3},{3,4}});
    }
}
