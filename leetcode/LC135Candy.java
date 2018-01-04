/**
 * @author pengsong
 * @date 17/12/6 上午9:28
 */
/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */

/*
初看此题真不知道这道题hard在什么地方，然后就哗哗的写了下面的方法
先是对题意的误解（我不觉得），我的理解是如果两个值相等的话，candy应该相等，但是这里给出的是不需要，即为1就可以
那么反而简单了许多，好吧，submit的结果是TLE ：27/28
哦哦，该怎么解呢？？？
看来discuss上赞最高的解，果然是套路...[满满的套路]
https://discuss.leetcode.com/topic/5243/a-simple-solution
这种左右遍历的套路还是要学一下的，对于这种问题简直屡试不爽
 */
public class LC135Candy {
    public int candy(int[] ratings) {
        int num[]=new int[ratings.length];
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            if(i==0)num[i]=1;
            else {
                if(ratings[i]>ratings[i-1])num[i]=num[i-1]+1;
                //else if(ratings[i]==ratings[i-1])num[i]=num[i-1];
                else {
                    num[i]=1;
                    if(ratings[i]<ratings[i-1]&&num[i-1]==1){
                        num[i-1]=2;
                        int temp=i-2;
                        while (temp>=0&&ratings[temp]>ratings[temp+1]){
                            //if(ratings[temp]==ratings[temp+1]&&num[temp]<num[temp+1])num[temp]=num[temp+1];
                            if(ratings[temp]>ratings[temp+1]&&num[temp]<=num[temp+1])num[temp]=num[temp+1]+1;
                            temp--;
                        }
                    }
                }
            }
        }
        for(int i=0;i<num.length;i++){
            sum+=num[i];
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        int []sum=new int[ratings.length];
        int result=0;
        for(int i=0;i<sum.length;i++){
            sum[i]=1;
        }
        //left-right
        for(int i=1;i<sum.length;i++){
            if(ratings[i]>ratings[i-1])sum[i]=sum[i-1]+1;
        }
        //right-left
        for(int i=sum.length-1;i>0;i--){
            if(ratings[i-1]>ratings[i])sum[i-1]=Math.max(sum[i-1],sum[i]+1);
        }
        for(int i=0;i<sum.length;i++){
            result+=sum[i];
        }
        return result;
    }
}
