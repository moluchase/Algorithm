[TOC]



# 算法刷题归类

## 1 题型

### 1.1 栈

#### 1.1.1 后缀表达式

##### [leetcode]150.Evaluate Reverse Polish Notation

题目：

```
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
```

思路：每次遇到符号，出栈两个元素进行运算，并将运算的结果进栈

```java
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();//栈，用来存储数字
        int a,b,temp;//中间变量，做计算用
        for(int i=0;i<tokens.length;i++){
            //int c=Integer.parseInt(tokens[i]);//获取字符串，转为字符
            // 如果c为数字，则进栈,否则出栈，并计算，再将结果进栈
            //-？表示匹配负号或者空
            if(tokens[i].matches("-?[0-9]+")){
                stack.push(Integer.parseInt(tokens[i]));
            } else{
                a=stack.pop();
                b=stack.pop();
                temp=0;
                switch (tokens[i].charAt(0)){
                    case '+': temp=b+a;break;
                    case '-': temp=b-a;break;
                    case '*': temp=b*a;break;
                    case '/': temp=b/a;break;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }
```

#### 1.1.2 基本计算器

##### [leetcode]224.Basic Calculator

题目：一个字符串中只包含（，），+，-,和数字，请求出该字符串表达式的结果

Some examples:

```
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
```

思路：因为只是加减法，因此只需要用栈来判断数字前面实际的符号，然后加减即可

代码：

```java
//判断两个字符叠加的结果
public static char calSymbol(char c1,char c2){
    if((c1=='+'&&c2=='+')||(c1=='-'&&c2=='-')){
        return '+';
    }else {
        return '-';
    }
}

public static int calculate(String s) {
    Stack<Character> stack=new Stack<>();
    String temp;//用来存储数字
    int sum=0;//求和
    char c1,c2;//c1为左括号前面符合的叠加结果，c2位要计算的数字前面的符号
    int i=0;
    c1='+';
    s=s.replace(" ","");//去除字符串中的空格
    //时间复杂度为O(n)
    while(i<s.length()){
        /**
         * 如果为'('此时需要将'('前面的符号入栈，并且计算c1，表明当前括号内的一级符号
         * 如果为')'，出栈，并与c1进行叠加
         * 如果为数字，判断数字前面的符号，赋值给c2；循环得到数字的值，最后由c1和c2判断该数字实际的符号，与sum运算
         */
        if(s.charAt(i)=='('){
            if(i==0){
                stack.push('+');
                c1='+';
            }else {
                stack.push(s.charAt(i-1));
                c1=calSymbol(c1,s.charAt(i-1));
            }
        }else if(s.charAt(i)==')'){
            c1=calSymbol(c1,stack.pop());
        }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
            //c2=s.charAt(i);
            if(i==0||(s.charAt(i-1)!='+'&&s.charAt(i-1)!='-')){
                c2=calSymbol(c1,'+');
            }else {
                c2=calSymbol(c1,s.charAt(i-1));
            }
            temp="";
            while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                temp+=s.charAt(i);
                i++;
            }
            i--;//为了配合后面的
            if(c2=='-'){
                sum-=Integer.parseInt(temp);
            }else {
                sum+=Integer.parseInt(temp);
            }
        }
        i++;
    }
    return sum;

}
```

##### [leetcode]227.Basic Calculator II

```
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
```

使用了两种方法：

calculate1用后缀表达式做的，比较经典，但是报超时
calculate2直接做的，将数字和字符分别入栈，然后对字符栈操作；ac过了



#### 1.1.3 弹出序列

##### [牛客网] 判断是否为栈的弹出序列

给出一个压栈序列，一个弹出序列，对于弹出序列中的某个元素，如果对应的压栈序列中对应的元素与之不相等，如果栈顶元素也不相等，则入栈；

#### 1.1.4 栈的基本性质

##### [牛客网] 动态获取栈中最小元素

用一个栈保存数据，一个栈保存依次入栈的最小元素（只会让不大于当前元素的元素入栈，也就是说是个非递增序列）

如： dataStack：5，4，3，8，10，11，12，1

则minStack：     5，4，3，1

```java
    Stack<Integer> dataStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    int temp;
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()||minStack.peek()>=node) minStack.push(node);
    }

    public void pop() {
        if(dataStack.peek()==minStack.peek())minStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
```

### 1.2 位运算

#### 1.2.1移位，与，或：>>，&，|

##### [牛客网]输出一个整数用二进制表示中1的个数

一般会想到的方法是移位>>2，这道题有一种巧妙的解法：一个数的二进制与这个数-1后的二进制作&运算，得到的结果会消去这个数的二进制中的一个1

```java
public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
```

##### [牛客网] 求两个数的和，不能使用+，-，*，/

两个二进制位与如果等于0，表示两个数每位没有公共位，直接异或的结果就是两个数的和；如果不等于0，同位为1结果为1，移位的结果正好将同1的结果相加，异或的结果是讲非同位的数相加，然后将这两个数再相加，直到为0

```java
    public static int Add(int num1,int num2) {
        return ((num1&num2)<<1)!=0?Add(num1^num2,(num1&num2)<<1):num1^num2;
    }
```

##### [牛客网]从扑克牌中抽取5张牌，判断是否为顺子

这道题实质上将大问题分解了，完整的问题应该是：在一副扑克牌中（大小王可变成任意牌，这里多了两张），任意抽取5张牌，且是顺子，这样的情况有多少种？

将这个问题分为两部分：一部分是全排列，一部分是判断是否是顺子

这里解决的时后面的问题，给定5张牌，判断这5张牌是否位顺子：

需要满足一下条件：

1. 没有重复的数字
2. 最大的数和最小的数之差小于5

为什么这道题放在这里，是因为在解决没有重复的数字时，使用与，或，移位等很巧妙：每个数字相当于1位，而在哪一位上是有数字的大小决定的，这位上有数则为1，没有数则为0【由于数字比较小的情况】,要判断这位上是否有数字，只需判断该位是否为1

