from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for _ in range(n)] for _ in range(n)]
        return self.queens(board, 0)

    def queens(self, board: List[List[bool]], row: int) -> List[List[str]]:
        if row == len(board):
            return self.boardConfig(board)
        
        ans = []
        
        for col in range(len(board[0])):
            if self.isSafe(board, row, col):
                board[row][col] = True  # Place queen
                ans.extend(self.queens(board, row + 1))  # Recursively solve for the next row
                board[row][col] = False  # Backtrack
        
        return ans

    def isSafe(self, board: List[List[bool]], row: int, col: int) -> bool:
        # Check column
        for i in range(row):
            if board[i][col]:
                return False

        # Check left diagonal
        i, j = row, col
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1

        # Check right diagonal
        i, j = row, col
        while i >= 0 and j < len(board[0]):
            if board[i][j]:
                return False
            i -= 1
            j += 1

        return True

    def boardConfig(self, board: List[List[bool]]) -> List[List[str]]:
        result = []
        config = []
        
        for row in board:
            row_str = ''.join("Q" if cell else "." for cell in row)
            config.append(row_str)
        
        result.append(config)
        return result
