import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {
	private int m = 0;
	private int n = 0;
	private boolean[][] visited = null;
	private char[][] board = null;

	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		this.m = board.length;
		this.n = board[0].length;
		this.visited = new boolean[m][n];//bfs visited
		this.board = board;
	
		for(int j=0;j<n;j++){
			if(board[0][j] == 'O' && visited[0][j] == false)//start from top boundary 
				bfs(0,j);
			if(board[m-1][j] == 'O' && visited[m-1][j] == false)//start from bottom boundary
				bfs(m-1,j);
		}	
		for(int i=0;i<m;i++){
			if(board[i][0] == 'O' && visited[i][0] == false)//start from left boundary
				bfs(i,0);
			if(board[i][n-1] == 'O' && visited[i][n-1] == false)//start from right boundary
				bfs(i,n-1);
		}	
		flipOtoX();
//		print(visited);
		print(board);
    }
	private void bfs(int x, int y){
		Queue<Integer> row = new LinkedList<>();//visited row index
		Queue<Integer> column = new LinkedList<>();//visited column index
		row.add(x);
		column.add(y);
		while(!row.isEmpty()){
			int i = row.remove();
			int j = column.remove();
			if(i>=0 && i<m && j>=0 && j<n && board[i][j] == 'O' && visited[i][j] == false){
				visited[i][j] = true;
				row.add(i-1);column.add(j);
				row.add(i+1);column.add(j);
				row.add(i);column.add(j-1);
				row.add(i);column.add(j+1);
			}		
		}		
	}

	private void flipOtoX(){
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(board[i][j] == 'O' && visited[i][j] == false)
					board[i][j] = 'X';
	
	}
	public static void main(String[] args){
//		char[][] board = new char[][]{{'X','X','X','X','',''},
//				                      {'X','O','O','X','',''},
//				                      {'X','X','O','X','',''},
//				                      {'X','O','X','X','',''}};
//		char[][] board = new char[][]{{'X','O','X','O','X','O'},
//                                      {'O','X','O','X','O','X'},
//                                      {'X','O','X','O','X','O'},
//                                      {'O','X','O','X','O','X'}};
		char[][] board = new char[][]{{'O','X'},{'X','X'}};
		SurroundedRegions  s = new SurroundedRegions ();
		s.solve(board);
		
	}
	private void print(boolean[][] A){
		for(boolean[] row:A){
			for(boolean b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}
	private void print(char[][] A){
		for(char[] row:A){
			for(char b :row){
				System.out.print(b+", ");
			}
			System.out.println();
		}
	}

}
