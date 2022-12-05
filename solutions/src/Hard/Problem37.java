package Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem37 {
    public void solveSudoku(char[][] board) {
        Stack<int[]> attempted = new Stack<>();
        Stack<int[]> toBeFilled = new Stack<>();
        Map<Character, Character> nextValue = new HashMap<>() {{
            put('1', '2');
            put('2', '3');
            put('3', '4');
            put('4', '5');
            put('5', '6');
            put('6', '7');
            put('7', '8');
            put('8', '9');
            put('9', '0');
        }};

        for (int i = 8; i >= 0; --i)
            for (int j = 8; j >= 0; --j)
                if (board[i][j] == '.')
                    toBeFilled.push(new int[]{i, j});

        while (!toBeFilled.isEmpty()) {
            var cell = toBeFilled.pop();
            char option;
            if (board[cell[0]][cell[1]] == '.')
                option = '1';
            else
                option = nextValue.get(board[cell[0]][cell[1]]);
            if (option == '0') {
                board[cell[0]][cell[1]] = '.';
                toBeFilled.push(cell);
                toBeFilled.push(attempted.pop());
                continue;
            }
            board[cell[0]][cell[1]] = option;
            boolean conflict = false;
            for (int i = 0; i < 9; ++i) {
                if (i != cell[0] && board[i][cell[1]] == option) {
                    conflict = true;
                    break;
                }
                if (i != cell[1] && board[cell[0]][i] == option) {
                    conflict = true;
                    break;
                }
            }
            int verticalOffset = (cell[0] / 3) * 3, horizontalOffset = (cell[1] / 3) * 3;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (i + verticalOffset != cell[0] && j + horizontalOffset != cell[1] && board[i + verticalOffset][j + horizontalOffset] == option) {
                        conflict = true;
                        break;
                    }
                }
            }
            if (conflict) {
                toBeFilled.push(cell);
            } else {
                attempted.push(cell);
            }
        }
    }

    public static void main(String[] args) {
        Problem37 problem37 = new Problem37();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        for (var row: board)
            System.out.println(Arrays.toString(row));
        System.out.println("---------------------------------------------");
        problem37.solveSudoku(board);
        for (var row: board)
            System.out.println(Arrays.toString(row));
        System.out.println("---------------------------------------------");
    }
}
