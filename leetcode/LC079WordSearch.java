/**
 * @author pengsong
 * @date 17/10/22 下午11:38
 */

/*
079.Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

/*
两个for循环+DFS
 */

public class LC079WordSearch {
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (findWord(board, word, flag, i, j, n, m)) return true;
            }
        }
        return false;
    }

    private static boolean findWord(char[][] board, String word, boolean[][] flag, int i, int j, int n, int m) {
        boolean result = false;
        if (word.length() == 0) return true;
        if (!((i >= 0 && i < n) && (j >= 0 && j < m))) return false;
        if (word.charAt(0) != board[i][j] || flag[i][j] == true) return false;
        else {
            flag[i][j] = true;
            result = findWord(board, word.substring(1), flag, i, j + 1, n, m) ||
                    findWord(board, word.substring(1), flag, i + 1, j, n, m) ||
                    findWord(board, word.substring(1), flag, i, j - 1, n, m) ||
                    findWord(board, word.substring(1), flag, i - 1, j, n, m);
            flag[i][j] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        System.out.println(exist(board, "ab"));
    }
}
