public class NKmultiply {
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

    public static void main(String[] args) {
        multiply(new int[]{1,2,3,4,5});
    }
}
