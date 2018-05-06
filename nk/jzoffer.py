#1.二维数组中的查找
"""
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
"""
"""
从左下角开始，右上角结束【这里就是将矩阵逐渐缩小】
每次比较的时候：
当目标元素小于当前元素的时候，向上走【也就是当前行不用考虑】
当目标元素大于当前元素的时候，向右走【也就是当前列不用考虑】
当目标元素等于当前元素的时候，返回true

"""
def Find(target, array):
    i=len(array)-1
    j=0
    while(i>=0 and j<len(array[0])):
        if array[i][j]>target:i-=1
        elif array[i][j]<target:j+=1
        else:return True
    return False

#2.替换空格
def replaceSpace( s):
    res='';
    for i in s:
        if i==' ':res+='%20'
        else:res+=i;
    return res;

#3.输入一个链表，从尾到头打印链表每个节点的值。
#使用python中的list的加法解决。

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
def printListFromTailToHead(listNode):
    if listNode is None:return []
    else: return printListFromTailToHead(listNode.next)+[listNode.val]

#4.重建二叉树（由中序遍历和前序遍历得到二叉树）
#python实现的这个代码特别的简单，用的是python的切片，记一下
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def reConstructBinaryTree(pre, tin):
    if not pre or not tin:return None
    t=TreeNode(pre[0])#注意python中new一个对象的方式
    index=tin.index(pre[0])#获取值的下标
    t.left=reConstructBinaryTree(pre[1:index+1],tin[:index])
    t.right=reConstructBinaryTree(pre[index+1:],tin[index+1:])
    return t
#这个是我在讨论上找到的，其中pop用的非常的到位，相当于走了一遍前序遍历，不过我上面的方法比较传统，好理解
"""
链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
来源：牛客网

    def reConstructBinaryTree(self, pre, tin):
        if not pre or not tin:
            return None
        root = TreeNode(pre.pop(0))
        index = tin.index(root.val)
        root.left = self.reConstructBinaryTree(pre, tin[:index])
        root.right = self.reConstructBinaryTree(pre, tin[index + 1:])
        return root
"""
#还有下面这个java的代码，写的非常的清晰
"""
链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
来源：牛客网

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
         
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                      break;
            }
                 
        return root;
    }
}
"""
#5. 略
#6.旋转数组的最小数字
"""
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
"""
"""
这道题其实是两个问题，一个问题是如果没有重复的元素，该如何解决；
另一个进阶问题是如果有重复的元素，该如何解决
这里比较的时候一定要记住用中间的值和右边的值相比较，因为对于两个元素的问题左边的和中间的是相等的，
在处理相同元素的问题时只要让区间缩小一个就可以了
"""
def minNumberInRotateArray(rotateArray):
    #if len(rotateArray)==0:return 0
    left=0
    right=len(rotateArray)-1
    if left<right:
        mid=int(left+(right-left)/2)
        if rotateArray[mid]<rotateArray[right]:return minNumberInRotateArray(rotateArray[:mid+1])#最小值在左边，可能在mid位置
        elif rotateArray[right]<rotateArray[mid]:return minNumberInRotateArray(rotateArray[mid+1:])#最小值在右边，不可能在mid位置
        else:return minNumberInRotateArray(rotateArray[:right])#相等的情况，不确定，需要缩小区间，相同的两个元素去掉一个不影响最后的结果
    return rotateArray[left]

#7.斐波那契数列
#大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
"""
斐波那契数列
第0项为0，第一项为1，第二项为1，第三项为2。。。
也就是说第n项等于第n-1项加第n-2项
这里下面注释掉的代码直接用递归写，最为简单，但是超时，因为在递归的过程中会重复计算很多项
比如Fibonacci(8)等于Fibonacci(7)+Fibonacci(6)，而Fibonacci(7)又等于Fibonacci(6)+Fibonacci(5)。。。
可以发现我们只是递归了两次，就出现了重复的，那么如何避免重复的呢，使用动态规划
这里不需要矩阵，因为当前值只与前面两个值相关，记录前面两个值就可以了
"""
"""
def Fibonacci(n):
    if n==0:return 0
    if n==1:return 1
    return Fibonacci(n-1)+Fibonacci(n-2);
"""
def Fibonacci(n):
    pre1=0
    pre2=1
    if n==0:return 0
    if n==1:return 1
    """
    注意range(2,n)表示的是从2开始，到n-1之间的数，不包括n，因此后面需要自行计算n，
    当然也可以直接写成range(2,n+1)
    """
    for i in range(2,n):
        temp=pre2
        pre2=pre1+pre2
        pre1=temp
    return pre1+pre2


