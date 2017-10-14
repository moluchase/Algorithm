import java.util.*;

public class LCgroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> lists=new ArrayList<>();
        char[] chars;
        String temp;
        for(int i=0;i<strs.length;i++){
            chars=strs[i].toCharArray();
            Arrays.sort(chars);
            temp=new String(chars);
            if(map.get(temp)==null){
                List<String> list=new ArrayList<>();
                map.put(temp,list);
            }
            map.get(temp).add(strs[i]);
        }
        for(String s :map.keySet()){
            lists.add(map.get(s));
        }
        return lists;
        /*
        Iterator<String> iterable=set.iterator();
        while (iterable.hasNext()){
            temp=iterable.next();
            System.out.println(iterable.next());
        }
        */
    }

    public static void main(String[] args) {
        String str="sjkjlodn";
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        str=new String(chars);
        System.out.println(str);
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

    }
}
