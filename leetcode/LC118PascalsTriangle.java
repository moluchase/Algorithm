import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/22 上午8:52
 */

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
/*
没的说，dp
 */

public class LC118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>>lists=new ArrayList<>();
        for (int i=0;i<numRows;i++){
            ArrayList<Integer> list=new ArrayList<>();
            lists.add(list);
            for (int j=0;j<=i;j++){
                if(j==0||j==i)lists.get(i).add(1);
                else lists.get(i).add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
            }
        }
        return lists;
    }
}
