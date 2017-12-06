import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/25 上午9:31
 */

/*
Given two words (beginWord and endWord), and a dictionary's word list,
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings).
Please reload the code definition to get the latest changes.
 */

/*
下面这个代码够复杂的，写的时候就担心会超时，果然超时了
leetcode : 19/39
讲一下我思路：从开始的字符串起，在wordList中找出只改变一个字符的字符串，添加进来，继续，直到找到和结尾字符串相同的字符串，查看长度，是否需要添加
继续for循环
这就是深度优先遍历的思想

先放着吧，。。。
 */
public class LC126WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>>lists=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add(beginWord);
        findLadders(lists,list,beginWord,endWord,wordList);
        return lists;
    }

    private void findLadders(List<List<String>> lists, List<String> list, String curr, String endWord, List<String> wordList) {
        if(curr.equals(endWord)){
            if(lists.size()==0){
                lists.add(new ArrayList<>(list));
            }else {
                if(lists.get(0).size()>list.size()){
                    while (!lists.isEmpty())lists.remove(0);
                    lists.add(new ArrayList<>(list));
                }else if(lists.get(0).size()==list.size()){
                    lists.add(new ArrayList<>(list));
                }
            }
        }
        if(wordList.isEmpty()||(lists.size()>0&&list.size()>=lists.get(0).size()))return;
        for(int i=0;i<wordList.size();i++){
            String temp=wordList.get(i);
            if(diffOneChar(curr,temp)){
                list.add(temp);
                wordList.remove(i);
                findLadders(lists,list,temp,endWord,wordList);
                wordList.add(i,temp);
                list.remove(list.size()-1);
            }
        }
    }
    //字符长度相等
    private boolean diffOneChar(String curr, String s) {
        int num=0;
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)!=s.charAt(i))num++;
        }
        if(num==1)return true;
        return false;
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("abcdefg");
        list.add("bcdefgh");
        list.add("cdefghi");
        list.add("defghik");
        list.remove("cdefghi");
        list.add(2,"cdefghi");
        for(String s:list){
            System.out.println(s);
        }
    }
}
