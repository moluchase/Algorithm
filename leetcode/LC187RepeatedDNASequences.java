import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pengsong
 * @date 17/12/19 上午9:11
 */
/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
/*
看了看discuss，我还以为有什么kmp等算法呢，就是简单地牺牲空间复杂度而已
排第一的代码还clean呢，好多没必要做的东西，我是觉得没必要的，下面这个代码完全可以替代之
学习学习
 */
public class LC187RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<>(),set2=new HashSet<>();
        for(int i=0;i+9<s.length();i++){
            String temp=s.substring(i,i+10);
            if(!set.add(temp))set2.add(temp);
        }
        return new ArrayList<>(set2);
    }

    public static void main(String[] args) {
        System.out.println(1|3);
    }
}