```java
    /*
    最大的值和最小的值相差小于等于5
    没有重复元素
     */
    public boolean isContinuous(int [] numbers) {
        if(numbers.length!=5)return false;
        int minnum=14;
        int maxnum=-1;
        int flag=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<0||numbers[i]>13)return false;
            if(numbers[i]==0)continue;
            if(((flag>>numbers[i])&1)==1)return false;
            flag|=1<<numbers[i];
            if(minnum>numbers[i])minnum=numbers[i];
            if(maxnum<numbers[i])maxnum=numbers[i];
        }
        if(maxnum-minnum<5)return true;
        return false;
    }
```

#### 1.2.2 异或：^

##### [牛客网] 一个数组除了两个数字出现一次外，其它数字都出现了两次，找出这两个数字

以下两点是很明显的：

1. 一个数字异或本身等于0
2. 一个数组中除一个数字出现一次外，其它数字都出现了两次，那么将这些数字全部异或，得到的结果是出现一次的数字

那么问题的关键在于如何找到一个分割的方法，将题目中的数组分成两个数组，使得每个数组中出现一次的数字只有一个

如果将题目中的数字全部异或，得到的结果是出现一次的两个数字的异或结果，由于这两个数字不相等，那么异或的结果必然大于0，也就是说二进制表示一定存在1，获取从后向前遍历得到第一个1的位置（这个1必然由0和1异或得到，也就是说通过此位必然可以区分这两个数字），将全部的数字转为二进制，在此位为1的分为一组，为0的分为另外一组，这样就解决了上面的问题，那么也就得到了这两个数字

```java
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length<2)return;
        int temp=0,temp2=0;
        String stemp;
        int index;
        //全部异或
        for(int i=0;i<array.length;i++){
            temp^=array[i];
        }
        stemp=Integer.toBinaryString(temp);
        index=stemp.length();
        while (--index>=0){
            if(stemp.charAt(index)=='1') break;
        }
        temp=0;
        index=stemp.length()-index;//计算位置
        //分离数组
        for(int i=0;i<array.length;i++){
            stemp=Integer.toBinaryString(array[i]);
            if(index<=stemp.length()&&stemp.charAt(stemp.length()-index)=='1'){
                temp^=array[i];
            }else {
                temp2^=array[i];
            }
        }
        num1[0]=temp;//temp赋值给num1
        num2[0]=temp2;//temp2赋值给num2
    }
```

#### 1.2.3 且：&&

##### [牛客网]求和：1+2+3...+n，不能使用乘除，for，条件等

求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）

用递归无疑，但是递归是有出口的，如何判断出口，用到了&&的短路

```java
    public static int Sum_Solution(int n) {
        int res=0;
        boolean b=n>0&&(res=Sum_Solution(n-1)+n)>0;
        return res;
    }
```

#### 1.2.4 取余：%

##### [牛客网] n个人，从0开始循环报数，报m-1的人出列，求最后一个出列的人

做完后看了一下推荐的答案，能够想出用递归这么简洁也是厉害了

我首先想到的是ArrayList的remove方法，将指定的元素进行remove操作，直到ArrayList中只有一个元素时，跳出并返回

```java
    public static int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> arr=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++) arr.add(i);
        while (arr.size()>1){
            index=(arr.size()+(index+m)%arr.size()-1)%arr.size();
            arr.remove(index);
        }
        return arr.get(0);
    }
```

#### 1.2.5 二进制

##### [leetcode] 50.Pow(x,n)

将n转为二进制，然后从后向前遍历,注意负数的判断

```java
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            x=1.0/x;
            n=-n;
        }
        if(n==1) return x;
        String bits=Integer.toBinaryString(n);
        double sum=1;
        double temp=x;
        for(int i=bits.length()-1;i>=0;i--){
            if(i==bits.length()-1)temp=x;
            else temp=temp*temp;
            if(bits.charAt(i)=='0')continue;
            sum*=temp;
        }
        return sum;
    }
```



### 1.3 链表

##### [牛客网] 输出链表中倒数第k个节点

这里本来想用递归，但是这种有返回值的递归做不了；于是只能正序，先统计节点的个数count，然后从头遍历到第count-k个节点时，停止，返回【需要判断count与k的大小】

##### [牛客网] 删除有序链表中值重复的节点

 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

这道题开始想用三个指针解决，但是发现很麻烦，最后想到用递归的思想，即将问题缩小：

每次只找到第一个不用删除的节点返回即可，下一次从该节点的下一个节点找即可

```java
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null)return null;
        ListNode p= pHead;
        ListNode p1=null,p2,head=null;
        while (p!=null){
            if(p1==null){
                p1=getHead(p);
                head=p1;
                p=p1!=null?p1.next:null;
            }else {
                p2=getHead(p);
                p1.next=p2;
                p1=p2;
                p=p2!=null?p2.next:null;
            }
        }
        return head;
    }

    private static ListNode getHead(ListNode p) {
        if(p.next==null)return p;
        ListNode p2;
        p2=p;
        while (p.next!=null&&p.val==p.next.val)p=p.next;
        if(p==p2)return p2;
        else if(p.next==null) return null;
        return getHead(p.next);
    }
```

##### [牛客网] 复制复杂链表

**解法很经典**

复制的主要问题是random的处理，因为原链表的random是任意的，因此复制的链表需要将节点全部生成完之后，才能取赋random，而不能根据原节点的random来赋值，因为该random是指向原节点的

```java
1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
2、遍历链表，A1->random = A->random->next;
3、将链表拆分成原链表和复制后的链表
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class NKClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)return null;
        RandomListNode p,p2,head;
        p=pHead;
        while (p!=null){
            RandomListNode node=new RandomListNode(p.label);
            node.next=p.next;
            p.next=node;
            p=node.next;
        }
        p=pHead;
        while (p!=null){
            p2=p.next;
            if(p.random!=null){
                p2.random=p.random.next;
            }
            p=p2.next;
        }
        head=pHead.next;
        p=pHead;
        while (p.next!=null){
            p2=p.next;
            p.next=p2.next;
            p=p2;
        }
        return head;
    }
}
```



