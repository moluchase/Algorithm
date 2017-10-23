public class LC069Sqrt {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int left=1;
        int right=x;
        int mid;
        while (true){
            mid=(left+right)/2;
            if(mid*mid>x){
                right=mid-1;
            }else {
                if((mid+1)*(mid+1)>x)return mid;
                left=mid+1;
            }
        }
    }

    public static void main(String[] args) {
        long time1,time2,time3;
        time1=System.currentTimeMillis();
        boolean temp;
        int x=100000000;
        System.out.println(time1);
        for (int i=1;i<x;i++){
            temp=i*i>x;
        }
        time2=System.currentTimeMillis();
        System.out.println(time2);
        for(int i=1;i<x;i++){
            temp=i>x/i;
        }
        time3=System.currentTimeMillis();
        System.out.println(time3);
    }
}
