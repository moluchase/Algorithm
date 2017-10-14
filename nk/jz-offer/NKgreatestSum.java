public class NKgreatestSum {

    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum=array[0];
        int maxsum=array[0];
        for(int i=1;i<array.length;i++){
            if(sum+array[i]<0){
                sum=0;
            }else {
                sum+=array[i];
            }
            if(maxsum<sum){
                maxsum=sum;
            }
        }
        //如果全部为负数，maxsum得到的结果是0，需要找到其中最大的值
        if(maxsum==0){
            maxsum=array[0];
            for(int i=1;i<array.length;i++){
                if(maxsum<array[i]){
                    maxsum=array[i];
                }
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }
}