#8. 跳台阶
"""
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
"""
"""
这道题的原理就是上面的斐波那契数列
比如要跳上n级台阶，我们第一步可以跳1个台阶或者2个台阶，即还剩n-1级台阶和n-2级台阶这两种情况需要继续跳
问题等价于：跳n级台阶等于跳n-1级台阶和n-2级台阶的跳法总和
"""
def jumpFloor(number):
    pre1=1
    pre2=2
    if number==1:return 1
    if number==2:return 2
    for i in range(3,number+1):
        temp=pre2
        pre2=pre1+pre2
        pre1=temp
    return pre2

#9.变态跳台阶
"""
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
求该青蛙跳上一个n级的台阶总共有多少种跳法。
"""
"""
这个就是一个比较标准的dp问题
跳上0个台阶需要0步
跳上1个台阶需要1步
跳上两个台阶的情况可以是跳一步剩一个台阶，或者是跳两步
跳上三个台阶的情况可以是跳一步剩两个台阶，跳两步剩一个台阶，或者是跳3步
。。。
跳上n个台阶的情况可以是跳一步剩n-1个台阶，跳两步剩n-2个台阶...,或者是跳n步

用dp[i]表示跳上一个i级的台阶的跳法
"""
def jumpFloorII(number):
    dp=[]
    for i in range(number+1):
        if i==0:dp.append(0)
        elif i==1:dp.append(1)
        else:dp.append(sum(dp)+1)#sum计算dp前面的和，接收一个迭代器
    return dp[number]

#10.矩形覆盖
"""
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
"""
"""
和之前的题目是一个类型，找通项公式
对于2*n的大矩阵：
如果将一个小矩阵竖直放，那么后面的放置方法就相当于对2*(n-1)的大矩阵处理
如果将一个小矩阵横放，那么后面的放置方法就相当于对2*(n-2)的大矩阵处理

这样用dp[i]表示2*i的矩阵的放置方法，得到通项公式如下：
dp[i]=dp[i-1]+dp[i-2]
"""
def rectCover(number):
    #初始条件
    p1=1#number等于1的情况
    p2=2#number等于2的情况
    if number<3:return number
    #通项公式
    for i in range(3,number+1):
        temp=p2
        p2=p1+p2
        p1=temp
    return p2

#11.二进制中1的个数【记】
"""
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
"""
"""
正数的原码和补码相同
负数的原码是将正数的二进制表示后的最高位置1来作为负数的原码
负数的补码是将该数的绝对值的原码取反加1

这道题一般的解题思路是用一个标志位去和目标值进行与运算，如果为1，表示目标值该位为1
然后移动标志位，知道标志位的1移出边界

当然这里不会用上面这种方法，这里使用如下解法：
对一个数字减1后，数字的二进制中最右边的1变为0，最右边1后面的0全部变为1
对比数字的二进制和该数字减1后的二进制，可以发现最右边1的左边的进制都没有变化，只是右边1及其后面的进制发生了反转
这样可以将两个数字进行与运算，其结果对于之前的数字只是将最右边的1变为了0
负数的补码亦同
"""
def NumberOf1(n):
    count=0
    if n < 0:n = n & 0xffffffff#这里要消除负数的最高位（符号位）
    while n:
        count+=1
        n=n&(n-1)
    return count


#12.数值的整数次方
"""
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
"""
"""
相当于二分，减少了乘法的次数
比如x*x*x*x （x,4)
这里由于n=4，那么可以看成(x*x,2)的情况，并继续调用该方法，这里计算最后的结果只用了两次乘法
再比如x*x*x*x*x  (x,5)
这里n=5，可以看成x(x*x,2)的情况，继续调用该方法...
"""
def Power(base, exponent):
    if exponent==0:return 1
    if exponent<0:
        base=1/base
        exponent=-exponent
    return Power(base*base,int(exponent/2)) if exponent%2==0 else base*Power(base*base,int(exponent/2))


#13.调整数组顺序使奇数位于偶数前面
"""
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。
"""

