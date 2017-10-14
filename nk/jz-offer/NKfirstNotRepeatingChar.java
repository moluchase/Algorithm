import java.util.ArrayList;

public class NKfirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {
        ArrayList<Character> chars=new ArrayList<>();
        ArrayList<Integer> charIndex=new ArrayList<>();
        int[] charsNum=new int[26*2];//默认为0
        char temp;
        for(int i=0;i<str.length();i++){
            temp=str.charAt(i);
            if(temp>='A'&&temp<='Z'){
                if(charsNum[temp-'A'+26]==0){
                    chars.add(temp);
                    charIndex.add(i+1);
                }
                charsNum[temp-'A'+26]+=1;
            }else {
                if(charsNum[temp-'a']==0){
                    chars.add(temp);
                    charIndex.add(i+1);
                }
                charsNum[temp-'a']+=1;
            }

        }
        for(int i=0;i<chars.size();i++){
            temp=chars.get(i);
            if(temp>='A'&&temp<='Z'){
                if(charsNum[temp-'A'+26]==1){
                    return charIndex.get(i);
                }
            }else {
                if(charsNum[temp-'a']==1){
                    return charIndex.get(i);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("abcdsbcds"));
    }
}
