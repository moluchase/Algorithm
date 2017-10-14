import java.util.ArrayList;

public class NKreOrderArray {
    public static void reOrderArray(int [] array) {
        //ArrayList<Integer> temp=new ArrayList<Integer>();
        ArrayList<Integer> temp=new ArrayList<>();
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                temp.add(array[i]);
            }else{
                array[index]=array[i];
                index++;
            }
        }
        for(int i=0;i<temp.size();i++){
            array[index]=temp.get(i);
            index++;
        }
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        reOrderArray(new int[]{2,4,6,1,3,5,7});
    }
}
