public class LC066PlusOne {
    public int[] plusOne(int[] digits) {
        int n=digits.length-1;
        while (n>=0&&(digits[n]=(digits[n]+1)%10)==0)n--;
        if(n<0){
            int [] digits2=new int[digits.length+1];
            digits2[0]=1;
            for(int i=1;i<digits2.length;i++)digits2[i]=digits[i-1];
            return digits2;
        }
        return digits;
    }
}
