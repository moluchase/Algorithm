import java.util.LinkedList;
import java.util.Queue;

public class NKSerialTree {
    public static String Serialize(TreeNode root) {
        String s="";
        if(root==null)return s;
        int height=getHeight(root);
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        TreeNode temp;
        int h=0;
        queue1.offer(root);
        while (h<height){
            h++;
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    temp=queue1.poll();
                    if(temp==null){
                        s+="*#";
                        queue2.offer(null);
                        queue2.offer(null);
                    }else {
                        s+=temp.val+"#";
                        queue2.offer(temp.left);
                        queue2.offer(temp.right);
                    }
                }
            }else {
                while (!queue2.isEmpty()){
                    temp=queue2.poll();
                    if(temp==null){
                        s+="*#";
                        queue1.offer(null);
                        queue1.offer(null);
                    }else {
                        s+=temp.val+"#";
                        queue1.offer(temp.left);
                        queue1.offer(temp.right);
                    }
                }

            }
        }
        return s;
    }
    public static TreeNode Deserialize(String str) {
        if(str==null||str=="")return null;
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode temp;
        String[]strs=str.split("#");
        TreeNode head=new TreeNode(Integer.parseInt(strs[0]));
        int index=1;
        queue.offer(head);
        while (index<strs.length-1){
            temp=queue.poll();
            if(temp!=null){
                if(strs[index].equals("*")){
                    temp.left=null;
                    queue.offer(null);
                } else{
                    TreeNode treeNode=new TreeNode(Integer.parseInt(strs[index]));
                    temp.left=treeNode;
                    queue.offer(treeNode);
                }
                index++;
                if(strs[index].equals("*")){
                    temp.right=null;
                    queue.offer(null);
                } else {
                    TreeNode treeNode=new TreeNode(Integer.parseInt(strs[index]));
                    temp.right=treeNode;
                    queue.offer(treeNode);
                }
                index++;
            }else {
                queue.offer(null);
                index++;
                queue.offer(null);
                index++;
            }
        }
        return head;
    }

    private static int getHeight(TreeNode root) {
        if(root==null)return 0;
        int len1=getHeight(root.left)+1;
        int len2=getHeight(root.right)+1;
        return len1>len2?len1:len2;
    }
    public static void main(String[] args) {
        TreeNode treeNode=createTree(new int[]{1,2,3});
        String str=Serialize(treeNode);
        System.out.println(str);
        TreeNode head=Deserialize(str);
        printTree(treeNode);
        System.out.println();
        printTree(head);
    }

    private static TreeNode createTree(int[] ints) {
        TreeNode treeNode=new TreeNode(ints[0]);
        TreeNode p=treeNode;
        for (int i=1;i<ints.length;i+=2){
            TreeNode treeNode1=new TreeNode(ints[i]);
            TreeNode treeNode2=new TreeNode(ints[i+1]);
            p.left=treeNode1;
            p.right=treeNode2;
            p=p.left;
        }
        return treeNode;
    }

    private static void printTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
