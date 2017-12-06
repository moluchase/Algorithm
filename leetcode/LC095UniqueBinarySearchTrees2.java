import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/10 上午9:45
 */

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

/*
这种题确实不会，还medium，确实有些知识需要弥补：卡塔兰数
DP解法
就跟斐波那契数列一样，我们把n = 0 时赋为1，
因为空树也算一种二叉搜索树，那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，
所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。n = 2的情况可由下面式子算出：

dp[2] =  dp[0] * dp[1]　　　(1为根的情况)

　　　　+ dp[1] * dp[0]　　  (2为根的情况)

同理可写出 n = 3 的计算方法：

dp[3] =  dp[0] * dp[2]　　　(1为根的情况)

　　　　+ dp[1] * dp[1]　　  (2为根的情况)

 　　　  + dp[2] * dp[0]　　  (3为根的情况)

由此可以得出卡塔兰数列的递推式
这里给出简单的dp程序，计算个数，而不是下面的返回结果

class Solution {
public:
    int numTrees(int n) {
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
};

参考：https://www.cnblogs.com/grandyang/p/4299608.html
http://blog.csdn.net/chilseasai/article/details/50083201
 */

public class LC095UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if(n<1)return new ArrayList<TreeNode>();
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res=new ArrayList<>();
        //start>end表示已经没有节点可以分了，直接返回空即可
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftNode=helper(start,i-1);
            List<TreeNode> rightNode=helper(i+1,end);
            for(TreeNode left:leftNode){
                for(TreeNode right:rightNode){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
