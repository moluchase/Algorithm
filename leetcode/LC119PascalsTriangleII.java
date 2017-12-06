import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/22 上午9:01
 */
/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

/*
很easy，有一点觉得不错，list的set函数用在此题非常好
 */
public class LC119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre=new ArrayList<>();
        List<Integer> cur=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            for(int j=0;j<=i;j++){
                if(i%2!=0){
                    if(j==0||j==i)cur.add(1);
                    else cur.set(j,pre.get(j-1)+pre.get(j));
                }else {
                    if(j==0||j==i)pre.add(1);
                    else pre.set(j,cur.get(j-1)+cur.get(j));
                }
            }
        }
        if(rowIndex%2==0)return pre;
        else return cur;
    }
}