"""
我想保证空间复杂度为O(1)，以下方法比较复杂，可以直接开辟一个数组，会简单很多
从头开始遍历数组，遇到偶数就停止，然后将偶数后面的数字全部向前移动一位，偶数放置在最后面的位置
用j记录偶数部分的起始位置，当i遍历到j处时，停止遍历
这里需要注意如果全是奇数的问题，也就是要判断i<len(array)，还有当i走到第一个偶数位置时，是不需要交换的
"""
def reOrderArray(array):
    j=len(array)
    i=0
    while i<j and i<len(array):
        while i<len(array) and array[i]%2==1 :i+=1
        if i<j:
            temp = array[i]
            k = i
            while k < len(array) - 1:
                array[k] = array[k + 1]
                k += 1
            array[len(array) - 1] = temp
            j -= 1
    return array



#14.链表中倒数第k个结点
"""
输入一个链表，输出该链表中倒数第k个结点。
"""
"""
先统计链表的个数n，然后遍历到n-k处即可
"""
def FindKthToTail(head, k):
    n=0
    p=head
    while p:
        n+=1
        p=p.next
    p=head
    if n<k:return None #注意k越界的问题
    for i in range(n-k):p=p.next
    return p

#15.反转链表
"""
输入一个链表，反转链表后，输出链表的所有元素。
"""
"""
用两个指针p，q，一前一后，中间变换的时候需要用到temp存储临时值
"""
def ReverseList(pHead):
    if pHead is None or pHead.next is None:return pHead
    p=pHead
    q=pHead.next
    p.next=None
    while q:
        temp= q.next
        q.next=p
        p=q
        q=temp
    return p

#16.合并两个排序的链表
"""
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
"""
"""
用一个哑元节点，这里用传统的归并排序思想
"""
def Merge(pHead1, pHead2):
    node=ListNode(0)
    p=node
    p1=pHead1
    p2=pHead2
    while p1 and p2:
        if p1.val<p2.val:
            p.next=p1
            p1=p1.next
        else:
            p.next=p2
            p2=p2.next
        p=p.next
    if p1:p.next=p1
    if p2:p.next=p2
    return node.next

#17.树的子结构【比较经典的一道题】
"""
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
"""
"""
树的问题一般都会使用子问题的解法
对于判断第二棵树是否是第一棵树的子树而言,对第一棵树的每个节点当成第二棵树的根节点来比较就可以了
因此问题变成如下问题
比较根节点isSubtree(pRoot1,pRoot2)
两个子问题：HasSubtree(pRoot1.left,pRoot2) or HasSubtree(pRoot1.right,pRoot2)

"""
def HasSubtree(pRoot1, pRoot2):
    if pRoot2 is None or pRoot1 is None:return False
    return isSubtree(pRoot1,pRoot2) or HasSubtree(pRoot1.left,pRoot2) or HasSubtree(pRoot1.right,pRoot2)

def isSubtree(pRoot1,pRoot2):
    if pRoot2 is None:return True
    if pRoot1 is None: return False
    if pRoot1.val!=pRoot2.val:return False
    else:return isSubtree(pRoot1.left,pRoot2.left) and isSubtree(pRoot1.right,pRoot2.right)

#18.二叉树的镜像
"""
操作给定的二叉树，将其变换为源二叉树的镜像。
"""
"""
交换根节点的左右子树，然后对其左右子树进行同样的工作
"""
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def Mirror(root):
    if root:
        temp=root.left
        root.left=root.right
        root.right=temp
        Mirror(root.left)
        Mirror(root.right)

#19.顺时针打印矩阵
"""
先计算圈数，然后一圈一圈的打印，注意后面两个for可能会重复前面的(最后的圈可能是一行或一列)，所以需要判断
之前用java中的switch写的，给定4个方向，不停的在switch中循环，直到没有可走的地方返回
"""
def printMatrix(matrix):
    if len(matrix)==0:return []
    row=len(matrix)#行
    col=len(matrix[0])#列
    circle=((row if row<col else col)-1)/2+1#圈数
    res=[]
    for i in range(circle):
        for j in range(i,col-i):res.append(matrix[i][j])#从左到右
        for j in range(i+1,row-i):res.append(matrix[j][col-i-1])#从上到下
        if i<row-i-1 :
            for j in range(col-i-2,i-1,-1):res.append(matrix[row-i-1][j])#从右到左
        if i<col-i-1:
            for j in range(row-i-2,i,-1):res.append(matrix[j][i])#从下到上
    return res

