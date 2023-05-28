package Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import Medium.Problem212;

public class Problem212 {	
	public List<String> findWords(char[][] board, String[] words) {
		List<List<int[]>> starts = new ArrayList<List<int[]>>(26);
		while (starts.size() < 26) starts.add(new ArrayList<int[]>());
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				starts.get(board[i][j] - 'a').add(new int[]{i, j});
			}     
		}
		
		List<String> result = new ArrayList<String>();
		int[][] used = new int[board.length][board[0].length];
		
		for (String word: words) {
			for (int[] start: starts.get(word.charAt(0) - 'a')) 
				if (checkCoordinate(word, board, used, start[0], start[1], 0)) {
					result.add(word);
					break;
				}
		}
		
		return result;
	}
	
	private boolean checkCoordinateIsValid(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		return false;	
	}
	
	private boolean checkCoordinate(String word, char[][] board, int[][] used, int i, int j, int pointer) {
		if (!checkCoordinateIsValid(board, i, j) && (board[i][j] < 'a' || board[i][j] != word.charAt(pointer)))
			return false;
		
		if (pointer == word.length())
			return true;
		
		board[i][j] -= 'a';
		
		if (i > 0 && checkCoordinate(word, board, used, i - 1, j, pointer + 1))
			return true;
			
		if (i < board.length - 1 && checkCoordinate(word, board, used, i + 1, j, pointer + 1))
			return true;
		
		if (j > 0 && checkCoordinate(word, board, used, i, j - 1, pointer + 1))
			return true;
		
		if (j < board[0].length && checkCoordinate(word, board, used, i, j - 1, pointer + 1))
			return true;
		
		board[i][j] += 'a';
		return false;
	}

	public static void main(String[] args) {
		Problem212 problem212 = new Problem212();
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		for (String word: problem212.findWords(board, words))
			System.out.println(word);
	}
}