import java.util.ArrayList;


public class NKmaxInWindows {
    static int index;
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer>arr=new ArrayList<>();
        int maxvalue;
        int temp;
        int i=0;
        int start,end;
        start=0;
        end=size-1;
        if(num.length<size||size==0)return arr;
        maxvalue=num[0];
        index=0;
        for(;i<size;i++){
            if(maxvalue<num[i]){
                maxvalue=num[i];
                index=i;
            }
        }
        arr.add(maxvalue);
        for (;i<num.length;i++){
            start++;
            if(index>=start&&index<=i){
                if(maxvalue<num[i]){
                    maxvalue=num[i];
                    index=i;
                }
                arr.add(maxvalue);
            } else {
                maxvalue=getMax(num,start,i);
                arr.add(maxvalue);
            }
        }
        return arr;
    }

    private static int getMax(int[] num, int start, int end) {
        int maxnum=num[start];
        for(int i=start;i<=end;i++){
            if(maxnum<num[i]){
                maxnum=num[i];
                index=i;
            }
        }
        return maxnum;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr=maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+",");
        }

        //System.out.println(getMax(new int[]{2,5,1},0,2));
    }
}
