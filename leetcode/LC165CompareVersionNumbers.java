/**
 * @author pengsong
 * @date 17/12/13 上午9:42
 */
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

 */
/*
easy的题目吧，就是一些问题给遗漏了
 */
public class LC165CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String []v1=version1.split("\\.");
        String []v2=version2.split("\\.");
        //System.out.println(v1[0]+","+v2[0]);
        if(v1==null||v1.length==0)v1=new String[]{version1};
        if(v2==null||v2.length==0)v2=new String[]{version2};
        //System.out.println(v1[0]+","+v2[0]);
        int i=0;
        while (i<v1.length||i<v2.length){
            if(i<v1.length&&i<v2.length){
                int temp=Integer.parseInt(v1[i])-Integer.parseInt(v2[i]);
                if(temp>0)return 1;
                else if(temp<0)return -1;
                i++;
            }else if(i<v1.length){
                while (i<v1.length){
                    int temp=Integer.parseInt(v1[i]);
                    if(temp>0)return 1;
                    i++;
                }
            }else {
                while (i<v2.length){
                    int temp=Integer.parseInt(v2[i]);
                    if(temp>0)return -1;
                    i++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("1.0","1.1");
        //System.out.println("12".compareTo("2"));
        String []v1="1.2".split(".");
        for(String s:v1){
            System.out.println(s);
        }
    }
}
