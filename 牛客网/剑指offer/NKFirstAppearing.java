import java.util.ArrayList;

public class NKFirstAppearing {
    int[] chars=new int[256];
    ArrayList<Character> list=new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        list.add(ch);
        chars[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(int i=0;i<list.size();i++){
            if(chars[list.get(i)]==1){
                return list.get(i);
            }
        }
        return '#';
    }
}
