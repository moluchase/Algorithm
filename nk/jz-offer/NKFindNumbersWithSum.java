import java.util.ArrayList;

public class NKFindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arr=new ArrayList<>();
        int i,j;
        i=0;
        j=array.length-1;
        while (i<j){
            if(array[i]+array[j]==sum){
                arr.add(array[i]);
                arr.add(array[j]);
                return arr;
            }else if(array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=FindNumbersWithSum(new int[]{1,2,4,7,11,15},15);
        for(int index=0;index<arr.size();index++){
            System.out.println(arr.get(index));
        }
    }
}
