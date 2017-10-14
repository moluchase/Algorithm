public class NKAdd {
    public static int Add(int num1,int num2) {
        return ((num1&num2)<<1)!=0?Add(num1^num2,(num1&num2)<<1):num1^num2;
    }

    public static void main(String[] args) {
        System.out.println(Add(-1,2));
    }
}
