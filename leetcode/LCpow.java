public class LCpow {
    public static double myPow(double x, int n) {
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

    public static void main(String[] args) {
        System.out.println(myPow(2.0,4));
    }
}
