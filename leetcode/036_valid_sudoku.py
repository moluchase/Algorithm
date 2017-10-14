class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        num=[0]*9
        for s in board:
            for i in s:
                if i!='.':
                    num[int(i)-1]+=1
            for i in num:
                if i>=2:return False
            num=[0]*9
        for j in range(9):
            for s in board:
                if s[j]!='.':num[int(s[j])-1]+=1
            for i in num:
                if i>=2:return False
            num=[0]*9
        k=0
        p=0
        while k<9:
            while p<9:
                for i in range(3):
                    for j in range(3):
                        if board[i+k][j+p]!='.':num[int(board[i + k][j + p])-1]+=1
                for i in num:
                    if i >= 2: return False
                print(num)
                num = [0] * 9
                p+=3
            k+=3
            p=0
        return True

    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        for i in range(9):
            num1=[j for j in board[i] if j!='.']
            num2=['1','2','3','4','5','6','7','8','9']
            for j in num1:
                num2.pop(num1.index(j))
            for j in range(9):
                c=board[i][j]
                if c=='.':
                    for k in num2:
                        board[i][j]=k
                        if self.isValidSudoku(board):
                            self.solveSudoku(board)





s=Solution()
print(s.isValidSudoku(["....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"]))

board=["....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"]
for i in range(9):
    for j in range(9):
        print(board[i][j],end="\t")
    print()