### 1.4 队列

##### [牛客网] 按层打印二叉树

先将二叉树的根节点入队，然后输出其值，如果它有左子树则将其入队，有右子树将其入队；当对为空时，表示遍历完

```java
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
```

##### [牛客网] 输出所有和为S的连续正数序列

1. 一种适合队列的方法如下： 

   用一个队列维持连续数列，时间复杂度为O(n) 

    用result记录队列的和， 当队列中的和大于sum时，从队列的头部删除元素 ， 当队列中的和小于sum时，从队列的尾部添加元素 ，  当队列中的和等于sum时，将队列添加到arraylist中 

2. 另外一种方法是，使用数列求和 

   (a1+an)/2*n=s，且n=an-a1+1,也就有（a1+an)(an-a1+1)=2s，已知s，枚举a1，求解an是否为小于s大于a1的整数即可 

下面给出第一种方法的代码

```java
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        Queue<Integer> list=new LinkedList<>();
        int result=0;
        int i=1;
        if(sum==0)return arrs;
        while (i<=(sum+1)/2){
            if(result<sum){
                list.add(i);
                result+=i;
                i++;
            }
            if(result>sum){
                result-=list.poll();
            }
            if(result==sum) {
                arrs.add(new ArrayList<>(list));
                result-=list.poll();
            }
        }
        return arrs;
    }
```



### 1.5 二叉树

##### [牛客网] 一个二叉树是否为另一个二叉树的子树

这道题使用大问题转小问题的思想，一般二叉树的递归（化简）分为三部分：该节点，该节点的左节点，该节点的右节点

```java
    public boolean IsSubtree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val==root2.val){
            return IsSubtree(root1.left,root2.left)&&IsSubtree(root1.right,root2.right);
        }else {
            return false;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)return false;
        return IsSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
```

##### [牛客网]二叉树的镜像

这道题看似复杂，其实同样是大问题转小问题，具体做法是对于每个节点，将其左节点与右节点交换即可

```java
    public void Mirror(TreeNode root) {
        if (root !=  null && (root.left != null || root.right != null)) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }
```

##### [牛客网]判断一个二叉树是否是对称的

如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的

同样使用递归解决：根节点的左子树和根节点的右子树，笔记左子树左节点和右子树的右节点&&左子树的右节点和右子树的左节点

```java
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isSy2(pRoot.left,pRoot.right);
    }

    private boolean isSy2(TreeNode left, TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;
        return isSy2(left.left,right.right)&&isSy2(left.right,right.left);
    }
```



##### [牛客网]判断一个序列是否为一个二叉搜索树的后序遍历

同样是大问题转小问题，递归的思想，后序遍历最后一个元素肯定位根节点，对于二叉搜索树，必定有左子树中的元素全部小于根节点的元素，右子树中的元素全部大于根节点的元素，不断递归即可

给出如下参考代码，比较经典

```c++
/*
BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
*/
class Solution {
    bool judge(vector<int>& a, int l, int r){
        if(l >= r) return true;
        int i = r;
        while(i > l && a[i - 1] > a[r]) --i;
        for(int j = i - 1; j >= l; --j) if(a[j] > a[r]) return false;
        return judge(a, l, i - 1) && (judge(a, i, r - 1));
    }
public:
    bool VerifySquenceOfBST(vector<int> a) {
        if(!a.size()) return false;
        return judge(a, 0, a.size() - 1);
    }
};
```

##### [牛客网]求二叉树的深度

求根节点的深度，等于求解该节点的子节点最大深度+1；这是一个分治问题

```java
    public int TreeDepth(TreeNode root) {
        return getTreeDepth(root);
    }
    private int getTreeDepth(TreeNode node){
        if(node==null)return 0;
        int len1=getTreeDepth(node.left)+1;
        int len2=getTreeDepth(node.right)+1;
        return len1>len2?len1:len2;
    }
```

##### [牛客网]判断一个二叉树是否为平衡二叉树

同样是分治算法，对于根节点，需要判断左节点为平衡二叉树，右节点为平衡二叉树，而且需要满足左节点的深度和右节点的深度之差小于等于1；这里定义一个外部变量判断是否为平衡树，在求深度的过程中判断平衡树条件即可省去反复求解深度和判断

说一点：平衡二叉树一定是二叉搜索树，因此是需要判断是否为二叉搜索树的，但是牛客网上编译器是不需要的

```java
    /*
    平衡二叉树满足一下性质：
    （一棵空树）或（它的左右两个子树高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树）
    平衡二叉树一定是二叉搜索数
     */
    //避免重复的方法是：在外面定义一个boolean类型，在求解高度中比较来判断boolean的值；或者是使用-1来判断是否是平衡树
    
    Boolean isBalan=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth(root);
        return isBalan;
    }

    private int TreeDepth(TreeNode node) {
        if(node==null) return 0;
        int len1=TreeDepth(node.right)+1;
        int len2=TreeDepth(node.left)+1;

        //判断是否满足左右子树深度差小于等于1
        if(Math.abs(len1-len2)>1)isBalan=false;
        
        /*
        //判断该节点为根节点下的树是否满足二叉搜索树
        if(node.left!=null&&node.right!=null){
            if(!(node.val>node.left.val)&&(node.val<node.right.val)) isBalan=false;
        }else if(node.left!=null){
            if(!(node.val>node.left.val)) isBalan=false;
        }else if(node.right!=null){
            if(!(node.right.val>node.val)) isBalan=false;
        }
        */

        return len1>len2?len1:len2;
    }
```

##### [牛客网]返回按中序遍历的下一个节点

只要考虑全部情况即可：

1. 如果该节点为空，返回空
2. 如果该节点的右节点不为空，则下一个节点一定是右节点或则是右节点的子节点（这里使用while循环，直到找到右节点的左节点为空为止）
3. 如果该节点的右节点为空，则下一个节点一定是它的父节点或者父节点的之上的节点：这里需要判断该节点是否为父节点的左节点，直到找到一个满足条件，返回父节点

