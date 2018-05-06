package interview;

import java.util.*;

/**
 * @author pengsong
 * @date 18/3/31 下午8:42
 */
/*
给你一个图，0节点连接着一个联通块a，1节点连接着一个联通块b，ab仅由01这条边相连
现在我们定义奇异路劲为恰好经过0-1这条边一次的路劲，其他边可以经过任意次，且路径不带方向，
1-2-3与3-2-1认为是两条路径，重边也算多条路径
在这个图中有无数奇异路径，问第k短的奇异路径长度是多少？
 */
public class QH36003 {
    /*
    这是用BFS做的
     */
    public static void getLengthBFS(Map<Integer,ArrayList<Integer>>map,int k){
        int step=0;
        int res=0;
        ArrayList<Integer> curNode=new ArrayList<>();
        ArrayList<Integer> preNode=new ArrayList<>();
        ArrayList<Boolean> flag=new ArrayList<>();
        for(int key:map.keySet()){
            curNode.add(key);
            preNode.add(-1);
            flag.add(false);
        }
        while (curNode.size()>0){
            int size=curNode.size();
            for (int i=0;i<size;i++){
                for(int val:map.get(curNode.get(i))){
                    if(val==preNode.get(i)){
//                        System.out.println("----"+preNode.get(i)+"----"+curNode.get(i));
                        if(flag.get(i)==true){
                            res++;
                            if(res==k){
                                System.out.println(step);
                                return;
                            }
                        }
                    }else {
                        boolean f=flag.get(i);
                        if((curNode.get(i)==0&&val==1)||(curNode.get(i)==1&&val==0))f=true;
                        curNode.add(val);
                        preNode.add(curNode.get(i));
                        flag.add(f);
                    }
                }
            }
            for(int i=0;i<size;i++){
//                System.out.println("----"+curNode.get(0)+"****"+preNode.get(0)+"****"+flag.get(0)+"----");
                curNode.remove(0);
                preNode.remove(0);
                flag.remove(0);
            }
//            System.out.println("res="+res);
//            System.out.println(curNode.size()+","+preNode.size()+","+flag.size());
            step++;
        }
    }
    /*
    这个算法写的有点问题，需要满足图中不能出现环，如果有环的话，就会不停的循环，走出不去
    按理说应该使用BFS做的，我却用DFS做了
     */
    public static void getLength(Map<Integer,ArrayList<Integer>>map,int key,int step,boolean flag,ArrayList<Integer>res,int preNode){
        for(int j=0;j<map.get(key).size();j++){
            int value=map.get(key).get(j);
            if(value==preNode){
                if(flag==true)res.add(step);
                continue;
            }
            if((key==0&&value==1)||(key==1&&value==0))flag=true;
            getLength(map,value,step+1,flag,res,key);
            if((key==0&&value==1)||(key==1&&value==0))flag=false;
        }
    }
    /*
    遍历map的key节点作为路劲的第一个节点
    使用res记录走到头的路径
     */
    public static void theKLength(Map<Integer,ArrayList<Integer>> map,int k){
        ArrayList<Integer> res=new ArrayList<>();
        for(int key:map.keySet()){
            getLength(map,key,0,false,res,-1);
        }
        Collections.sort(res);
//        for(int i=0;i<res.size();i++) System.out.println(res.get(i));
        System.out.println(res.get(k-1));
    }

    /*
    输入
    第一行三个整数n，m，k表示有n个节点，0~n-1，有m条边，问第k长？
    接下来有m行u，v表示边，保证0-1边只出现一次，保证ab联通块只通过0-1相连

    输出
    一行表示答案
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m,k;
        n=scanner.nextInt();
        m=scanner.nextInt();
        k=scanner.nextInt();
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();//使用map来存储每个节点所连接的其他节点
        for(int i=0;i<m;i++){
            int key=scanner.nextInt();
            int value=scanner.nextInt();
            if(map.containsKey(key))map.get(key).add(value);
            else {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(value);
                map.put(key,list);
            }
        }
        scanner.close();
        for(int i=0;i<n;i++){
            if(!map.containsKey(i)){
                map.put(i,new ArrayList<>());
            }
        }
        //完善map的对应关系
        for(int key:map.keySet()){
            for(int j=0;j<map.get(key).size();j++){
                int value=map.get(key).get(j);
                if(!map.get(value).contains(key))map.get(value).add(key);
            }
        }
//        for(int key:map.keySet()){
//            System.out.print(key+":");
//            for(int j=0;j<map.get(key).size();j++){
//                System.out.print(map.get(key).get(j)+",");
//            }
//            System.out.println();
//        }
        //theKLength(map,k);
        getLengthBFS(map,k);
    }
}
