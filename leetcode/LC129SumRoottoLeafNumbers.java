import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/29 上午11:31
 */
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 */

/*
很easy，就不说了
 */
public class LC129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        List<String> list= new ArrayList<>();
        treeDfs(list,root,String.valueOf(root.val));
        int sum=0;
        for(String s:list){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }

    private void treeDfs(List<String> list, TreeNode node,String s) {
        if(node.left==null&&node.right==null){
            list.add(s);
            return;
        }
        if(node.left!=null) treeDfs(list,node.left,s+String.valueOf(node.left.val));
        if(node.right!=null) treeDfs(list,node.right,s+String.valueOf(node.right.val));
    }
}