```java
   public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode p;
        if(pNode==null)return null;
        if(pNode.right!=null){
            p=pNode.right;
            while (p.left!=null)p=p.left;
            return p;
        }
        p=pNode;
        while (p.next!=null){
            if(p==p.next.left)return p.next;
            p=p.next;
        }
        return null;
    }
```

##### [牛客网] 二叉树的序列化与反序列化

使用到的是层次遍历

序列化：先求树深度，然后使用两个队列来判断深度后跳出

反序列化：对于空节点，也需要将其入队，跳出条件是字符串数组的大小

代码略。。。

##### [牛客网] 返回二叉搜索树的第k大节点

原理是中序遍历，由于使用递归，返回值只能是一个，但是需要返回第k大的节点外，还需要判断该节点是不是第k大的，因此需要一个全局变量来记录

```java
    int index=0;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode node=null;
        if(pRoot!=null){
            node=KthNode(pRoot.left,k);
            if(node!=null)return node;
            index++;
            if(index==k)return pRoot;
            node=KthNode(pRoot.right,k);
            if(node!=null)return node;
        }
        return node;
    }
```

### 1.6 字符串

#### 1.6.1 全排列

##### [leetcode] 输出数组中所有可能的组合方式，数组元素没有重复

这个问题就比较简单，直接使用DFS就能解决，这里就不上代码了，参见下一题，简化之

##### [leetcode] 输出数组中所有可能的组合方式，数组元素有重复

这个题是上面一道题的衍生，开始我用python做的时候，是先按照没有重复元素的方法做，然后再去重；发现超时了，不过这个题目和上面的题目的区别在于：元素选取时，必须满足相同元素选取的顺序不能变（即相同元素的第一个元素必须在第二个元素的前面）

```java
//重复数的全排列重点在于相同的元素，组合后顺序不能乱，即第一个1必须在第二个1的前面，如果前面没有第一个1，后面的1不能添加
    public class LCpermutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> lists=new ArrayList<>();
        if(nums==null||nums.length==0) return lists;//如果为空，返回
        boolean []used=new boolean[nums.length];//用来判断元素是否已近使用
        List<Integer> arr=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,lists,arr,used);
        return lists;
    }

    private static void dfs(int[] nums, List<List<Integer>> lists, List<Integer> arr, boolean[] used) {
        if(nums.length==arr.size()){
            lists.add(new ArrayList<>(arr));//如果长度已近达到了，则将其添加
        }else {
            for(int i=0;i<nums.length;i++){
                if(used[i])continue;//表示已经选过了
                if(i>0&&nums[i-1]==nums[i]&&!used[i-1])continue;//如果该元素前面的元素与之相等，且前面的元素没有被选取，则不能选取该元素
                used[i]=true;
                arr.add(nums[i]);
                dfs(nums,lists,arr,used);//前两行和后两行对称，保证遍历时一样
                used[i]=false;
                arr.remove(arr.size()-1);
            }
        }
    }
```



##### [牛客网] 按字典序输出字符串中所有可能的排列

思路：首先可以确定第一个字符串是正序，最后一个字符串是逆序，那么我只用写一个函数，求当前字符串按字典序的下一个字符串即可，在while循环中判断当前字符串是否位逆序字符串，是则跳出

求解下一个字符串需要对当前字符串作两步工作：

1. 从后遍历字符串，找出大于该元素且下标在该元素后面的最小元素，与之交换
2. 对1中交换的元素后面的所有字符串排序（当然有更简单的方法）



```java
public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arr=new ArrayList<>();
        if(str.length()==0) return arr;
        if(str.length()==1){
            arr.add(str);
            return arr;
        }
        //排序
        char[]chars=str.toCharArray();
        Arrays.sort(chars);
        str=String.valueOf(chars);
        //反转字符串，作为边界条件
        StringBuffer stringBuffer=new StringBuffer(str);
        String str2=stringBuffer.reverse().toString();
        arr.add(str);//添加第一个字典序
        while (!(str.equals(str2))){
            str=NextDictOrder(str);
            arr.add(str);
        }

        return arr;
    }

    private static String NextDictOrder(String str) {
        int i=str.length()-2;
        int j;
        char minChar=' ';//不可能为空
        int index=0;
        char[] chars;
        while (i>=0){
            if(str.charAt(i)<str.charAt(i+1)){
                j=i+1;
                minChar=str.charAt(j);
                index=j;
                while(j<str.length()){
                    if(str.charAt(j)>str.charAt(i)&&str.charAt(j)<minChar){
                        index=j;
                        minChar=str.charAt(j);
                    }
                    j++;
                }
                break;
            }
            i--;
        }
        chars=(str.substring(i,index)+str.substring(index+1,str.length())).toCharArray();
        Arrays.sort(chars);
        str=str.substring(0,i)+minChar+String.valueOf(chars);
        return str;
    }
```



#### 1.6.2 正则

##### [牛客网] 实现匹配'.'，'*'的正则表达式

使用递归实现，思路如下：

入口函数：

如果字符串和模式串都为空，返回true

如果模式串为空，返回false

如果字符串为空：

- 如果模式串长度大于等于2且第2个字符为'*'，将字符串和模式串的第2个元素之后的元素从新比较（传入入口函数）；否则返回false

如果字符串不为空：

- 如果模式串小于等于1：当字符串第一个元素等于模式串第一个元素且字符串长度也等于1时，返回true，否则返回false
- 否则判断模式串的第二个元素：
  - 如果第二个元素不等于'*'：比较第一个元素是否相等，不相等返回false；相等则将它们后面的元素重新比较（传入入口函数）
  - 如果第二个元素等于'*'：如果第一个元素比较相等，字符串前进一步重新比较||如果第一个元素不相等，模式串前进两步重新比较

