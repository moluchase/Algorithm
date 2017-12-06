import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/27 上午9:12
 */
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */

/*
很开心能看到图的题目
用BFS解决
参考：http://blog.csdn.net/linhuanmars/article/details/23029973
http://blog.csdn.net/qq508618087/article/details/51344102

广度优先遍历，但是还是超时了
主要是字符串比较的时候取巧了
 */
public class LC127WordLadder {
    /*
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null||endWord==null||beginWord.length()==0||endWord.length()==0||beginWord.length()!=endWord.length())return 0;
        LinkedList<String>queue=new LinkedList<>();
        int level=1;
        int lastNum=1;
        int curNum=0;
        if(!wordList.contains(endWord))return 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            String temp=queue.poll();
            lastNum--;
            for(int i=0;i<temp.length();i++){
                char[] chars=temp.toCharArray();
                char t=chars[i];
                for(char c='a';c<='z';c++){
                    if(t==c)continue;
                    chars[i]=c;
                    String temp2=new String(chars);
                    if(temp2.equals(endWord))return level+1;
                    if(wordList.contains(temp2)){
                        queue.offer(temp2);
                        wordList.remove(temp2);
                        curNum++;
                    }
                }
            }
            if(lastNum==0){
                lastNum=curNum;
                curNum=0;
                level++;
            }
        }
        return 0;
    }
    */

    public int ladderLength(String start, String end, List<String> dict) {
        if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
            return 0;
        LinkedList<String> queue = new LinkedList<String>();
        List<String> visited = new ArrayList<>();
        int level= 1;
        int lastNum = 1;
        int curNum = 0;
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty())
        {
            String cur = queue.poll();
            lastNum--;
            for(int i=0;i<cur.length();i++)
            {
                char[] charCur = cur.toCharArray();
                for(char c='a';c<='z';c++)
                {
                    charCur[i] = c;
                    String temp = new String(charCur);
                    if(temp.equals(end))
                        return level+1;
                    if(dict.contains(temp) && !visited.contains(temp))
                    {
                        curNum++;
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            if(lastNum==0)
            {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }
}
