import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NKprintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        String result="";
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1);
                String s2=String.valueOf(o2);
                return (s1+s2).compareTo(s2+s1);
            }
        });
        for (int i:list) {
            result+=i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3,5,1,4,2}));
        //System.out.println("3213".compareTo("3321"));
    }
}