```java
    public static boolean match(char[] str, char[] pattern) {
        if(str.length==0&&pattern.length==0)return true;
        if(pattern.length==0)return false;
        if(str.length==0){
            if(pattern.length>=2&&pattern[1]=='*')return match(str,new String(pattern).substring(2).toCharArray());
            return false;
        }else {
            if(pattern.length==1){
                if(!(str[0]==pattern[0]||pattern[0]=='.')) return false;
                if(str.length==1)return true;
                return false;
            }else {
                if(pattern[1]!='*'){
                    if(!(str[0]==pattern[0]||pattern[0]=='.'))return false;
                    return match(new String(str).substring(1).toCharArray(),new String(pattern).substring(1).toCharArray());
                }else {
                    if(!(str[0]==pattern[0]||pattern[0]=='.'))return match(str,new String(pattern).substring(2).toCharArray());
                    return match(str,new String(pattern).substring(2).toCharArray())||
                            match(new String(str).substring(1).toCharArray(),pattern);
                }
            }
        }
    }
```



### 1.7 数学知识

#### 1.7.1 多个数的特征

##### [牛客网] 找出一个数组中出现超过一半的数字

超过一半的数，也就是说用这个数和其他数抵消，剩下的一定是这个数，那么任意的数抵消，剩下的也一定是这个数

于是如下做：取第一个数作为temp，令num=1，下一个数和该数比较，如果相等，则num++；如果不相等，num—；当num=0，将比较的数赋值给temp

```java
public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0) return 0;
        int num=1;
        int temp=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]!=temp){
                num--;
            }else{
                num++;
            }
            if(num==0){
                temp=array[i];
                num=1;
            }
        }
        num=0;
        for(int i=0;i<array.length;i++){
            if(temp==array[i]){
                num++;
            }
        }
        if(num>array.length/2)return temp;
        return 0;
    }
```

当然有比较常规的方法，就是先排序，找中间的数；或者是将每个数作为Map的key，出现次数作为value，判断value大于一半时，返回；

##### [牛客网] 1到n个数中含1的个数

https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6

给出一个比较精简的代码，除了定义变量和return语句，没有其它语句了；使用的是递归的方法；时间复杂度为O(log10n) 

思路：

1. 对于一个数n，先判断是否为个数，如果是且大于等于1，则返回1；如果是且等于0，则返回0；否则执行下一步


2. 取n中第一位为a，取n中后面其它位为b；（如n=123，则a=1，b=23）


3. 如果a大于1，表明数n的最高位经历了最高位为1的全部情况（比如n=223，a=2；n的最高位经历了100，101，102，103，...，199，200，201，...，223这么多数，这里我只计算这些数中最高位为1的个数，为100；类似的，对于n的位数为4时，是1000，为5时，是10000...）；如果等于1，表明数n的最高位经历了b+1次为1的情况（比如n=123，a=1；说明n经历了100，101，102，...，123这24次最高位为1的情况，即b+1）【此处只考虑最高位，其它位使用递归】；


4. 此时还需要算除b以外的其它位上经历1的个数，这里直接递归使用a*NumberOf1Between1AndN_Solution(times-1),其中times表示的是和n同位数的最小整数（这里解释一下：比如n=223,a=2,b=23；这里times=100，因为a=2，表明n经历了从1到times-1的全部数有a次，即1到99经历了2次，那么计算99中1的个数乘以2就是除b以外其它位上经历1的个数）

   5. 最后还需要算b中经历1的个数，直接调用原函数即可

```java
链接：https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
来源：牛客网

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<10)return n>=1?1:0;
        int times=(int)(Math.pow(10,String.valueOf(n).length()-1));
        int a=Integer.parseInt(String.valueOf(n).substring(0,1));
        int b=Integer.parseInt(String.valueOf(n).substring(1,String.valueOf(n).length()));
        return a>1?times+a*NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b):
                b+1+NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b);
    }
```

##### [牛客网]找出第N个丑数

1为第一个丑数，在其它大于1的数中，如果满足因子只包含2，3，5或者丑数，那么这个数就是丑数

等价的意思：一个数n如果可以由$n=2^x*3^y*5^z\,\,\,,\{x,y,z|x\ge0,y\ge0,z\ge0\}$ 表示，那么这个数就是丑数

这个问题变成我们需要将满足上式的数字排序，然后找到第N小的数；关键在于如何生成这些数，如果生成的数本身就是排好序的就是最好的结果，问题转化为如何生成有序的丑数：

1. 将1存入数组arr中，令t1=t2=t3=0

2. 比较`1*2,1*3,1*5`的结果，取最小的存入arr中，然后将对应的下标加1

   即比较`arr[t1]*2,arr[t2]*3,arr[t3]*5`的大小，将最小的存入arr中，然后将对应的下标加1，继续执行第2步，跳出条件是arr的大小等于N时

```java
    public static int GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        ArrayList<Integer> arr=new ArrayList<>();
        int t1,t2,t3;
        int temp;
        t1=t2=t3=0;
        arr.add(1);
        for(int i=1;i<index;i++){
            temp=Math.min(arr.get(t1)*2,Math.min(arr.get(t2)*3,arr.get(t3)*5));
            arr.add(temp);
            if(temp==arr.get(t1)*2)t1++;
            if(temp==arr.get(t2)*3)t2++;
            if(temp==arr.get(t3)*5)t3++;
        }
        return arr.get(index-1);
    }
```

#### 1.7.2 求和

##### [牛客网] 求解数组A中除去第i个元素的其它元素乘积

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法

这里直接上张图

![https://uploadfiles.nowcoder.com/images/20160829/841505_1472459965615_8640A8F86FB2AB3117629E2456D8C652](https://uploadfiles.nowcoder.com/images/20160829/841505_1472459965615_8640A8F86FB2AB3117629E2456D8C652)

```java
    public static int[] multiply(int[] A) {
        int num1=1,num2=1;
        int[]B=new int[A.length];
        int temp=1;
        for(int i=0;i<A.length;i++){
            B[i]=temp;
            temp*=A[i];
        }
        temp=1;
        for(int i=A.length-1;i>=0;i--){
            B[i]*=temp;
            temp*=A[i];
        }
        for(int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }
        return B;
    }
```

#### 1.7.3 巧解

##### [牛客网]在有环的链表中找到环的入口

...

```java
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1,p2;
        p1=pHead.next;
        p2=pHead.next.next;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
        }
        //if (p2==null||p2.next==null)return null;
        p2=pHead;
        while (p2!=p1){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
```

### 1.8 数组

#### 1.8.1 矩阵

##### [leetcode] 48. Rotate Image（矩阵变换，不开辟新数组） 

```
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

代码如下：

```java
    //先转置，然后反转
    public static void rotate(int[][] matrix) {
        int temp;
        //转置
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //反转
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-j-1];
                matrix[i][matrix[0].length-j-1]=temp;
            }
        }
    }
