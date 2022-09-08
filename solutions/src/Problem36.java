import java.util.HashSet;
import java.util.Set;

public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        int i, j, k, l;

        for (char[] row: board) {
            for (char elem: row)
                if (elem != '.' && !set.add(elem))
                    return false;
            set.clear();
        }

        for (i = 0; i < 9; ++i) {
            for (j = 0; j < 9; ++j)
                if (board[j][i] != '.' && !set.add(board[j][i]))
                    return false;
            set.clear();
        }

        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 3; ++j) {
                for (k = 0; k < 3; ++k) {
                    for (l = 0; l < 3; ++l) {
                        if (board[i * 3 + k][j * 3 + l] != '.' && !set.add(board[i * 3 + k][j * 3 + l]))
                            return false;
                    }
                }
                set.clear();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem36 problem36 = new Problem36();
        char[][] board = new char[][]{
                new char[]{'8','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(problem36.isValidSudoku(board));
    }
}
