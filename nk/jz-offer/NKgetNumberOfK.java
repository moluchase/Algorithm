public class NKgetNumberOfK {
    public static int GetNumberOfK(int [] array , int k) {
        int low=0;
        int high=array.length-1;
        int middle=(high-low)/2;
        int num=0;
        int flag=0;
        while (low<=high){
            if(array[middle]==k){
                flag=1;
                break;
            }else if(array[middle]>k){
                high=middle-1;
            }else {
                low=middle+1;
            }
            middle=low+(high-low)/2;
        }
        if(flag==0){
            return 0;
        }
        low=high=middle;
        while (low>=0&&array[low--]==k)num++;
        while (++high<array.length&&array[high]==k)num++;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{4,4,4,4},4));
    }
}
