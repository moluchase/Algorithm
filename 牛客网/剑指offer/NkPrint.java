import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NkPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();
        TreeNode temp;
        if(pRoot==null)return arrs;
        queue1.offer(pRoot);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            ArrayList<Integer> arrayList=new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    temp=queue1.poll();
                    if(temp.left!=null)queue2.offer(temp.left);
                    if(temp.right!=null)queue2.offer(temp.right);
                    arrayList.add(temp.val);
                }
            }else {
                while (!queue2.isEmpty()){
                    temp=queue2.poll();
                    if(temp.left!=null)queue1.offer(temp.left);
                    if(temp.right!=null)queue1.offer(temp.right);
                    stack.push(temp.val);
                }
                while (!stack.isEmpty())arrayList.add(stack.pop());
            }
            arrs.add(arrayList);
        }
        return arrs;
    }

    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        if(pRoot==null)return arrs;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        TreeNode temp;
        stack1.push(pRoot);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            ArrayList<Integer>arrayList=new ArrayList<>();
            if(!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    temp=stack1.pop();
                    if(temp.left!=null)stack2.push(temp.left);
                    if(temp.right!=null)stack2.push(temp.right);
                    arrayList.add(temp.val);
                }
            }else {
                while (!stack2.isEmpty()){
                    temp=stack2.pop();
                    if(temp.right!=null)stack1.push(temp.right);
                    if(temp.left!=null)stack1.push(temp.left);
                    arrayList.add(temp.val);
                }
            }
            arrs.add(arrayList);
        }
        return arrs;
    }

    /*
    这是另外一道题，按层打印
     */
    public ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        TreeNode temp;
        if(pRoot==null)return arrs;
        queue1.offer(pRoot);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            ArrayList<Integer> arrayList=new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    temp=queue1.poll();
                    if(temp.left!=null)queue2.offer(temp.left);
                    if(temp.right!=null)queue2.offer(temp.right);
                    arrayList.add(temp.val);
                }
            }else {
                while (!queue2.isEmpty()){
                    temp=queue2.poll();
                    if(temp.left!=null)queue1.offer(temp.left);
                    if(temp.right!=null)queue1.offer(temp.right);
                    arrayList.add(temp.val);
                }
            }
            arrs.add(arrayList);
        }
        return arrs;
    }
}
