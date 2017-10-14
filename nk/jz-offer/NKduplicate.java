public class NKduplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] flags=new int[length];
        for(int i=0;i<length;i++){
            if(flags[numbers[i]]==0){
                flags[numbers[i]]++;
            }else {
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
}
