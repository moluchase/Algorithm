public class NKFindNumsAppearOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length<2)return;
        int temp=0,temp2=0;
        String stemp;
        int index;
        for(int i=0;i<array.length;i++){
            temp^=array[i];
        }
        stemp=Integer.toBinaryString(temp);
        index=stemp.length();
        while (--index>=0){
            if(stemp.charAt(index)=='1') break;
        }
        temp=0;
        index=stemp.length()-index;
        for(int i=0;i<array.length;i++){
            stemp=Integer.toBinaryString(array[i]);
            if(index<=stemp.length()&&stemp.charAt(stemp.length()-index)=='1'){
                temp^=array[i];
            }else {
                temp2^=array[i];
            }
        }
        num1[0]=temp;
        num2[0]=temp2;

    }

    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{4,6,1,1,1,1},new int[]{0},new int[]{0});
    }
}