#20.包含min函数的栈
"""
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
"""
"""
链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49
来源：牛客网

思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数
比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
       则min依次入栈，5,  4,  3，no,no, no, no, 1
 
no代表此次不如栈
每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不入栈。

代码略
"""

#21.栈的压入、弹出序列
"""
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
"""
"""
对pushV进行遍历，如果和popV的第一个元素不等，就添加到res中，否者删除，并在res中进行判断
"""
def IsPopOrder(pushV, popV):
    res=[]
    for val in pushV:
        if val==popV[0]:
            popV.pop(0)
            while len(res)>0 and res[-1]==popV[0]:
                popV.pop(0)
                res.pop(-1)
        else:res.append(val)
    return len(popV)==0

#22.从上往下打印二叉树
"""
从上往下打印出二叉树的每个节点，同层节点从左至右打印
"""
"""
利用队列的思想实现
将根节点入队，对队中的节点出队，并将出队节点的左右子节点添加到队列中
"""
def PrintFromTopToBottom(root):
    nodeList=[]
    if root:nodeList.append(root)
    res=[]
    while len(nodeList)>0:
        temp=nodeList.pop(0)
        res.append(temp.val)
        if temp.left :nodeList.append(temp.left)
        if temp.right:nodeList.append(temp.right)
    return res

#23.二叉搜索树的后序遍历序列
"""
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
"""
"""
最后一个元素是根节点，可以将树分成两个子树，小于根节点的部分为左子树，大于根节点的部分为右子树
确定左子树后，判断右边部分是否满足条件，不满足就返回false
这里写的python代码使用切片一个函数就搞定了，这也是为什么我不喜欢用python写算法的原因
"""
def VerifySquenceOfBST(sequence):
    if not sequence:return False
    i=0
    while i<len(sequence)-1 and sequence[i]<sequence[-1]:i+=1
    j=i
    while j<len(sequence)-1 and sequence[j]>sequence[-1]:j+=1
    if j!=len(sequence)-1:return False
    return True if len(sequence[:i])<=1 else VerifySquenceOfBST(sequence[:i]) and True if len(sequence[i:len(sequence)-1])<=1 else VerifySquenceOfBST(sequence[i:len(sequence)-1])

"""
给出C++版本
链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
来源：牛客网

BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
如果去掉最后一个元素的序列为T，那么T满足：
T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。

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
"""

#24.复杂链表的复制
"""
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
"""
"""
这里使用的方法分三部分：拼接，赋值，分离
拼接：将新的节点交叉在原有链表中
赋值：拼接的目的是为了寻找random节点，原始链表的random节点对应着复制链表的random节点之间的关系是：
在拼接后的链表中random节点的next节点为复杂链表的random节点
需要判断random节点是否为空，空节点是没有next的
分离：这里要还原原始链表和生产复制链表，对拼接的链表，让当前节点指向下一个节点即可
"""
class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None
def Clone(pHead):
    if pHead is None:return pHead
    #拼接
    p=pHead
    while p:
        temp=RandomListNode(p.label)
        temp.next=p.next
        p.next=temp
        p=temp.next
    head=pHead.next
    #赋值
    pre=pHead
    p=pHead.next
    while p:
        if pre.random:p.random=pre.random.next
        pre=p.next
        p=p.next if pre is None else pre.next
    #分离
    p=pHead
    while p.next:
        temp=p.next
        p.next=temp.next
        p=temp
    return head

#25.二叉搜索树与双向链表【比较重要】
"""
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
"""
"""
这道题的实质是中序遍历，问题的关键是前驱节点如何静态化
java之前实现的时候是采用全局变量，python这里使用了一个list来存储
"""
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
def Convert(pRootOfTree):
    if pRootOfTree is None:return pRootOfTree
    preNode=[None]
    coverHelper(pRootOfTree,preNode)
    res=pRootOfTree
    while res.left:res=res.left
    return res
def coverHelper(node,preNode):
    if node:
        coverHelper(node.left,preNode)
        temp=preNode.pop(0)
        node.left=temp
        if temp:temp.right=node
        preNode.append(node)
        coverHelper(node.right,preNode)

#26.字符串的排列
"""
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
"""
"""
这道题实际上是两个题，一道是找下一个字典序，一道是排序的题目
字典序：
从右开始遍历，知道找到一个字符，该字符比它后面的字符小，然后用它后面的大于它的最小字符替换，在把它后面的字符排序即可
所有的字典序：
一个一个迭代即可，知道为逆序停止
"""
def Permutation(ss):
    res=[]
    temp=''.join(sorted(ss,reverse=True))
    ss=''.join(reversed(temp))
    res.append(ss)
    while ss!=temp:
        ss=getNext(ss,res)
        print(ss)
    print(len(res))
    return res
