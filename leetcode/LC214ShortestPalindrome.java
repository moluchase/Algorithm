/**
 * @author pengsong
 * @date 17/12/27 上午8:37
 */
/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
Find and return the shortest palindrome you can find by performing this transformation.
For example:
Given "aacecaaa", return "aaacecaaa".
Given "abcd", return "dcbabcd".
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.
 Thanks to @Freezen for additional test cases.
 */
/*
这个解法倒是非常经典，但是我好像不是很好证明
https://discuss.leetcode.com/topic/21068/my-7-lines-recursive-java-solution
大意就是分割字符串为前部分和后部分，前部分可能是回文串（相当于子串），后半部分一定不是回文串


 */
public class LC214ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}
