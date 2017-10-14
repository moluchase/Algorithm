import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NKprintFromTop {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> treeNodes=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        TreeNode temp;
        if(root!=null){
            treeNodes.offer(root);
            while (!treeNodes.isEmpty()){
                temp=treeNodes.poll();
                arr.add(temp.val);
                if(temp.left!=null){
                    treeNodes.offer(temp.left);
                }
                if(temp.right!=null){
                    treeNodes.offer(temp.right);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
    }

}