```




## 2  思想

### 2.1 分治

#### 2.1.1 二叉树B是否为二叉树A的子树

将A的每个节点与B比较，判断是否从A的该节点和B是子树

对于每个节点，有三种情况：该节点比较，该节点的左节点，该节点的右节点

下面是很经典的代码：

```java
    public boolean IsSubtree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val==root2.val){
            return IsSubtree(root1.left,root2.left)&&IsSubtree(root1.right,root2.right);
        }else {
            return false;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null)return false;
        return IsSubtree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
```

### 2.2 排序

#### 2.2.1 将数组中的元素拼接为最小的数字

如{3,32,321}，返回的时321323

这里使用到了Java中的集合排序，核心思想是对于数组中的两个元素作如下处理：

如3 和321比较，应该将321放到3的前面，但是对于3和5的比较，应该将3放在5的前面；很显然如果使用comparto是办不到的，将原问题转化位两个元素的问题，就是两个元素应该如何拼接使结果最小，那么就是比较3321和3213的大小问题，这样问题就解决了

```java
    public String PrintMinNumber(int [] numbers) {
        String result="";
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1);
                String s2=String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }
        });
        for (int i:list) {
            result+=i;
        }
        return result;
    }
```

### 2.2.2 归并排序

...

### 2.3 查找

##### [牛客网]二维数组的每行，每列都是有序的，如何查找指定元素是否在数组中

分块思想，如何将大的问题分解为小得问题，如果是对角线比较，就分为两块，比较复杂，如果是从左下角元素/右上角元素开始比较，则比较简单

##### [牛客网]查找字母串中第一个只出现一次的字符的下标

题目中说到字符全部由字母组成，这样便想到使用Map的思想，使用一个char数组，大小为56；分别表示a-z和A-Z，假设指定字符为c，如果位大写字母，对应的数组位置是c-'A'+26，对应的小写字母位置是c-‘a'；再使用一个列表记录字符的先后顺序和一个列表记录下标，这里给出一种牺牲空间的简化代码：

```java
public int FirstNotRepeatingChar(String str)
    {
        char[] c = str.toCharArray();
        int[] a = new int['z'];
        for (char d : c)
            a[(int) d]++;
        for (int i = 0; i < c.length; i++)
            if (a[(int) c[i]] == 1)
                return i;
        return -1;
    }
```

##### [牛客网]查找字符串中第一个只出现一次的字符的下标

这道题是上面题的变种，前面是字符均为字母，这道题是所有字符，不过所有字符也只有256个，因此开256的大小也没什么问题

```java
    int[] chars=new int[256];
    ArrayList<Character> list=new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        list.add(ch);
        chars[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(int i=0;i<list.size();i++){
            if(chars[list.get(i)]==1){
                return list.get(i);
            }
        }
        return '#';
    }
```



##### [牛客网]找出一个数组中出现超过一半的数字

这个其实也可以使用Map的，不过在下面的数学知识部分中给出一种巧妙的方法

##### [leetcode] 49.Group Anagrams（查找数组中由相同字符组成的所有字符串）

Given an array of strings, group anagrams together.

For example, given: `["eat", "tea", "tan", "ate", "nat", "bat"]`, 
Return:

```
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
] 
```

这道题要用到Map了，首先将每个字符串排序，相同字符组成的字符串必定有唯一的序列，这个作为Map的key，值位list，将key相等的值添加进来

```java
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> lists=new ArrayList<>();
        char[] chars;
        String temp;
        for(int i=0;i<strs.length;i++){
            chars=strs[i].toCharArray();
            Arrays.sort(chars);
            temp=new String(chars);
            if(map.get(temp)==null){
                List<String> list=new ArrayList<>();
                map.put(temp,list);
            }
            map.get(temp).add(strs[i]);
        }
        for(String s :map.keySet()){
            lists.add(map.get(s));
        }
        return lists;
    }
```



##### [牛客网] 查找两个链表的第一个公共节点

首先，如果两个链表用公共节点，说明公共节点后面的节点两个链表共用，试想，从公共节点开始以相同的速度向两个链表的头部走，直到一个链表走到头部，其中一个链表没有走到头部，这个没走的节点就是多出来的节点；那么先找出两个链表的长度，长的链表先走完多出的节点，然后以相同的速度一起走，一定可以走到公共节点，判断条件是每次走过的节点是否相等；

```java
public ListNode getCommon(ListNode h1,ListNode h2,int num){
        while (num>0){
            h1=h1.next;
            num--;
        }
        while (h1!=null&&h1!=h2){
            h1=h1.next;
            h2=h2.next;
        }
        return h1;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1,length2;
        length1=length2=0;
        ListNode h=pHead1;
        while (h!=null){
            length1++;
            h=h.next;
        }
        h=pHead2;
        while (h!=null){
            length2++;
            h=h.next;
        }
        if(length1>length2){
            return getCommon(pHead1,pHead2,length1-length2);
        }else {
            return getCommon(pHead2,pHead1,length2-length1);
        }
    }
