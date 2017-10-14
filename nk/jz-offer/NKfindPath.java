import java.util.ArrayList;

public class NKfindPath {
    /*
     这道题我理解错了：题目的要求是打印出二叉树中节点值的和位输入整数的所有路径
     路径的定义是：从树德根节点开始往下一直到叶节点所经过的节点形成一条路径
     但是我下面的做法是路径并不要求一定到叶节点,而且不一定从根节点开始
     */


    /*
    public ArrayList<ArrayList<Integer>> FindOnePath(TreeNode node,int target,ArrayList<Integer> preArr,int sum,ArrayList<ArrayList<Integer>> arrs){
        ArrayList<Integer> arr1,arr2;
        ArrayList<Integer> temp1,temp2,temp3;
        if(node==null){
            return arrs;
        }
        if(sum!=0){
            arr1=new ArrayList<>();
            arr1.add(node.val);
            arr2=new ArrayList<>();
            arr2.add(node.val);
            arrs=FindOnePath(node.right,target,arr1,node.val,arrs);
            arrs=FindOnePath(node.left,target,arr2,node.val,arrs);
        }

        if(sum+node.val<target){
            preArr.add(node.val);
            sum+=node.val;
            temp1=new ArrayList<>();
            temp2=new ArrayList<>();
            for(int i=0;i<preArr.size();i++){
                temp1.add(preArr.get(i));
                temp2.add(preArr.get(i));
            }
            arrs=FindOnePath(node.left,target,temp1,sum,arrs);
            arrs=FindOnePath(node.right,target,temp2,sum,arrs);
        }else if(sum+node.val==target){
            preArr.add(node.val);
            temp3=new ArrayList<>();
            for(int i=0;i<preArr.size();i++){
                temp3.add(preArr.get(i));
            }
            arrs.add(temp3);
            preArr=new ArrayList<>();
        }else {
            preArr=new ArrayList<>();
        }

        return arrs;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arrs=FindOnePath(root,target,arr,0,arrs);
        return arrs;
    }
    */

    private ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    private ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        if(root==null) return lists;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            lists.add(new ArrayList<>(list));
        }else if(target>0){
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        list.remove(list.size()-1);
        return lists;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(23);
        arrs.add(arr);
        arr.add(24);
        for(int i=0;i<arrs.size();i++){
            for(int j=0;j<arrs.get(i).size();j++){
                System.out.println(arrs.get(i).get(j));
            }
        }
    }
}
