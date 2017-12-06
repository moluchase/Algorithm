/**
 * @author pengsong
 * @date 17/12/6 上午8:46
 */

/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */

/*
先想个复杂的方法,就是先计算差价，然后对每个加油站进行遍历，时间复杂度为O(n^2)
disscuss上面赞最高的就是这道题希望写的，写的很好啊，我复制过来
https://discuss.leetcode.com/topic/1344/share-some-of-my-ideas
 */
public class LC134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res[]=new int[gas.length];
        for(int i=0;i<gas.length;i++){
            res[i]=gas[i]-cost[i];
        }
        for(int i=0;i<gas.length;i++){
            if(res[i]>=0&&isTravel(i,res))return i;
        }
        return -1;
    }

    private boolean isTravel(int i, int[] res) {
        int temp=i;
        int sum=0;
        for(;i<res.length;i++){
            sum+=res[i];
            if(sum<0)return false;
        }
        for(i=0;i<temp;i++){
            sum+=res[i];
            if(sum<0)return false;
        }
        return true;
    }
    public int canCompleteCircuit2(int[] gas, int[] cost){
        int start,total,tank;
        start=total=tank=0;
        for(int i=0;i<gas.length;i++){
            if((tank+=gas[i]-cost[i])<0){
                start=i+1;
                total+=tank;
                tank=0;
            }
        }
        return total+tank>0?-1:start;
    }
}
/*
I have thought for a long time and got two ideas:

If car starts at A and can not reach B. Any station between A and B
can not reach B.(B is the first station that A can not reach.)
If the total number of gas is bigger than the total number of cost. There must be a solution.
(Should I prove them?)
Here is my solution based on those ideas:
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int start(0),total(0),tank(0);
        //if car fails at 'start', record the next station
        for(int i=0;i<gas.size();i++) if((tank=tank+gas[i]-cost[i])<0) {start=i+1;total+=tank;tank=0;}
        return (total+tank<0)? -1:start;
    }
};
 */