```

##### [牛客网]在递增数组中查找和为S且乘积最小的两个数

时间复杂度为O(n)，和相等且积最小，这两个数一定差距最远，那么直接用两个指针指向左边和右边，遍历使用如下方式：

如果a[i]+a[j]等于sum，返回

如果a[i]+a[j]大于sum，则j--

如果a[i]+a[j]小于sum，则i--

```java
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arr=new ArrayList<>();
        int i,j;
        i=0;
        j=array.length-1;
        while (i<j){
            if(array[i]+array[j]==sum){
                arr.add(array[i]);
                arr.add(array[j]);
                return arr;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return arr;
    }
```

##### [牛客网] 查找中位数

这里使用小根堆和大根堆来实现，时间复杂度为nlogn

下面的PriorityQueue即为优先队列（小根堆），再其中重写比较函数可以转为大根堆

```java
    private int count=0;
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void Insert(Integer num){
        if(count%2==0){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }
    public Double GetMedian(){
        if(count%2==0){
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }else {
            return minHeap.peek()*1.0;
        }
    }
```

##### [leetcode] 53. 和最大连续子串

```java
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(currSum <= 0){
                currSum = nums[i];
                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }
            else{
                currSum += nums[i];
                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }
```



#### 二分查找

这里提一下二分查找的原理，第一个元素下标作为low，最后一个元素下标作为high，middle取low+(high-low)/2，注意这里偶数取小的一个数

##### [牛客网]统计一个数字在排序数组中出现的次数

先用二分查找找到指定的数字，然后从该数字的下标开始，向左向右遍历，知道不等于该数字停止，记录出现的次数，返回num

### 2.4 遍历

##### [牛客网] 从尾到头打印链表

和前序遍历，后序遍历，中序遍历的方法一样；先递归，后打印

##### [牛客网] 顺时针打印矩阵

这种问题同样是找规律，每次都会执行向右遍历，向下遍历，向左遍历，向上遍历这四个过程，不同的是这四个过程的边界条件不同

```java
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arr=new ArrayList<>();
        if(matrix==null||matrix.length==0)return arr;
        int len1s,len2s,len1e,len2e;
        len1s=len2s=0;
        len1e=matrix.length-1;
        len2e=matrix[0].length-1;
        int i,j;
        i=j=0;
        while (true){
            switch (1){
                case 1:
                    if(j<=len2e){
                        while (j<=len2e){
                            arr.add(matrix[i][j]);
                            j++;
                        }
                        j--;
                        i++;
                        len1s++;
                    }else {
                        return arr;
                    }
                case 2:
                    if(i<=len1e){
                        while (i<=len1e){
                            arr.add(matrix[i][j]);
                            i++;
                        }
                        i--;
                        j--;
                        len2e--;
                    }else {
                        return arr;
                    }
                case 3:
                    if(j>=len2s){
                        while (j>=len2s){
                            arr.add(matrix[i][j]);
                            j--;
                        }
                        j++;
                        i--;
                        len1e--;
                    }else {
                        return arr;
                    }
                case 4:
                    if(i>=len1s){
                        while (i>=len1s){
                            arr.add(matrix[i][j]);
                            i--;
                        }
                        i++;
                        j++;
                        len2s++;
                    }else {
                        return arr;
                    }
            }
        }
    }
```

##### [牛客网] 层次遍历

按层打印二叉树的节点值

在队列中讲过，使用队列

##### [牛客网]二叉树之字遍历

刚开始看到这道题想到的就是层次遍历，那么直接用队列即可，而这道题要区分每一层，那么用两个队列即可，第二个队列中的元素输出时要逆序，那我先用stack接收，然后再赋给ArrayList即可，这样这道题就通过了； 

看了一下讨论的答案，发现stack这一步比较费时，那就去掉呗，这样队列用起来就不好了，使用两个栈，第一个栈遍历存储时，从节点的左节点开始到右节点；第二个栈遍历存储时，从节点的右节点开始到左节点，这样便解决了费时的问题；代码如下

```java
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
```



##### [牛客网]中序遍历

将二叉搜索树转为一个排序的双向链表，不能创建新的节点，只能调整树中节点指针的指向

```java
/*
    二叉搜索树转排序的双向链表
    实质就是中序遍历，只是将中序遍历中打印部分修改位指针指向部分
     */

    TreeNode index=null;
    TreeNode head=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ZXBL(pRootOfTree);
        return head;
    }
    //中序遍历
    private void ZXBL(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ZXBL(pRootOfTree.left);
        if(head==null){
            head=pRootOfTree;
            index=pRootOfTree;
        }else {
            index.right=pRootOfTree;
            pRootOfTree.left=index;
            index=pRootOfTree;
        }
        ZXBL(pRootOfTree.right);
    }
```

#### DFS

太多这样的题目了。。。

##### [牛客网] n*m的矩阵中满足条件的可达格子数 

地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？



这种题目最为简单，只用找到子问题，递归即可 

子问题是对于一个格子，判断是否可走，如果该格子可走，那么它下一步就是4个这样的子问题，不断递归，便可解得 

代码如下：

```java
    public static int movingCount(int threshold, int rows, int cols) {
        if(rows==0||cols==0)return 0;
        int[][]flag=new int[rows][cols];
        return isArrival(0,0,threshold,flag);
    }

    //子问题，判断该格子是否可走，可以则返回下一步的4个方位的格子
    private static int isArrival(int i, int j,int threshold, int[][] flag) {
        if(isSatisfy(i,j,threshold,flag)){
            flag[i][j]=1;
            return isArrival(i-1,j,threshold,flag)+isArrival(i+1,j,threshold,flag)+
                    isArrival(i,j-1,threshold,flag)+isArrival(i,j+1,threshold,flag)+1;
        }
        return 0;
    }

    //判断该格子是否可走
    private static boolean isSatisfy(int i, int j,int threshold,int[][]flag) {
        if(!((i>=0&&i<flag.length)&&(j>=0&&j<flag[0].length)))return false;
        if(flag[i][j]==1)return false;
        String s1=String.valueOf(i);
        String s2=String.valueOf(j);
        int temp=0;
        for(int k=0;k<s1.length();k++)temp+=s1.charAt(k)-'0';
        for (int k=0;k<s2.length();k++)temp+=s2.charAt(k)-'0';
        if(temp>threshold)return false;
        return true;
    }
