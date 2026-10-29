
public class NQueens
{
    static int n = 4; // size of the chessboard and number of queens

    // check if placing a queen at the given position is safe
    static boolean safe(int[][] board, int row, int col)
    {
        // check for another queen in the same column above
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // check the upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // check the upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        // no queen can attack this position
        return true;
    }

    // place one queen in each row using backtracking
    static boolean solve(int[][] board, int row)
    {
        // all queens have been placed successfully
        if (row == n)
            return true;

        // try placing a queen in every column of the current row
        for (int col = 0; col < n; col++)
        {
            // place the queen only if the position is safe
            if (safe(board, row, col))
            {
                board[row][col] = 1;

                // recursively place a queen in the next row
                if (solve(board, row + 1))
                    return true;

                // remove the queen and try another column
                board[row][col] = 0;
            }
        }

        // no valid position was found in this row
        return false;
    }

    public static void main(String[] args)
    {
        int[][] board = new int[n][n]; // initialize an empty chessboard

        // start placing queens from the first row
        if (solve(board, 0))
        {
            // print the solution board
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");

                System.out.println(); // move to the next row
            }
        }
        else
            System.out.println("no solution"); // no valid arrangement exists
    }
}
