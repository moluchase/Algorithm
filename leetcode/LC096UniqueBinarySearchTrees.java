/**
 * @author pengsong
 * @date 17/11/11 下午4:40
 */

/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

/*
这道题就是纯粹的考察卡塔兰数，见95题
 */

public class LC096UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int temp=0;
            for(int j=0;j<i;j++){
                temp+=dp[j]*dp[i-j-1];
            }
            dp[i]=temp;
        }
        return dp[n];
    }
}
