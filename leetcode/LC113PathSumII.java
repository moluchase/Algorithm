import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/17 上午8:54
 */

/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 */
/*
这道题是上一题的延伸，不过考察点没有变，同110
 */
public class LC113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>lists= new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if(root==null)return lists;
        temp.add(root.val);
        pathSum(lists,temp,root,sum,root.val);
        return lists;
    }

    private void pathSum(List<List<Integer>> lists, List<Integer> temp, TreeNode node, int sum, int cur) {
        if(node.left==null&&node.right==null&&cur==sum){
            lists.add(new ArrayList<>(temp));
        }
        if(node.left!=null){
            temp.add(node.left.val);
            cur+=node.left.val;
            pathSum(lists,temp,node.left,sum,cur);
            temp.remove(temp.size()-1);
            cur-=node.left.val;
        }
        if(node.right!=null){
            temp.add(node.right.val);
            cur+=node.right.val;
            pathSum(lists,temp,node.right,sum,cur);
            temp.remove(temp.size()-1);
            cur-=node.right.val;
        }

    }
}