def getNext(ss,res):
    i=len(ss)-1
    ss=list(ss)
    while i>0 and ss[i-1]>ss[i]:i-=1
    if i>0:
        j = len(ss) - 1
        while ss[j] <= ss[i - 1]: j -= 1
        temp = ss[j]
        ss[j] = ss[i - 1]
        ss[i - 1] = temp
        ss = ''.join(ss[:i]) + ''.join(reversed(ss[i:]))
        res.append(ss)
    return ss

#27.数组中出现次数超过一半的数字
"""
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
如果不存在则输出0。
"""
"""
一个出现次数过半的数字，和其他的数字进行抵消，剩下的数字一定是该数字
关键的问题是如何将上面的实现
用两个变量来记录，一个表示数字，一个表示该数字抵消前面的数字后的剩余次数
"""
def MoreThanHalfNum_Solution(numbers):
    if numbers is None:return 0
    if len(numbers)==1:return numbers[0]
    res=numbers[0]
    num=0
    for val in numbers:
        if val==res:num+=1
        else:num-=1
        if num<0:
            res=val
            num+=1
    return res if num>0 else 0

#28.最小的K个数
"""
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
"""
"""
使用一个最大堆，最大堆始终维持k个数，最后输出这k个数
"""

#29.连续子数组的最大和
"""
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
你会不会被他忽悠住？(子向量的长度至少是1)
"""
"""
用一个值记录每次相加后的最大值，如果当前值小于0，则用0代替
最后求数组中的最大值是否大于0，如果小于0，返回这个最大值
"""
def FindGreatestSumOfSubArray(array):
    res=0
    maxRes=0
    for val in array:
        res+=val
        if res<0:res=0
        if maxRes<res:maxRes=res
    return max(array) if max(array)<0 else maxRes

#30 整数中1出现的次数
"""
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
"""
"""
使用的是递归的方法；时间复杂度为O(log10n)
思路：
1. 对于一个数n，先判断是否为个数，如果是且大于等于1，则返回1；
如果是且等于0，则返回0；否则执行下一步
2. 取n中第一位为a，取n中后面其它位为b；（如n=123，则a=1，b=23）
3. 如果a大于1，表明数n的最高位经历了最高位为1的全部情况
（比如n=223，a=2；n的最高位经历了100，101，102，103，...，199，200，201，...，223这么多数，这里我只计算这些数中最高位为1的个数，为100；
类似的，对于n的位数为4时，是1000，为5时，是10000...）；代码中用times表示
如果等于1，表明数n的最高位经历了b+1次为1的情况
（比如n=123，a=1；说明n经历了100，101，102，...，123这24次最高位为1的情况，即b+1）
【此处只考虑最高位，其它位使用递归】；
4. 此时还需要算除b以外的其它位上经历1的个数（整数部分的1，下面的1到times-1），
这里直接递归使用a*NumberOf1Between1AndN_Solution(times-1),
其中times表示的是和n同位数的最小整数
（这里解释一下：比如n=223,a=2,b=23；这里times=100，
因为a=2，表明n经历了从1到times-1的全部数有a次，即1到99经历了2次，那么计算99中1的个数乘以2就是除b以外其它位上经历1的个数）
5. 最后还需要算b中经历1的个数，直接调用原函数即可
"""
def NumberOf1Between1AndN_Solution(n):
    if n<10:return 0 if n==0 else 1
    times=pow(10,len(str(n))-1)
    a=int(str(n)[0])
    b=int(str(n)[1:])
    return times+a*NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b) if a>1 else b+1+NumberOf1Between1AndN_Solution(times-1)+NumberOf1Between1AndN_Solution(b)


#31.丑数
"""
把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
"""
"""
用res存储一个丑数列表
用三个指针i,j,k指向列表元素分别对应乘以2，3，5，然后选取最小的值作为下一个丑数，对应的指针加1
"""
def GetUglyNumber_Solution(index):
    if index==0:return 0
    res=[1]
    i=0
    j=0
    k=0
    n=1
    while n<index:
        res.append(min(res[i]*2,min(res[j]*3,res[k]*5)))
        if res[-1]==res[i]*2:i+=1
        if res[-1]==res[j]*3:j+=1
        if res[-1]==res[k]*5:k+=1
        n+=1
    return res[-1]

