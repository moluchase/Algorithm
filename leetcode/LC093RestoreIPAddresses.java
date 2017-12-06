import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/9 上午9:55
 */

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/*
参考：https://www.cnblogs.com/grandyang/p/4305572.html
一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归。
这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。
我们用k来表示当前还需要分的段数，如果k = 0，则表示三个点已经加入完成，四段已经形成，若这时字符串刚好为空，则将当前分好的结果保存。
若k != 0, 则对于每一段，我们分别用一位，两位，三位来尝试，分别判断其合不合法，如果合法，则调用递归继续分剩下的字符串，最终和求出所有合法组合
dfs

 */
public class LC093RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        helperDfs(res,0,"",s);
        return res;
    }

    private void helperDfs(List<String> res, int k, String cur,String s) {
        if(k==4){
            if(s.length()==0)res.add(cur);
        }else {
            for(int i=1;i<4;i++){
                if(s.length()<i)break;
                String temp=s.substring(0,i);
                if(temp.length()!=String.valueOf(Integer.parseInt(temp)).length()||Integer.parseInt(temp)>255)continue;
                helperDfs(res,k+1,cur.length()==0?temp:cur+"."+temp,s.substring(i));
            }
        }
    }
}
