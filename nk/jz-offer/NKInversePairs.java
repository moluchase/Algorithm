public class NKInversePairs {
    static int count=0;
    public static int InversePairs(int [] array) {
        if(array.length==0)return 0;
        int[] copyarr=new int[array.length];
        mergeSort(array,copyarr,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
        System.out.println();
        return count;
    }

    private static void mergeSort(int[] array,int[]copyarr, int i, int length) {
        if(length>i){
            int mid=(length+i)/2;
            mergeSort(array,copyarr,i,mid);
            mergeSort(array,copyarr,mid+1,length);
            merge(array,copyarr,i,mid,length);
        }
        //return 0;
    }

    private static void merge(int[] array, int[] copyarr, int i, int mid, int length) {
        int indexi,indexj,indexk;
        indexi=mid;
        indexj=indexk=length;
        //count=0;
        while (indexi>=i&&indexj>=mid+1){
            if(array[indexi]>array[indexj]){
                count+=indexj-mid;
                count=count%1000000007;
                copyarr[indexk]=array[indexi];
                //System.out.println("count:"+count+","+(indexj-mid));
                indexi--;
            }else {
                copyarr[indexk]=array[indexj];
                indexj--;
            }
            indexk--;
        }
        if(indexi>=i){
            while (indexi>=i){
                copyarr[indexk]=array[indexi];
                indexi--;
                indexk--;
            }
        }else {
            while (indexj>=mid+1){
                copyarr[indexk]=array[indexj];
                indexj--;
                indexk--;
            }
        }
        indexi=i;
        while (indexi<=length){
            array[indexi]=copyarr[indexi];
            indexi++;
        }
        //return count;
    }

    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{5,6,4,3,4,2,5,2,3,56,43,2,57,3,2,9,42}));
        //int a=1111111111;
        //System.out.println(a);
    }
}