#32.第一个只出现一次的字符
"""
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
"""
"""
用一个数组记录字符出现的顺序，用一个map记录字符出现的个数
遍历数组，找到第一个在map对应value等于1的字符c，然后返回c的index
"""
def FirstNotRepeatingChar(s):
    res=[]
    resMap={}
    for c in s:
        if c not in resMap.keys():
            resMap[c]=0
            res.append(c)
        resMap[c]+=1
    for c in res:
        if resMap[c]==1:return s.index(c)
    return -1

#33.数组中的逆序对
"""
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5
"""
"""
有两种解法，时间复杂度都是nlgn，一个是二叉搜索树（略），一个是归并排序
归并排序：
在归并的时候，一般归并是按照从小到大的顺序添加到原位置，此处使用反向
当第一个数组的值大于第二个数组的值的时候，这是计数器加上第二个数组现存的数字个数
参考：https://www.nowcoder.com/questionTerminal/96bd6684e04a44eb80e6a68efc0ec6c5
python在牛客网上超时。。。
"""
def InversePairs(data):
    res=[0]
    mergeSort(data,0,len(data)-1,res)
    print(data)
    return res[0]
def mergeSort(data,p,r,res):
    if p<r:
        q=p+int((r-p)/2)
        mergeSort(data,p,q,res)
        mergeSort(data,q+1,r,res)
        merge(data,p,q,r,res)
def merge(data,p,q,r,res):
    d1=[]
    d2=[]
    i=p
    while i<=r:
        if i<=q:d1.append(data[i])
        else:d2.append(data[i])
        i+=1
    i=len(d1)-1
    j=len(d2)-1
    while i>=0 or j>=0:
        if i<0:
            data[r]=d2[j]
            j-=1
        elif j<0:
            data[r]=d1[i]
            i-=1
        elif d1[i]<d2[j]:
            data[r]=d2[j]
            j-=1
        else:
            res[0]+=j+1
            data[r]=d1[i]
            i-=1
        r-=1

#34.两个链表的第一个公共节点
"""
输入两个链表，找出它们的第一个公共结点。
"""
"""
先计算两个链表的长度，然后让长的链表先走差值的步数，最后一起走，判断是否相等，相等就返回
"""
def FindFirstCommonNode(self, pHead1, pHead2):
    n=0
    m=0
    p=pHead1
    q=pHead2
    while p:
        n+=1
        p=p.next
    while q:
        m+=1
        q=q.next
    p = pHead1
    q = pHead2
    if n>m:
        i=n-m
        while i>0:
            p=p.next
            i-=1
    else:
        i=m-n
        while i>0:
            q=q.next
            i-=1
    while q!=p:
        q=q.next
        p=p.next
    return q

#35.数字在排序数组中出现的次数
"""
统计一个数字在排序数组中出现的次数。
"""
"""
使用二分查找
这里注意列表中只有一个数字的情况，比如([3],3)
"""
def GetNumberOfK(data, k):
    l=0
    r=len(data)-1
    res=0
    while l<=r:
        m=l+int((r-l)/2)
        if data[m]<k:
            l=m+1
        elif data[m]>k:
            r=m-1
        else:
            index=m
            while index<=r and data[m]==data[index]:index+=1
            res=index-m
            index=m-1
            while index>=l and data[m]==data[index]:index-=1
            res+=m-index-1
            return res
    return res

#36.二叉树的深度
"""
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
"""
"""
树的问题一般转换为子树问题便可解决
这里根节点的高度等于两个子节点中最大的一个高度加1
"""
def TreeDepth(pRoot):
    if pRoot is None:return 0
    hl=0
    hr=0
    if pRoot.left: hl=TreeDepth(pRoot.left)
    if pRoot.right: hr=TreeDepth(pRoot.right)
    return hl+1 if hl>hr else hr+1

#37.平衡二叉树
"""
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
"""
"""
这道题牛客网上的测例有问题，没有判断是否为二叉搜索树
平衡二叉树一定是二叉搜索树，也就是说平衡二叉树既要满足左右节点差不大于1，又要满足root.left.val<root.val<root.right.val
"""
def IsBalanced_Solution(pRoot):
    res=[True]
    isBalanceTree(pRoot,res)
    return res[0]

