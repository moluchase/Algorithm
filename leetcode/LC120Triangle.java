import java.util.Collections;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/22 上午9:16
 */

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
/*
dp可解
 */
public class LC120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0)return -1;
        if(triangle.size()==1){
            Collections.sort(triangle.get(0));
            return triangle.get(0).get(0);
        }
        int num=triangle.size();
        int []dp1=new int[num];
        int []dp2=new int[num];
        int k=0;
        for(int i=0;i<num;i++)dp2[i]=triangle.get(num-1).get(i);
        for(int i=num-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(k%2==0)dp1[j]=triangle.get(i).get(j)+Math.min(dp2[j],dp2[j+1]);
                else dp2[j]=triangle.get(i).get(j)+Math.min(dp1[j],dp1[j+1]);
            }
            k++;
        }
        if(k%2==0)return dp2[0];
        else return dp1[0];
    }
}
