public class NKisContinuous {
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

    public static void main(String[] args) {
        int num=3;
        System.out.println(num>>1);
        System.out.println(num<<1);
    }
}