```



## 3 方法

### 3.1 统计问题

比如统计一个数组中每个元素出现的个数：

这样的题变种有，查找第一次出现一次的字符，判断是否有相同元素，等等，一般解法是用Map来解决，但是对于有限的数的统计问题，是可以巧解的

比如统计字符，字符的范围就是256，那开辟一个大小为256的数组即可，如果是字母，则开辟52的大小即可，然后将字符的大小作为数组的小标，这样岂不是达到了Map的效果

比如查看一个数组中是否有重复的元素，如果这个数组中的元素在一个范围内，如1-13之间，那我用一个整形flag来存储，比如2，我将flag转为二进制后的第2位的值置为1，下面来一个元素，则只用判断该元素对应的位上是否为1（将flag移动该元素值的位数，和1与运算）就可以知道前面是否有和该元素相同的元素。

### 3.2 查找问题

从最后一个元素向前遍历



### 3.3 DFS 问题

一般不要用DFS去解，看有没有简单的解法，最后考虑用DFS

##### [leetcode]  55. Jump Game

给定一个数组，其中的元素代表能够向前走的最大步数，问这个数组能否走到最后一个元素

For example:
A = `[2,3,1,1,4]`, return `true`.

A = `[3,2,1,0,4]`, return `false`.

我首先想到的就是DFS，从1到第i个元素的值加该元素的下标是下一个要走的元素下标，如果可以走到头，则返回,对DFS已经简化了

```java
    public static boolean canJump(int[] nums) {
        if(nums==null||nums.length<=1)return true;
        return jumpDfs(0,nums);
    }

    private static boolean jumpDfs(int i, int[] nums) {
        if(i>=nums.length-1)return true;
        boolean flag=false;
        int j=nums[i];
        if(j>0){
            flag=jumpDfs(i+j,nums);
            j--;
            while (!flag&&j>0)flag=jumpDfs(i+(j--),nums);
            return flag;
        }else return false;
    }

```

但是仍然超时了，其实这道题只用记录走该元素时判断能到的最大下标是否大于等于该元素下标，如果大于，则表示能够走，否则返回false

```java
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }
```

## 4 模板

### 4.1 字符串

#### 4.1.1字符串字典序排序

给定字符串的下一个字典排序

```java
private static String NextDictOrder(String str) {
        int i=str.length()-2;//必须满足字符串长度大于1
        int j;
        char minChar=' ';//不可能为空
        int index=0;
        char[] chars;
        while (i>=0){
            if(str.charAt(i)<str.charAt(i+1)){
                j=i+1;
                minChar=str.charAt(j);
                index=j;
                while(j<str.length()){
                    if(str.charAt(j)>str.charAt(i)&&str.charAt(j)<minChar){
                        index=j;
                        minChar=str.charAt(j);
                    }
                    j++;
                }
                break;
            }
            i--;
        }
        chars=(str.substring(i,index)+str.substring(index+1,str.length())).toCharArray();
        Arrays.sort(chars);
        str=str.substring(0,i)+minChar+String.valueOf(chars);
        return str;
    }
```





## 5  错误详解

###  数组越界问题

#### [leetcode]150.Evaluate Reverse Polish Notation

如头部忘记判断：

```java
if(i==0||(s.charAt(i-1)!='+'&&s.charAt(i-1)!='-'))
```

尾部忘记判断：

```java
while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9')
```

###  特殊情况的考虑

##### 最大连续子串

需要单独考虑全是负数的情况【至少用我的方法是这样的】

### 小错误

1. 注意题目中的整数还包括负数的情况，总是忘掉！！！
2. 字符串为空的情况

## 6  Java在算法中的使用

#### StringBuffer

```
str.deleteCharAt(i)//删除指定字符
str.insert(i," ")//在指定位置插入字符串
stringBuffer.reverse()//反转
```

#### toBinaryString

```java
Integet.toBinaryString(5)//将5转为二进制的字符串形式，这里整形为32位，负数的二进制为正数的二进制取反加1
```

#### LinkedList

```java
Queue<String> queue = new LinkedList<String>();//new队列
/*
在尾部添加： add(),offer()
获取头部元素，并删除：remove(),poll()
获取头部元素，不删除：element(),peek()
队列中的add,remove,element方法失败时抛异常，offer,poll,peek失败则不会抛异常
*/
```

#### PriorityQueue

优先队列，即小根堆，改变其比较函数，变为大根堆，如下所示：

```java
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
```

#### Iterator

这是迭代器，如果不想出栈，或者出队，而去遍历栈或队列，可以使用它

```java
Stack<Integer> stack = new Stack<Integer>();        
int min = stack.peek();
int tmp = 0;
Iterator<Integer> iterator = stack.iterator();//栈的迭代器
while (iterator.hasNext()){
    tmp = iterator.next();
    if (min>tmp){
        min = tmp;
    }
}
return min;
```

#### Set

```java
        //遍历set，set中存放string
        Iterator<String> iterable=set.iterator();
        while (iterable.hasNext()){
            temp=iterable.next();
            System.out.println(iterable.next());
        }
        
```

#### Map

```java
//遍历Map
for(String s :map.keySet()){
    lists.add(map.get(s));
}
```



#### Collections.sort()

```java
/*
这里面第一个参数为一个list，第二个参数可以默认，也可以重写：即重写compare和wquals方法
例如对于compare()函数：
    如果返回1表示list中的元素降序排序，即o2，o1
    如果返回-1表示list中的元素升序排序，即o1，o2
    返回0，默认排序
*/
Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1);
                String s2=String.valueOf(o2);
                return s2.compareTo(s1);
            }
        });
```

#### new String()

字符数组转字符串

```java
new String(str).substring(1).toCharArray();
```

#### equals和==

equals比较的时对象的内容，==比较的时两个对象是否相等

#### matches

```java
"aaa".matches("a*a");
```



### 小计

1. Java中返回数多得话，可以用传入的参数代替，比如参数取数组之类的
2. 树的问题全是分治问题，即递归问题
3. 递归调用时，如果需要返回两个值，可以用全局变量