def isBalanceTree(root,res):
    if root is None:return 0
    hl=0
    hr=0
    if root.left:hl=isBalanceTree(root.left,res)
    if root.right:hr=isBalanceTree(root.right,res)
    if abs(hl-hr)>1:res[0]=False
    if root.left and root.right:
        if not(root.val>=root.left.val and root.val<=root.right.val):res[0]=False
    elif root.left:
        if not (root.val>=root.left.val):res[0]=False
    elif root.right:
        if not (root.val<=root.right):res[0]=False
    return hl+1 if hl>hr else hr+1

#38.数组中只出现一次的数字
"""
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
"""
"""
先将全部的数字异或，在得到的值的二进制表示中任意找出为1的一位，按该位划分两组数组，分别将两组数组异或，返回
"""
def FindNumsAppearOnce(array):
    a=0
    b=0
    res=0
    for val in array:
        res^=val
    s=''.join(reversed(str(bin(res))[2:]))
    index=0
    for i in range(len(s)):
        if s[i]=='1':
            index=i
            break
    for val in array:
        s=''.join(reversed(str(bin(val))[2:]))
        if len(s)>index and s[index]=='1':a^=val
        else: b^=val
    return [a,b]

#39.和为S的连续正数序列
"""
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
"""
"""
i从1开始遍历直到目标值的一半，维持一个连续列表和该列表的和sum
如果sum小于目标值，就将i添加进去，然后判断是否等于
如果sum大于目标值，就从列表的左边开始删除元素，直到sum不大于目标值，然后判断是否等于
"""
def FindContinuousSequence(tsum):
    res=[]
    cur=[]
    sum=0
    i=1
    while i<tsum/2+2:
        sum+=i
        cur.append(i)
        if sum==tsum:
            if len(cur)>1:res.append(list(cur))#使用深拷贝
        else:
            while sum>tsum:sum-=cur.pop(0)
            if sum==tsum:
                if len(cur)>1:res.append(list(cur))
        i+=1
    return res

#40.和为S的两个数字
"""
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
"""
"""
两个数字之间隔得越远，它们的成绩就越小
用两个指针分别指向最左边和最右边，向中间靠拢
注意没有找到的情况
"""
def FindNumbersWithSum(self, array, tsum):
    i=0
    j=len(array)-1
    while i<j:
        sum=array[i]+array[j]
        if sum>tsum:j-=1
        elif sum<tsum:i+=1
        else:return [array[i],array[j]]
    return []

#41.左旋转字符串
"""
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
是不是很简单？OK，搞定它！
"""
"""
python中切片写算法的优势，有种投机取巧的感觉
"""
def LeftRotateString(s, n):
    return s[n:]+s[:n]

#42.翻转单词顺序
"""
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。
后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
"""
"""
将字符串分割为一个个单词列表，然后从列表的右边开始遍历，连接列表中的值
当为列表的最后一个元素时，不用添加空格
"""
def ReverseSentence(s):
    res=s.split(' ')
    s=''
    for i in range(len(res)-1,-1,-1):
        s+=res[i]+(' ' if i>0 else '')
    return s

#43.扑克牌的顺序
"""
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
为了方便起见,你可以认为大小王是0。
"""
"""
两个条件
除0外：没有重复元素，最小值和最大值的差值小于5
注意两个条件都要保证没有0的元素的情况下
"""
def IsContinuous(numbers):
    if len(numbers)==0:return False
    numbers=sorted(numbers)
    for i in range(1,len(numbers)):
        if numbers[i]!=0 and numbers[i]==numbers[i-1]:return False
    i=0
    while numbers[i]==0:i+=1
    if numbers[-1]-numbers[i]>=5 or len(numbers)!=5:return False
    return True

#44.孩子们的游戏(圆圈中最后剩下的数)
"""
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。
其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
"""
"""
用一个变量记录要删除元素的下标，每次删除后该下标就是下一轮的第一个元素，
对该变量进行取余就实现了循环列表，直到列表中的元素等于1，跳出while
"""
def LastRemaining_Solution(n, m):
    if m==0 or n==0:return -1
    res=[i for i in range(n)]
    i=0
    while len(res)>1:
        i=(i+m-1)%len(res)
        res.pop(i)
    return res[0]

#45.求1+2+3+...+n
"""
求1+2+3+...+n，
要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
"""
"""
没意义
"""
def Sum_Solution(n):
    return (pow(n,2)+n)>>1

