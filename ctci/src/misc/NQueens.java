package misc;

import java.util.ArrayList;
import java.util.List;

class NQueens {
	
	public static void main(String[] args) {
		//NQueens n = new NQueens();
		Solution n = new Solution();
		List<List<String>> res= n.solveNQueens(8);
		
		int cnt=0;
		for(List<String> a: res) {
			for(String b: a) {
				System.out.println(b);
			}
			cnt++;
			System.out.println();
		}
		System.out.println(cnt);
	}
	
    final static char q = 'Q';
    
    public List<List<String>> solveNQueens(int n) {
        String d = ".";
        StringBuilder a = new StringBuilder();
        for(int i=0; i<n; i++){
            a.append(d);
        }
        
        String[] queenPos = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder c = new StringBuilder(a);
            c.setCharAt(i, q);
            queenPos[i] = c.toString();
        }
        
        List<List<String>> finalSol = new ArrayList<>();
        posIter(0, n, finalSol, new ArrayList<String>(), queenPos);
        return finalSol;
    }
    
    public boolean posIter(int qRow, int cols, List<List<String>> finalSol,
                                    List<String> currSol, String[] queenPos){
        if(qRow == cols){
            finalSol.add(currSol);
            return true;
        }
        
        for(int qCol=0; qCol<cols; qCol++){
            Boolean isSafe = true;
            
            for(int currRow=0; currRow<currSol.size(); currRow++){
                
                if( isNotSafeLoc(currSol.get(currRow), currRow, qRow, qCol)){
                    isSafe = false;
                    break;
                }
            }
            
            if(isSafe){
                currSol.add(queenPos[qCol]);
                if(posIter(qRow+1, cols, finalSol, currSol, queenPos)){
                   return true;
                }
                else {
                	currSol.remove(queenPos[qCol]);
                }
            } 
        }
        return false;
    }
    
    public boolean isNotSafeLoc(String queen, int currRow, int qRow, int qCol){
        int currCol = queen.indexOf(q);
        boolean rs = (queen.charAt(qCol) == q)
                        || (currRow-currCol == qRow-qCol)
                        || (currRow+currCol == qRow+qCol);
        return rs;
    }
}

class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        solve(result, new int[n], 0, new char[n]);
        return result;
    }
    
    // rescursive solution
    void solve(List<List<String>> result, int[] board, int x, char[] buffer) {
        int n = board.length;
        if (x == n) {
            result.add(print(board, buffer));
            return;
        }
        for (int y=0; y < n; y++) {
            if (valid(board, x, y)) {
                board[x] = y;
                solve(result, board, x + 1, buffer);
            }
        }
    }
    
    // checks if the x,y is valid (only consideres left half of board)
    boolean valid(int[] board, int x, int y) {
        
        // horizontal going to the left
        for (int i=0; i < x; i++) {
            if (board[i] == y)
                return false;
        }
        
        // diagonal going up and to the left
        int cx = x-1, cy = y-1;
        while (cx >= 0 && cy >= 0) {
            if (board[cx] == cy)
                return false;
            cx--;
            cy--;
        }
        
        // diagonal going down and to the left 
        cx = x-1; cy = y + 1;
        while (cx >= 0 && cy < board.length) {
            if (board[cx] == cy)
                return false;
            cx--;
            cy++;
        }
        
        return true;
    }
    
    // prints the board
    List<String> print(int[] board, char[] buffer) {
        int n = board.length;
        ArrayList<String> list = new ArrayList<>(n);
        for (int y=0; y < n; y++) {
            for (int x=0; x < n; x++) {
                buffer[x] = board[x] == y ? 'Q' : '.';
            }
            list.add(new String(buffer));
        }
        return list;
    }
}