#46，47 略
#48.数组中重复的数字
"""
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 数组中某些数字是重复的，但不知道有几个数字是重复的。
 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
"""
"""
这里用一个比较巧妙的方法，而不用开辟空间
数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志
当一个数字被访问过后，可以设置对应位上的数 + n
之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
******
当然可以开辟一个list，然后将遍历的数存在list中，每次遍历的时候查看list是否有该数字，有就返回
"""
# 这里要特别注意~找到任意重复的一个值并赋值到duplication[0]
#  函数返回True/False
def duplicate(self, numbers, duplication):
    n=len(numbers)
    for i in range(n):
        index=numbers[i]
        if index>n:index-=n
        if(numbers[index]>n):
            duplication[0]=index
            return True
        numbers[index]+=n
    return False

#49.构建乘积数组
"""
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。
"""
def multiply(self, A):
    B=[1]*len(A)
    for i in range(len(A)):
        for j in range(i):
            B[i]*=A[j]
    for i in range(len(A)):
        for j in range(i+1,len(A)):
            B[i]*=A[j]
    return B

#50.正则表达式
"""
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
"""
"""
*不可能出现在第一位
DP问题（比较难）
dp[i][j]表示1~i长度的字符串和1~j长度的模式串之间是否能够匹配
dp[0][0]表示长度为0的字符串和长度为0的模式串的匹配结果，True表示能够匹配
dp[0][j]表示长度为0的字符串和长度为j的模式串的匹配结果

有这么几种情况：
1. 如果第i个字符和第j个字符相等或者第j个字符是'.':
     那么长度为i-1的字符串和长度为j-1的模式串的匹配结果就是长度为i的字符串和长度为j-1的模式串的匹配结果
2. 如果第i个字符和第j个字符不相等：
     如果第j个字符是等于'*'：
       如果第j-1个字符等于第i个字符或者第j-1个字符为'.'，那么有三种情况，匹配0次，匹配1次[无数次]，匹配2次
       否则，只有一种情况，就是匹配0次
"""
def match(self, s, pattern):
    n=len(s)
    m=len(pattern)
    dp=[[False for i in range(m+1)] for i in range(n+1)]
    dp[0][0]=True
    for i in range(m):
        if pattern[i]=='*':dp[0][i+1]=dp[0][i-1]
    for i in range(n):
        for j in range(m):
            if s[i]==pattern[j] or pattern[j]=='.':dp[i+1][j+1]=dp[i][j]
            if pattern[j]=='*':
                if s[i]==pattern[j-1] or pattern[j-1]=='.':
                    dp[i+1][j+1]=dp[i+1][j]|dp[i+1][j-1]|dp[i][j+1]
                else:dp[i+1][j+1]=dp[i+1][j-1]
    return dp[n][m]

#51.略
#52.字符流中第一个不重复的字符
"""
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
"""
"""
和之前做过的一道题一样，开辟一个包含所有字符串大小的列表，然后统计其个数即可
代码略
"""
#53.链表中环的入口节点
"""
一个链表中包含环，请找出该链表的环的入口结点。
"""
def EntryNodeOfLoop(pHead):
    if pHead is None:return None
    fast=pHead
    slow=pHead
    while fast.next is not None and fast.next.next is not None :
        slow=slow.next
        fast=fast.next.next
        if slow==fast:break
    if fast.next is None or fast.next.next is None:return None
    fast=pHead
    while fast!=slow:
        fast=fast.next
        slow=slow.next
    return fast
#54.删除链表中重复的节点
#略
#55.二叉树的下一个节点


#print(Sum_Solution(1))
#print(IsContinuous([1,3,0,5,0]))
#print(ReverseSentence('I am a student.'))
#print(FindContinuousSequence(15))
#print(FindNumsAppearOnce([2,4,3,6,3,2,5,5]))
#print(GetNumberOfK([3],3))
#print(InversePairs([5,2,3,4,8,6,7,0]))
#print(FirstNotRepeatingChar('abcdedcba'))
#print(FindGreatestSumOfSubArray([6,-3,-2,7,-15,1,2,2]))
#MoreThanHalfNum_Solution([1,2,3,2,4,2,5,2,3])
#Permutation("abcd")
#print(reOrderArray([1]))
#print(Power(2,3))
#print(NumberOf1(10000))
#print(jumpFloorII(3))
#jumpFloor(3)
#Fibonacci(4)
#print(minNumberInRotateArray([2,2,1,2]))